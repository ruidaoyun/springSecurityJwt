package com.belle.springsecurityjwt.model.dto;
import org.json.JSONObject;

public class JSONResult{
    public static String fillResultString(Integer code, String msg, Object data){
        JSONObject jsonObject = new JSONObject(){{
            put("code", code);
            put("msg", msg);
            put("data", data);
        }};
        return jsonObject.toString();
    }
}
