package com.belle.springsecurityjwt.service;


import com.belle.springsecurityjwt.model.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> getAll();

    Emp getOne(Integer empno);

    void insertOne(Emp emp);

}
