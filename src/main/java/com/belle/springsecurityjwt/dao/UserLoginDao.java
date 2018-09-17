package com.belle.springsecurityjwt.dao;


import com.belle.springsecurityjwt.model.entity.UserLogin;

import java.util.List;

public interface UserLoginDao {
    UserLogin selectUserById(Long id);

    UserLogin selectUserByUsername(String username);

    List<UserLogin> selectAllUsers();

    Integer insertUser(UserLogin user);

    Integer updateUserOnPasswordById(UserLogin user);

    Integer deleteUserById(Long id);
}
