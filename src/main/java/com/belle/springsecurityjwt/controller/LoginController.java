package com.belle.springsecurityjwt.controller;


import com.belle.springsecurityjwt.config.WebSecurityConfig;
import com.belle.springsecurityjwt.dao.UserLoginDAO;
import com.belle.springsecurityjwt.model.dto.JSONResult;
import com.belle.springsecurityjwt.model.dto.LoginDTO;
import com.belle.springsecurityjwt.model.entity.UserLogin;
import com.belle.springsecurityjwt.utils.JWTTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


@RestController
public class LoginController {

    @Autowired
    private UserLoginDAO userLoginDAO;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenUtils jwtTokenUtils;

    @RequestMapping(value = "/auth/login",method = RequestMethod.POST)
    public String login(@RequestBody LoginDTO loginDTO, HttpServletResponse httpResponse) throws Exception{
        //通过用户名和密码创建一个 Authentication 认证对象，实现类为 UsernamePasswordAuthenticationToken
        System.out.println (loginDTO);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken (loginDTO.getUsername(),loginDTO.getPassword());
        //如果认证对象不为空
        /*if (Objects.nonNull(authenticationToken)){
            userRepository.findByName(authenticationToken.getPrincipal().toString())
                    .orElseThrow(()->new Exception("用户不存在"));
        }*/
        if (Objects.nonNull (authenticationToken)){
            UserLogin user=userLoginDAO.selectUserByUsername (authenticationToken.getPrincipal ().toString ());
            if (user==null){
                return JSONResult.fillResultString (1,"用户名不存在",null);
            }
        }
        try {
            //通过 AuthenticationManager（默认实现为ProviderManager）的authenticate方法验证 Authentication 对象
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            //将 Authentication 绑定到 SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);
            //生成Token
            String token = jwtTokenUtils.createToken(authentication,false);
            //将Token写入到Http头部
            httpResponse.addHeader(WebSecurityConfig.AUTHORIZATION_HEADER,"Bearer "+token);
            return "Bearer "+token;
        }catch (BadCredentialsException authentication){
            return JSONResult.fillResultString (1,"密码错误",null);
        }
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public void logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler ().logout(request, response, auth);
        }
        //return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }
}
