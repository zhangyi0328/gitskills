package com.example.demo.exception.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @Description:
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
