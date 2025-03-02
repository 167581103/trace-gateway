package com.juu.common;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultCode {
    SUCCESS(200,"请求成功"),
    FAIL(1000,"请求失败"),
    LOGIN_FAIL(2000,"登录失败"),
    AUTH_WRONG(2001,"用户名或密码错误"),
    SYSTEM_ERROR(500,"系统异常，请稍后再试"),
    COMMON_EXCEPTION(501,"通用状态异常");

    private Integer code;
    private String msg;

    public Integer code(){
        return code;
    }

    public String message(){
        return msg;
    }
}
