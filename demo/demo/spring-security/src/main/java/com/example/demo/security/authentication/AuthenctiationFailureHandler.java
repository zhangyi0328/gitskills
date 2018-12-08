package com.example.demo.security.authentication;

import com.example.demo.exception.response.ApiResponseEntity;
import com.example.demo.security.properties.LoginResponseType;
import com.example.demo.security.properties.SecurityProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: HanLong
 * @Date: Create in 2018/3/18 16:53
 * @Description: 登录失败回调处理
 */
@Slf4j
@Component("failureHandler")
public class AuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        logger.info("登录失败");

        // 判断是用哪一种方式进行登录的
        // 如果是JSON，则返回JSON字符串；否则进行页面的跳转
        if (LoginResponseType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(new ApiResponseEntity(exception.getMessage())));
        }else{
            super.onAuthenticationFailure(request, response, exception);
//            responseOutWithJson(response, exception.getMessage());
//            response.setStatus(HttpStatus.OK.value());
//            response.setContentType("application/json;charset=UTF-8");
//            response.getWriter().write(exception.getMessage()) ;
        }
    }


    /**
     * 以JSON格式输出
     * @param response
     */
    private void responseOutWithJson(HttpServletResponse response, Object responseObject) {

        try {
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            if (!responseObject.equals("")) {
//                historyEvent = historyEventService.getHistoryEventByName(projectId, selectName);//获取对象
                response.setContentType("application/json; charset=utf-8");
//                JSONObject responseJSONObject = JSONObject.fromObject(historyEvent); //将实体对象转换为JSON Object转换
                Map<String, Object> map = new HashMap<>() ;
                map.put("error", responseObject) ;
                out.print(map.toString());
                out.flush();
                out.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
