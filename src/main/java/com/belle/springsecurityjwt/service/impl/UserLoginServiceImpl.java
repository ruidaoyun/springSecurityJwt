package com.belle.springsecurityjwt.service.impl;


import com.belle.springsecurityjwt.dao.UserLoginDao;
import com.belle.springsecurityjwt.model.entity.UserLogin;
import com.belle.springsecurityjwt.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserLoginDao userLoginDAO;


    @Override
    public UserLogin getUserById(Long id) {
        return userLoginDAO.selectUserById (id);
    }

    @Override
    public UserLogin getUserByUsername(String username) {
        return userLoginDAO.selectUserByUsername (username);
    }

    @Override
    public boolean saveUser(UserLogin user) {
        return userLoginDAO.insertUser (user)>0;
    }

    @Override
    public boolean modifyUserOnPasswordById(UserLogin user) {
        return userLoginDAO.updateUserOnPasswordById (user)>0;
    }

    @Override
    public boolean deleteUserById(Long id) {
        return userLoginDAO.deleteUserById (id)>0;
    }
}
