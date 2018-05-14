package org.graduationdesign.interceptor;

import org.graduationdesign.entity.User;
import org.graduationdesign.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MajorInterceptor implements HandlerInterceptor {

   UserService userService;

   private final static Logger LOGGER=LoggerFactory.getLogger(MajorInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        userService = factory.getBean(UserService.class);
        if (request.getRequestURI().equals("/api/user/hello-user")) {
            User user=userService.getCurrentUser(request);
            if (user != null) {
                LOGGER.info("[登录信息] 登录人名称:{} id:{} 邮箱:{}   {},访问url:{},method:{}",user.getName(),user.getId(),user.getEmail(),user.getMobile(),
                        request.getRequestURI(),request.getMethod());
                return true;
            }
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
