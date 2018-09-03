package com.belle.springsecurityjwt.security;


import com.belle.springsecurityjwt.dao.UserLoginDAO;
import com.belle.springsecurityjwt.model.entity.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserLoginDAO userLoginDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        /*//从数据库中加载用户对象
        Optional<UserLogin> user = userRepository.findByName(s);
        //调试用，如果值存在则输出下用户名与密码
        user.ifPresent((value)->System.out.println("用户名:"+value.getUsername ()+" 用户密码："+value.getPassword()));
        //若值不再则返回null
        return new MyUserDetails(user.orElse(null));*/
        UserLogin user=userLoginDAO.selectUserByUsername (s);
        if (user!=null){
            System.out.println ("用户名:"+user.getUsername ()+" 用户密码："+user.getPassword());
        }
        return user==null?null:new MyUserDetails (user);
    }
}
