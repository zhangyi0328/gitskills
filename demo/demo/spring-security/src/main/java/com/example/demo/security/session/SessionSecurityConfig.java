/**
 * 
 */
package com.example.demo.security.session;

import com.example.demo.security.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;


/**
 * @author zhailiang
 *
 */
@Configuration
public class SessionSecurityConfig {

	@Autowired
	private SecurityProperties securityProperties;
	
	@Bean
	@ConditionalOnMissingBean(InvalidSessionStrategy.class)
	public InvalidSessionStrategy invalidSessionStrategy(){
		return new InvalideSessionStrategy(securityProperties.getBrowser().getSession().getSessionInvalidUrl());
	}
	
	@Bean
	@ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
	public SessionInformationExpiredStrategy sessionInformationExpiredStrategy(){
		return new ExpiredSessionStrategy(securityProperties.getBrowser().getSession().getSessionInvalidUrl());
	}
	
}
