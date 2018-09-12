package com.belle.springsecurityjwt.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
    private Integer status;
    private String msg;
    private Object data;

    public Result(Integer status, String msg, Object data) {
        this.status=status;
        this.msg=msg;
        this.data=data;
    }
}
