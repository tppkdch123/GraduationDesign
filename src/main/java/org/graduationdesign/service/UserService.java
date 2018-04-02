package org.graduationdesign.service;

import org.graduationdesign.entity.Provider;
import org.graduationdesign.entity.User;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

    /**
     * 发送注册验证码
     *
     * @param email
     * @throws HuangShiZheException
     */
    void registerVerification(String email) throws HuangShiZheException;

    /**
     *  简单注册
     *
     * @param email
     * @param verificationCode
     * @throws HuangShiZheException
     */
    void simpleRegister(String email, String verificationCode) throws HuangShiZheException;

    /**
     * 用户是否存在
     *
     * @param email
     * @return
     * @throws HuangShiZheException
     */
    Boolean userIfExits(String email) throws HuangShiZheException;

    /**
     * 通过验证码登录
     *
     * @param email
     * @param verificationCode
     * @param response
     * @throws HuangShiZheException
     */
    void login(String email, String verificationCode, HttpServletResponse response) throws HuangShiZheException;

    /**
     * 发送登录验证码
     *
     * @param email
     * @throws HuangShiZheException
     */
    void sendLoginVerification(String email) throws HuangShiZheException;

    /**
     * 获得当前用户信息
     *
     * @param request
     * @return
     * @throws HuangShiZheException
     */
    User getCurrentUser(HttpServletRequest request) throws HuangShiZheException;

    /**
     * 通过用户名密码登录
     *
     * @param email
     * @param password
     * @throws HuangShiZheException
     */
    void login(HttpServletResponse response, String email, String password) throws HuangShiZheException;

    /**
     * 修改自己的信息
     *
     * @param user
     * @throws HuangShiZheException
     */
    void updateInformation(User user) throws HuangShiZheException;

    /**
     * 根据用户id获取用户信息
     *
     * @return
     * @throws HuangShiZheException
     */
    UserVO getUserInfoById(Long id) throws HuangShiZheException;

    Provider getProviderByUserId(Long userId) throws HuangShiZheException;

    Provider getProviderByEmail(String email) throws HuangShiZheException;

    void becomeProvider(Long userId) throws HuangShiZheException;

    User getUserByEmail(String email) throws HuangShiZheException;

    Boolean userIfProvider(Long id) throws HuangShiZheException;

}
