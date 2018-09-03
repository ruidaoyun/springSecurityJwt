package com.belle.springsecurityjwt.service.impl;


import com.belle.springsecurityjwt.dao.UsersDao;
import com.belle.springsecurityjwt.model.entity.Users;
import com.belle.springsecurityjwt.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;
    @Override
    public List<Users> getAll() {
        return usersDao.getAll ();
    }

    @Override
    public Users getUserById(Integer id) {
        return usersDao.getUserById (id);
    }

    @Override
    public Users getUserByName(String name) {
        System.out.println (name);
        return usersDao.getUserByName (name);
    }

    @Override
    public Integer deleteUsersById(Integer id) {
        return usersDao.deleteUsersById (id);
    }

    @Override
    public Integer insertUsers(@RequestBody Users users) {
        return usersDao.insertUsers (users);
    }

    @Override
    public Integer updateUsers(@RequestBody Users users) {
        return usersDao.updateUsers (users);
    }
}
