package com.example.demo.security.config;

import com.example.demo.security.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

import javax.annotation.Resource;

/**
 * @author zhangyi  2018-11-24-9:48
 * @description
 */
@Configuration
public class SecurityConfig extends AbstractChannelSecurityConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Resource
    private InvalidSessionStrategy invalidSessionStrategy;

    @Resource
    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder() ;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        applyPasswordAuthenticationConfig(http);

        http.apply(validateCodeSecurityConfig)
                .and()
            .sessionManagement()
                .invalidSessionStrategy(invalidSessionStrategy) // session超时跳转
                .maximumSessions(securityProperties.getBrowser().getSession().getMaximumSessions()) // 最大并发session
                .maxSessionsPreventsLogin(securityProperties.getBrowser().getSession().isMaxSessionsPreventsLogin())    // 是否阻止新的登录
                .expiredSessionStrategy(sessionInformationExpiredStrategy)      // 并发session失效原因
                .and()
                .and()
            .csrf().disable();          // 关闭csrf防护
    }




}
