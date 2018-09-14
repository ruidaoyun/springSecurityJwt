package com.belle.springsecurityjwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private MyUserDetailsService userDetailsService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = (String) authentication.getPrincipal();     //获取用户输入的用户名
        String password = (String) authentication.getCredentials(); //获取用户输入的密码
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (userDetails!=null&&userDetails.getPassword().equals(password)) {
            System.err.println (userDetails.getAuthorities ());
            return new UsernamePasswordAuthenticationToken (userDetails, null, userDetails.getAuthorities());
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

}
