package org.graduationdesign.service;

import org.graduationdesign.entity.Provider;
import org.graduationdesign.entity.User;
import org.graduationdesign.exception.HuangShiZheException;
import org.graduationdesign.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

public interface UserService {

    /**
     * 发送注册验证码
     *
     * @param email
     * @throws HuangShiZheException
     */
    void registerVerification(@NotNull(message = "邮箱不能为空") String email) throws HuangShiZheException;

    /**
     * 简单注册
     *
     * @param email
     * @param verificationCode
     * @throws HuangShiZheException
     */
    void simpleRegister(@NotNull(message = "邮箱不能为空") String email, @NotNull(message = "验证码不能为空") String verificationCode) throws HuangShiZheException;

    /**
     * 用户是否存在
     *
     * @param email
     * @return
     * @throws HuangShiZheException
     */
    Boolean userIfExits(@NotNull(message = "邮箱不能为空") String email) throws HuangShiZheException;

    /**
     * 通过验证码登录
     *
     * @param email
     * @param verificationCode
     * @param response
     * @throws HuangShiZheException
     */
    void login(@NotNull(message = "邮箱不能为空") String email, @NotNull(message = "验证码不能为空") String verificationCode, HttpServletResponse response) throws HuangShiZheException;

    /**
     * 发送登录验证码
     *
     * @param email
     * @throws HuangShiZheException
     */
    void sendLoginVerification(@NotNull(message = "邮箱不能为空") String email) throws HuangShiZheException;

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
    User login(HttpServletResponse response, @NotNull(message = "邮箱不能为空") String email, @NotNull(message = "密码不能为空") String password) throws HuangShiZheException;

    /**
     * 修改自己的信息
     *
     * @param user
     * @throws HuangShiZheException
     */
    void updateInformation(@NotNull(message = "参数不能为空") User user) throws HuangShiZheException;

    /**
     * 根据用户id获取用户信息
     *
     * @return
     * @throws HuangShiZheException
     */
    UserVO getUserInfoById(@NotNull(message = "用户ID不能为空") Long id) throws HuangShiZheException;

    Provider getProviderByUserId(@NotNull(message = "用户ID不能为空") Long userId) throws HuangShiZheException;

    Provider getProviderByEmail(@NotNull(message = "邮箱不能为空") String email) throws HuangShiZheException;

    void becomeProvider(@NotNull(message = "用户ID不能为空") Long userId) throws HuangShiZheException;

    User getUserByEmail(@NotNull(message = "邮箱不能为空") String email) throws HuangShiZheException;

    Boolean userIfProvider(@NotNull(message = "用户id不能为空") Long id) throws HuangShiZheException;

    Boolean ifUserExitById(@NotNull(message="用户ID不能为空") Long id) throws HuangShiZheException;

    Provider getProviderById(@NotNull Long providerId) throws HuangShiZheException;

}
