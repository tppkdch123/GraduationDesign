package org.graduationdesign.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.graduationdesign.entity.Provider;
import org.graduationdesign.entity.ProviderExample;
import org.graduationdesign.entity.User;
import org.graduationdesign.entity.UserExample;
import org.graduationdesign.enums.CommenEnum;
import org.graduationdesign.enums.EmailTemplateEnum;
import org.graduationdesign.enums.ResultCodeEnum;
import org.graduationdesign.enums.TimeEnum;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.mappers.ProviderMapper;
import org.graduationdesign.mappers.UserMapper;
import org.graduationdesign.service.UserService;
import org.graduationdesign.util.CommonUtil;
import org.graduationdesign.util.EmailUtil;
import org.graduationdesign.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    EmailUtil emailUtil;

    @Autowired
    JedisPool jedisPool;

    @Autowired
    ProviderMapper providerMapper;

    private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private static String LOG_PREFIX = "[用户相关] ";

    private static final String PREFIX = "register-verificationCode-";

    private static final String LPREFIX = "login-verificationCode-";

    private static final String RPREFIX = "sign-";

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void registerVerification(String email) throws HuangShiZheException {

        EmailUtil.ifEmail(email);

        if (!userIfExits(email)) {
            String verificationCode = CommonUtil.generateRandomVerificationCode();
            if (!jedisPool.getResource().exists(PREFIX + email)) {
                jedisPool.getResource().setex(PREFIX + email, 120, verificationCode);
            } else {
                throw new HuangShiZheException(ResultCodeEnum.ALREADY_SEND);
            }
            try {
                sendVerification(email, verificationCode, EmailTemplateEnum.REGISTER_VERIFICATION);
            } catch (Exception e) {
                LOGGER.error("{},发送注册验证码出现异常", LOG_PREFIX);
                throw new HuangShiZheException(ResultCodeEnum.ERROR, e);
            }
        } else {
            throw new HuangShiZheException(ResultCodeEnum.USER_ALREADY_EXIT);
        }
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void simpleRegister(String email, String verificationCode) throws HuangShiZheException {

        EmailUtil.ifEmail(email);
        String code = jedisPool.getResource().get(PREFIX + email);
        if (StringUtils.isEmpty(code)) {
            throw new HuangShiZheException(ResultCodeEnum.TIME_OUT);
        }

        if (code.equals(verificationCode)) {
            User user = new User();
            user.setCreateTime(new Date());
            user.setEmail(email);
            user.setIsActive(true);
            user.setIsDelete(false);
            user.setUpdateTime(new Date());
            userMapper.insert(user);
        } else {
            throw new HuangShiZheException(ResultCodeEnum.CODE_ERROR);
        }
    }

    @Override
    public Boolean userIfExits(String email) throws HuangShiZheException {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIsDeleteEqualTo(false).andEmailEqualTo(email);
        int count = userMapper.countByExample(userExample);
        return count == 0 ? false : true;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void login(String email, String verificationCode, HttpServletResponse response) throws HuangShiZheException {
        EmailUtil.ifEmail(email);
        if (userIfExits(email)) {
            String code = jedisPool.getResource().get(LPREFIX + email);
            if (StringUtils.isNotEmpty(code) && code.equals(verificationCode)) {
                String token = UUID.randomUUID().toString();
                Cookie cookie = new Cookie(CommenEnum.huangshizhetianxiadiyi.toString(), token);
                cookie.setPath("/");
                cookie.setMaxAge(TimeEnum.TOKEN_TIEMOUT.getValue());
                response.addCookie(cookie);
                String sign = jedisPool.getResource().get(RPREFIX + email);
                if (sign != null) {
                    jedisPool.getResource().del(sign);
                }
                jedisPool.getResource().setex(RPREFIX + email, TimeEnum.TOKEN_TIEMOUT.getValue(), token);
                jedisPool.getResource().setex(token, TimeEnum.TOKEN_TIEMOUT.getValue(), email);
                return;
            } else {
                throw new HuangShiZheException(ResultCodeEnum.CODE_ERROR);
            }
        } else {
            throw new HuangShiZheException(ResultCodeEnum.USER_NOT_EXIT);
        }
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void sendLoginVerification(String email) throws HuangShiZheException {
        EmailUtil.ifEmail(email);
        if (userIfExits(email)) {
            String verificationCode = CommonUtil.generateRandomVerificationCode();
            if (jedisPool.getResource().exists(LPREFIX + email)) {
                throw new HuangShiZheException(ResultCodeEnum.ALREADY_SEND);
            }
            try {
                jedisPool.getResource().setex(LPREFIX + email, 120, verificationCode);
                sendVerification(email, verificationCode, EmailTemplateEnum.LOGIN_VERIFICATION);
            } catch (Exception e) {
                LOGGER.warn("{}发送登录验证码出现异常", LOG_PREFIX);
                throw new HuangShiZheException(ResultCodeEnum.ERROR, e);
            }
        } else {
            throw new HuangShiZheException(ResultCodeEnum.USER_NOT_EXIT);
        }
    }

    @Override
    public User getCurrentUser(HttpServletRequest request) throws HuangShiZheException {
        String token = findToken(request);
        if (StringUtils.isEmpty(token)) {
            throw new HuangShiZheException(ResultCodeEnum.TOKEN_INVAILD);
        }
        String email = findEmail(token);
        if (!userIfExits(email)) {
            throw new HuangShiZheException(ResultCodeEnum.USER_NOT_EXIT);
        }
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(email).andIsDeleteEqualTo(false);
        List<User> userList = userMapper.selectByExample(userExample);

        if (CollectionUtils.isEmpty(userList)) {
            throw new HuangShiZheException(ResultCodeEnum.USER_NOT_EXIT);
        }

        return userList.get(0);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void login(HttpServletResponse response, String email, String password) throws HuangShiZheException {
        EmailUtil.ifEmail(email);
        if (!userIfExits(email)) {
            throw new HuangShiZheException(ResultCodeEnum.USER_NOT_EXIT);
        }
        boolean b = userMapper.judgePassword(password, email);
        if (b) {
            String token = UUID.randomUUID().toString();
            Cookie cookie = new Cookie(CommenEnum.huangshizhetianxiadiyi.toString(), token);
            cookie.setMaxAge(TimeEnum.TOKEN_TIEMOUT.getValue());
            cookie.setPath("/");
            response.addCookie(cookie);
            String sign = jedisPool.getResource().get(RPREFIX + email);
            if (sign != null) {
                jedisPool.getResource().del(sign);
            }
            jedisPool.getResource().setex(RPREFIX + email, TimeEnum.TOKEN_TIEMOUT.getValue(), token);
            jedisPool.getResource().setex(token, TimeEnum.TOKEN_TIEMOUT.getValue(), email);
            return;
        } else {
            throw new HuangShiZheException(ResultCodeEnum.PASSWORD_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void updateInformation(User user) throws HuangShiZheException {
        user.setUpdateTime(new Date());
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIsDeleteEqualTo(false).andIdEqualTo(user.getId());
        userMapper.updateByExampleSelective(user, userExample);
    }

    @Override
    public UserVO getUserInfoById(Long id) throws HuangShiZheException {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id).andIsDeleteEqualTo(false);
        List<User> userList = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(userList)) {
            throw new HuangShiZheException(ResultCodeEnum.USER_NOT_EXIT);
        }
        return convertUser2VO(userList.get(0));
    }

    @Override
    public Provider getProviderByUserId(Long userId) throws HuangShiZheException {
        ProviderExample providerExample = new ProviderExample();
        ProviderExample.Criteria criteria = providerExample.createCriteria();
        criteria.andIsDeleteEqualTo(false).andUseridEqualTo(userId);
        List<Provider> providerList = providerMapper.selectByExample(providerExample);

        if (CollectionUtils.isEmpty(providerList)) {
            throw new HuangShiZheException(ResultCodeEnum.NOT_PROVIDER);
        }
        return providerList.get(0);
    }

    @Override
    public Provider getProviderByEmail(String email) throws HuangShiZheException {
        EmailUtil.ifEmail(email);
        User user = getUserByEmail(email);

        ProviderExample providerExample = new ProviderExample();
        ProviderExample.Criteria criteria = providerExample.createCriteria();
        criteria.andIsDeleteEqualTo(false).andIdEqualTo(user.getId());
        List<Provider> providerList = providerMapper.selectByExample(providerExample);

        if (CollectionUtils.isEmpty(providerList)) {
            throw new HuangShiZheException(ResultCodeEnum.NOT_PROVIDER);
        }
        return providerList.get(0);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void becomeProvider(Long userId) throws HuangShiZheException {
        if(userIfProvider(userId)){
            throw new HuangShiZheException(ResultCodeEnum.ALREADY_PROVIDER);
        }
        Provider provider = new Provider();
        provider.setIsDelete(false);
        provider.setJoinTime(new Date());
        provider.setUserid(userId);
        provider.setCreditScore(0);
        providerMapper.insert(provider);
    }

    @Override
    public User getUserByEmail(String email) throws HuangShiZheException {
        EmailUtil.ifEmail(email);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIsDeleteEqualTo(false).andEmailEqualTo(email);
        List<User> userList = userMapper.selectByExample(userExample);

        if (CollectionUtils.isEmpty(userList)) {
            throw new HuangShiZheException(ResultCodeEnum.USER_NOT_EXIT);
        }

        return userList.get(0);
    }

    @Override
    public Boolean userIfProvider(Long id) throws HuangShiZheException {
        ProviderExample providerExample = new ProviderExample();
        ProviderExample.Criteria criteria = providerExample.createCriteria();
        criteria.andIsDeleteEqualTo(false).andIdEqualTo(id);
        List<Provider> providerList = providerMapper.selectByExample(providerExample);

        if(CollectionUtils.isEmpty(providerList)){
            return false;
        }
        else{
            return true;
        }
    }

    private void sendVerification(String email, String verificationCode, EmailTemplateEnum emailTemplateEnum) throws Exception {
        emailUtil.sendMessageBy163Email(email, emailTemplateEnum.getSubject(), CommonUtil.wireVerificationCode(emailTemplateEnum.getContent(), verificationCode));
    }

    private String findToken(HttpServletRequest request) {
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals(CommenEnum.huangshizhetianxiadiyi.toString())) {
                return cookie.getValue();
            }
        }
        return null;
    }

    private String findEmail(String token) throws HuangShiZheException {
        String email = jedisPool.getResource().get(token);
        if (StringUtils.isEmpty(email)) {
            throw new HuangShiZheException(ResultCodeEnum.TOKEN_INVAILD);
        }
        return email;
    }

    private UserVO convertUser2VO(User user) {
        UserVO userVO = new UserVO();
        userVO.setCreateTime(user.getCreateTime());
        userVO.setEmail(user.getEmail());
        userVO.setId(user.getId());
        userVO.setIsActive(user.getIsActive());
        userVO.setIsDelete(user.getIsDelete());
        userVO.setMobile(user.getMobile());
        userVO.setSex(user.getSex());
        userVO.setUserAvatarUrl(StringUtils.split(user.getUserAvatarUrl(), "\\@")[0]);
        userVO.setName(user.getName());
        userVO.setUpdateTime(user.getUpdateTime());
        return userVO;
    }
}
