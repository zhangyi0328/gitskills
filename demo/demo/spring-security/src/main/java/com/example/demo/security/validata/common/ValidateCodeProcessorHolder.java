package com.example.demo.security.validata.common;

import com.example.demo.exception.exception.BaseException;
import com.example.demo.security.validata.enums.ValidateCodeType;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description:
 */
@Component
public class ValidateCodeProcessorHolder {

    @Resource
    private Map<String, ValidateCodeProcessor> validateCodeProcessors;

    public ValidateCodeProcessor findValidateCodeProcessor(ValidateCodeType type) {
        return findValidateCodeProcessor(type.toString().toLowerCase());
    }

    public ValidateCodeProcessor findValidateCodeProcessor(String type) {
        String name = type.toLowerCase() + ValidateCodeProcessor.class.getSimpleName();
        ValidateCodeProcessor processor = validateCodeProcessors.get(name);
        if (processor == null) {
            throw new BaseException("验证码处理器" + name + "不存在");
        }
        return processor;
    }
}
