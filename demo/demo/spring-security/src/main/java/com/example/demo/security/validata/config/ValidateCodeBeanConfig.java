package com.example.demo.security.validata.config;

import com.example.demo.security.properties.SecurityProperties;
import com.example.demo.security.validata.common.ValidateCodeGenerator;
import com.example.demo.security.validata.image.ImageValidateCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 */
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * @ConditionalOnMissingBean 初始化的时候，先是容器中找有没有imageCodeGenerator，如果没有再用这个
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
    public ValidateCodeGenerator imageValidateCodeGenerator() {
        ImageValidateCodeGenerator imageValidateCodeGenerator = new ImageValidateCodeGenerator();
        imageValidateCodeGenerator.setSecurityProperties(securityProperties);
        return imageValidateCodeGenerator;
    }

//    @Bean
//    @ConditionalOnMissingBean(SmsCodeSender.class)
//    public SmsCodeSender smsCodeGenerator() {
//        SmsCodeSender smsCodeSender = new DefaultSmsCodeSender();
//        return smsCodeSender;
//    }
}
