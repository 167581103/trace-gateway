package com.juu.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult {
    Integer code;
    String msg;
    Object data;

    public JsonResult(ResultCode resultCode, String msg){
        this.code = resultCode.getCode();
        this.msg = msg;
    }

    public JsonResult(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public JsonResult(ResultCode resultCode,Object data){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public static JsonResult success(Object data){
        return new JsonResult(ResultCode.SUCCESS,data);
    }

    public static JsonResult fail(String msg){
        return new JsonResult(ResultCode.FAIL,msg);
    }
}
