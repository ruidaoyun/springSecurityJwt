package com.belle.springsecurityjwt.service;

import com.belle.springsecurityjwt.model.entity.UserLogin;

public interface UserLoginService  {
    UserLogin getUserById(Long id);

    UserLogin getUserByUsername(String username);

    boolean saveUser(UserLogin user);

    boolean modifyUserOnPasswordById(UserLogin user);

    boolean deleteUserById(Long id);
}
