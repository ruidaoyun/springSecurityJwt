package com.belle.springsecurityjwt.dao;


import com.belle.springsecurityjwt.model.entity.Emp;

import java.util.List;

public interface EmpDAO {
    List<Emp> getAll();

    Emp getOne(Integer empno);

    void insertOne(Emp emp);
}
