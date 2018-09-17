package com.belle.springsecurityjwt.filter;

import com.belle.springsecurityjwt.config.WebSecurityConfig;
import com.belle.springsecurityjwt.model.dto.JSONResult;
import com.belle.springsecurityjwt.utils.JWTTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAuthenticationTokenFilter extends GenericFilterBean {

    @Autowired
    private JWTTokenUtils tokenProvider;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info ("JwtAuthenticationTokenFilter");
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;

        try {
            String jwt=resolveToken (request);
            request.setAttribute ("validateToken", tokenProvider.validateToken (jwt));
            if (StringUtils.hasText (jwt) && tokenProvider.validateToken (jwt).getStatus () == 0) {            //验证JWT是否正确
                Authentication authentication=tokenProvider.getAuthentication (jwt);           //获取用户认证信息
                SecurityContextHolder.getContext ().setAuthentication (authentication);           //将用户保存到SecurityContext
            }
            filterChain.doFilter (servletRequest, response);
        } catch (Exception e) {
            e.printStackTrace ();
            response.setHeader ("Access-Control-Allow-Origin", "*");
            response.setStatus (HttpStatus.OK.value ());
            response.setContentType ("application/json;charset=UTF-8");
            response.getWriter ().write (JSONResult.fillResultString (3, e.getMessage (), null));
        }
    }

    private String resolveToken(HttpServletRequest request) {
        String bearerToken=request.getHeader (WebSecurityConfig.AUTHORIZATION_HEADER);         //从HTTP头部获取TOKEN
        if (StringUtils.hasText (bearerToken) && bearerToken.startsWith ("Bearer ")) {
            return bearerToken.substring (7, bearerToken.length ());                              //返回Token字符串，去除Bearer
        }
        String jwt=request.getParameter (WebSecurityConfig.AUTHORIZATION_TOKEN);               //从请求参数中获取TOKEN
        if (StringUtils.hasText (jwt)) {
            return jwt;
        }
        return null;
    }
}
