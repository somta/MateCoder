package net.somta.matecoder.web.interceptor;

import net.somta.matecoder.model.Guest;
import net.somta.matecoder.model.Permission;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户登录校验，权限校验
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.判断请求地址是否访客就能访问
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Guest unauthorizedRequest = handlerMethod.getMethodAnnotation(Guest.class);
        if(unauthorizedRequest != null){
            System.out.println("不需要登录认证的url请求");
            return true;
        }
        // 2.判断是否存在token
        String authHeader = request.getHeader("S-Authorization");
        if(StringUtils.isEmpty(authHeader)){
            System.out.println("用户未登录，401");
            responseResult(response,401);
            return false;
        }

        // todo 3.判断方法上面是否有权限注解，并判断该用户是否有该权限
        Permission permission = handlerMethod.getMethodAnnotation(Permission.class);

        String success = "success";
        String userName = getUserNameFromReq(request);
        //String privilegeName = getPrivilegeNameFromReq(handler);

        /*if (StringUtils.isBlank(userName) || StringUtils.isBlank(privilegeName)) {
            return true;
        }*/

        //PrivilegeAuthorityService authorityService = new PrivilegeAuthorityService();
       /* String checkResult = authorityService.judgePrivilegeAuthority(userName, privilegeName);
        if (success.equals(checkResult)) {
            return true;
        }*/

        return false;
    }

    /**
     * 从Cookie中获取用户名
     * @param request
     * @return
     */
    private String getUserNameFromReq(HttpServletRequest request) {
        if (null == request) {
            return null;
        }

        Cookie[] cookies = request.getCookies();
        if (null == cookies || cookies.length < 1) {
            return null;
        }

        List<Cookie> cookieList = Arrays.stream(cookies).filter(cookie -> "username".equals(cookie.getName()))
                .collect(Collectors.toList());
        if (cookieList.size() != 1) {
            return null;
        }

        return cookieList.get(0).getValue();
    }

    /*private String getPrivilegeNameFromReq(Object handler) {
        if (null == handler) {
            return null;
        }

        if (!(handler instanceof HandlerMethod)) {
            return null;
        }

        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Privilege privilege = handlerMethod.getMethodAnnotation(Privilege.class);
        if (privilege == null) {
            return null;
        }

        return privilege.value();
    }*/


    private void responseResult(HttpServletResponse response,int errorHttpStatus){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(errorHttpStatus);
    }
}
