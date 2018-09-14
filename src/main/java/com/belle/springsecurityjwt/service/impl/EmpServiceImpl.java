package com.belle.springsecurityjwt.service.impl;


import com.belle.springsecurityjwt.dao.EmpDAO;
import com.belle.springsecurityjwt.model.entity.Emp;
import com.belle.springsecurityjwt.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDAO empDAO;

    @Override
    public List<Emp> getAll() {
        return empDAO.getAll ();
    }

    @Override
    public Emp getOne(Integer empno) {
        return empDAO.getOne (empno);
    }

    @Override
    public void insertOne(Emp emp) {
        empDAO.insertOne (emp);
    }
}
