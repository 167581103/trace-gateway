package com.juu.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResultCode {
    SUCCESS(200,"请求成功"),
    FAIL(1000,"请求失败"),
    LOGIN_FAIL(2000,"登录失败"),
    AUTH_WRONG(20001,"用户名或密码错误");

    private Integer code;
    private String msg;
}
