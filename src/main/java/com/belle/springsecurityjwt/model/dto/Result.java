package com.belle.springsecurityjwt.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Result {
    private Integer status;
    private String msg;
    private Object data;
}
