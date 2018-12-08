package com.example.demo.services;

import com.example.demo.entity.UserEntity;
import com.example.demo.jpa.UserJpa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Author: HanLong
 * @Date: Create in 2018/3/17 22:33
 * @Description:
 */
@Slf4j
@Component
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserJpa userJpa ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("用户的用户名: {}", username);

        UserEntity userEntity = userJpa.queryByUsername(username) ;
        if (userEntity == null) {
            log.error("未获取到用户");
            throw new UsernameNotFoundException("未获取到用户") ;
        }

        String password = passwordEncoder.encode( userEntity.getPassword() );

        // 参数分别是：用户名，密码，用户权限
        User user = new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMI"));
        return user;
    }
}
