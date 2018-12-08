package com.example.demo.security.validata.common;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Description:
 */
public interface ValidateCodeGenerator {

    ValidateCode generate(ServletWebRequest request);

}
