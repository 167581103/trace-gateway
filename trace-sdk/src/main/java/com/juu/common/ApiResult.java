package com.juu.common;

import com.juu.exception.APIException;
import com.juu.util.PropertyUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
public class ApiResult<T> implements Serializable {
    private static final long serialVersionUID = 0xc93480e15321b2c5L;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 说明信息
     */
    private String msg;

    /**
     * 错误code
     */
    private String appCode;

    /**
     * 服务名/url
     */
    private String path;

    /**
     * 返回数据
     */
    private T data;

    public ApiResult() {
        this.path = PropertyUtils.getServiceName();
    }

    public ApiResult(ResultCode code) {
        this.code = code.code();
        this.msg = code.message();
        this.appCode = String.valueOf(code.code());
        this.path = PropertyUtils.getServiceName();
    }

    public ApiResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.appCode = String.valueOf(code);
        this.path = PropertyUtils.getServiceName();
    }

    public ApiResult(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.appCode = String.valueOf(resultCode.getCode());
        this.path = PropertyUtils.getServiceName();
        this.data = data;
    }

    public static <T> ApiResult<T> failure(Integer code, String path) {
        ApiResult<T> result = failure();
        result.setCode(code);
        result.setAppCode(String.valueOf(code));
        result.setPath(path);
        return result;
    }

    public static <T> ApiResult<T> failure(Integer code, String path, T data) {
        ApiResult<T> result = failure();
        result.setCode(code);
        result.setAppCode(String.valueOf(code));
        result.setPath(path);
        result.setData(data);
        return result;
    }

    public static ApiResult<String> failure(ResultCode code, String data, boolean isCustomErrorMessage) {
        ApiResult<String> result = failure(code, data);
        if (isCustomErrorMessage && data!=null) {
            result.setMsg(data);
        }
        return result;
    }

    public static <T> ApiResult<T> failure(APIException e) {
        ApiResult<T> result = failure();
        result.setAppCode(e.getAppCode());
        result.setPath(e.getPath());
        result.setMsg(e.getMsg());
        result.setData((T) e.getData());
        return result;
    }

    public static <T> ApiResult<T> success() {
        return new ApiResult<T>(ResultCode.SUCCESS);
    }

    public static <T> ApiResult<T> success(T data) {
        ApiResult<T> result = new ApiResult<T>(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static <T> ApiResult<T> success(T data, String msg) {
        ApiResult<T> result = new ApiResult<T>(ResultCode.SUCCESS.code(), msg);
        result.setData(data);
        return result;
    }

    public static <T> ApiResult<T> failure(ResultCode rc) {
        StackTraceElement se = Thread.currentThread().getStackTrace()[2];
        log.error("failure result code: {}, msg: {}", rc.getCode(), rc.getMsg());
        log.error("failure info: {} {} {}", se.getClassName(), se.getMethodName(), se.getLineNumber());
        return new ApiResult<T>(rc.getCode(), rc.getMsg());
    }

    public static <T> ApiResult<T> failure() {
        return failure(ResultCode.FAIL);
    }

    public static <T> ApiResult<T> failure(ResultCode code, T data) {
        ApiResult<T> result = failure(code);
        result.setData(data);
        return result;
    }
}
