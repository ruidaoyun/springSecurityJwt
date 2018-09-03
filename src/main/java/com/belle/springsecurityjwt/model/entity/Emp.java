package com.belle.springsecurityjwt.model.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Emp {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;


}
