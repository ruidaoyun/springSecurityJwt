package com.belle.springsecurityjwt.security;


import com.belle.springsecurityjwt.model.entity.Role;
import com.belle.springsecurityjwt.model.entity.UserLogin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class MyUserDetails implements UserDetails {

    private UserLogin user;

    public MyUserDetails(UserLogin user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles = user.getRoles();
        List<GrantedAuthority> authorities = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if (roles.size()>=1){
            for (Role role : roles){
                authorities.add(new SimpleGrantedAuthority (role.getRoleName ()));
            }
            return authorities;
        }
        return AuthorityUtils.commaSeparatedStringToAuthorityList("");
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername ();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
