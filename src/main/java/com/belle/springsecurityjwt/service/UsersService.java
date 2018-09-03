package com.belle.springsecurityjwt.service;


import com.belle.springsecurityjwt.model.entity.Users;

import java.util.List;

public interface UsersService {
    List<Users> getAll();

    Users getUserById(Integer id);

    Users getUserByName(String name);

    Integer deleteUsersById(Integer id);

    Integer insertUsers(Users users);

    Integer updateUsers(Users users);
}
