package com.belle.springsecurityjwt.security;


import com.belle.springsecurityjwt.dao.UserLoginDao;
import com.belle.springsecurityjwt.model.entity.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserLoginDao userLoginDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserLogin user=userLoginDAO.selectUserByUsername (s);
        if (user!=null){
            System.out.println ("用户名:"+user.getUsername ()+" 用户密码："+user.getPassword());
        }
        return user==null?null:new MyUserDetails (user);
    }
}
