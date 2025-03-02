package com.juu.exception;

import com.juu.common.ApiResult;
import com.juu.common.JsonResult;
import com.juu.common.ResultCode;
import com.juu.util.PropertyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局异常处理器负责将Exception转为ApiResult并返回，后续服务只需要转发ApiResult即可
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionInterceptor {

    @ExceptionHandler(RuntimeException.class)
    public ApiResult<Object> handleException(RuntimeException ex){
        if(ex instanceof APIException){
            // APIException，组装
            log.error("api exception",ex);
            return new ApiResult<>(((APIException) ex).getResultCode(),((APIException) ex).getData());
        }
        log.error("unknown exception",ex);
        // 非APIException，直接返回
        return new ApiResult<>(ResultCode.SYSTEM_ERROR.getCode(),ex.getMessage());
    }

    @ExceptionHandler(Error.class)
    public JsonResult handleError(Error ex){
        log.error("unknown error",ex);
        return JsonResult.fail("系统异常，请联系管理员");
    }

}
