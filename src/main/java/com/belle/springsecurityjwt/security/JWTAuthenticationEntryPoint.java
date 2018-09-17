package com.belle.springsecurityjwt.security;


import com.belle.springsecurityjwt.model.dto.JSONResult;
import com.belle.springsecurityjwt.model.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * 自定义验证token错误信息
 */
@Component
@Slf4j
public class JWTAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
    private static final String UNAUTHORIZED =JSONResult.fillResultString (1,"未授权",null);
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        log.info("到达JWTAuthenticationEntryPoint");
        //JwtAuthenticationTokenFilter的
        Result validateToken=(Result)request.getAttribute ("validateToken");
        //System.out.println (validateToken);
        if(validateToken != null){
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setStatus(HttpStatus.OK.value ());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().append(JSONResult.fillResultString (validateToken.getStatus (),validateToken.getMsg (),validateToken.getData ()));
        }else{
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setStatus(HttpStatus.OK.value ());
            response.getWriter().append(UNAUTHORIZED);
        }
    }
}
