package com.example.demo.controller;

import com.example.demo.exception.response.ApiResponseEntity;
import com.example.demo.security.properties.SecurityConstants;
import com.example.demo.security.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 */
@Slf4j
@Controller
public class SecurityController {

    // 原请求信息的缓存及恢复
    private RequestCache requestCache = new HttpSessionRequestCache();

    // 用于重定向
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 当需要身份认证的时候，跳转过来
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public String requireAuthenication(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        SavedRequest savedRequest = requestCache.getRequest(request, response);
            log.info("");
//        if (savedRequest != null) {
//            String targetUrl = savedRequest.getRedirectUrl();
//            log.info("引发跳转的请求是:" + targetUrl);
//            if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
//                redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());
//            }
//        }
//        redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());
//        return new ApiResponseEntity("访问的服务需要身份认证，请引导用户到登录页");
        return "index" ;
    }


    @GetMapping("/session/invalid")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ApiResponseEntity sessionInvalid() {
        System.out.println("哈哈哈");
        return new ApiResponseEntity("Session 超时");

    }

//    @
//    public String login(){
//        return "index" ;
//    }
}
