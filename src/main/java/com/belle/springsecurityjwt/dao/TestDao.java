package com.belle.springsecurityjwt.dao;

import com.belle.springsecurityjwt.model.entity.Test;
import com.belle.springsecurityjwt.model.entity.User;

import java.util.HashMap;
import java.util.List;

public interface TestDao {
    List<Test> selectAllTest();

    List<HashMap<String,Object>> selectAllUser();
}
