package org.graduationdesign.service.impl;

import org.graduationdesign.entity.User;
import org.graduationdesign.entity.UserExample;
import org.graduationdesign.enums.EmailTemplateEnum;
import org.graduationdesign.mappers.UserMapper;
import org.graduationdesign.service.UserService;
import org.graduationdesign.util.CommonUtil;
import org.graduationdesign.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisPool;

public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    EmailUtil emailUtil;

    @Autowired
    JedisPool jedisPool;

    public static final String PREFIX = "verificationCode-";

    @Override
    public Integer registerVerification(String email) {

        if (!userIfExits(email)) {
            String verificationCode = CommonUtil.generateRandomVerificationCode();
            jedisPool.getResource().set(PREFIX + email, verificationCode);
            try {
                sendVerification(email, verificationCode, EmailTemplateEnum.REGISTER_VERIFICATION);
            } catch (Exception e) {
                return 3;
            }
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public Integer simpleRegister(String email, String verificationCode) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        User user = new User();


        return null;
    }

    @Override
    public Boolean userIfExits(String email) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIsDeleteEqualTo(false).andEmailEqualTo(email);
        int count = userMapper.countByExample(userExample);
        return count == 0 ? false : true;
    }

    private void sendVerification(String email, String verificationCode, EmailTemplateEnum emailTemplateEnum) throws Exception{
        emailUtil.sendMessageBy163Email(email, emailTemplateEnum.getSubject(), CommonUtil.wireVerificationCode(emailTemplateEnum.getContent(), verificationCode));
    }
}
