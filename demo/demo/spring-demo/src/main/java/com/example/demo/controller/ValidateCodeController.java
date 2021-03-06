package com.example.demo.controller;

import com.example.demo.security.properties.SecurityConstants;
import com.example.demo.security.validata.common.ValidateCodeProcessorHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description:    验证码接口
 */
@RestController
public class ValidateCodeController {


    @Autowired
    private ValidateCodeProcessorHolder validateCodeProcessorHolder;

    /**
     * 创建验证码，根据验证码类型不同，调用不同的 {@link ValidateCodeProcessor}接口实现
     *
     * @param request
     * @param response
     * @param type
     * @throws Exception
     */
    @GetMapping(SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type)
            throws Exception {
        validateCodeProcessorHolder.findValidateCodeProcessor(type).create(new ServletWebRequest(request, response));
    }

//    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";
//
//    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
//
//    @GetMapping("/code/image")
//    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        ImageCode imageCode = generate(new ServletWebRequest(request));
//        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);
//        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
//    }


}
