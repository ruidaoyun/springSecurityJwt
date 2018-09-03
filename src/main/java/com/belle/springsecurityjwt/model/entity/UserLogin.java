package com.belle.springsecurityjwt.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class UserLogin implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private List<Role> roles;

}
