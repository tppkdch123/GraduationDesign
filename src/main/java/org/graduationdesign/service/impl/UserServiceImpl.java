package org.graduationdesign.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.graduationdesign.entity.User;
import org.graduationdesign.entity.UserExample;
import org.graduationdesign.enums.CommenEnum;
import org.graduationdesign.enums.EmailTemplateEnum;
import org.graduationdesign.enums.ResultCodeEnum;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.mappers.UserMapper;
import org.graduationdesign.service.UserService;
import org.graduationdesign.util.CommonUtil;
import org.graduationdesign.util.EmailUtil;
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

    private static final String PREFIX = "register-verificationCode-";

    private static final String LPREFIX = "login-verificationCode-";

    private static final String RPREFIX = "sign-";

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void registerVerification(String email) throws HuangShiZheException {

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
                throw new HuangShiZheException(ResultCodeEnum.ERROR, e);
            }
        } else {
            throw new HuangShiZheException(ResultCodeEnum.USER_ALREADY_EXIT);
        }
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void simpleRegister(String email, String verificationCode) throws HuangShiZheException {
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
        if (userIfExits(email)) {
            String code=jedisPool.getResource().get(LPREFIX + email);
            if (StringUtils.isNotEmpty(code)&&code.equals(verificationCode)) {
                String token= UUID.randomUUID().toString();
                response.addCookie(new Cookie(CommenEnum.huangshizhetianxiadiyi.toString(),token));
                String sign=jedisPool.getResource().get(RPREFIX+email);
                if(sign!=null){
                    jedisPool.getResource().del(sign);
                }
                jedisPool.getResource().setex(RPREFIX+email,300,token);
                jedisPool.getResource().setex(token,300,email);
               return;
            }
            else{
                throw new HuangShiZheException(ResultCodeEnum.CODE_ERROR);
            }
        }
        else{
            throw new HuangShiZheException(ResultCodeEnum.USER_NOT_EXIT);
        }
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void sendLoginVerification(String email) throws HuangShiZheException {
        if(userIfExits(email)){
           String verificationCode = CommonUtil.generateRandomVerificationCode();
           if(jedisPool.getResource().exists(LPREFIX+email)){
               throw new HuangShiZheException(ResultCodeEnum.ALREADY_SEND);
           }
            try {
                jedisPool.getResource().setex(LPREFIX+email,120,verificationCode);
                sendVerification(email,verificationCode,EmailTemplateEnum.LOGIN_VERIFICATION);
            } catch (Exception e) {
                throw new HuangShiZheException(ResultCodeEnum.ERROR,e);
            }
        }
        else {
            throw new HuangShiZheException(ResultCodeEnum.USER_NOT_EXIT);
        }
    }

    @Override
    public User getCurrentUser(HttpServletRequest request) throws HuangShiZheException {
        String token=findToken(request);
        if(StringUtils.isEmpty(token)){
            throw new HuangShiZheException(ResultCodeEnum.TOKEN_INVAILD);
        }
        String email=findEmail(token);
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andEmailEqualTo(email).andIsDeleteEqualTo(false);
        List<User> userList=userMapper.selectByExample(userExample);

        if(CollectionUtils.isEmpty(userList)){
            throw new HuangShiZheException(ResultCodeEnum.USER_NOT_EXIT);
        }

        return userList.get(0);
    }

    @Override
    public void login(HttpServletResponse response, String email, String password) throws HuangShiZheException {

    }

    private void sendVerification(String email, String verificationCode, EmailTemplateEnum emailTemplateEnum) throws Exception {
        emailUtil.sendMessageBy163Email(email, emailTemplateEnum.getSubject(), CommonUtil.wireVerificationCode(emailTemplateEnum.getContent(), verificationCode));
    }

    private String findToken(HttpServletRequest request){
        for(Cookie cookie:request.getCookies()){
            if(cookie.getName().equals(CommenEnum.huangshizhetianxiadiyi.toString())){
                return cookie.getValue();
            }
        }
        return null;
    }

    private String findEmail(String token) throws HuangShiZheException{
       String email = jedisPool.getResource().get(token);
       if(StringUtils.isEmpty(email)){
           throw new HuangShiZheException(ResultCodeEnum.TOKEN_INVAILD);
       }
       return email;
    }
}
