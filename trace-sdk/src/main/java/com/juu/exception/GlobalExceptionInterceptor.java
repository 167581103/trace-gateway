package com.juu.exception;

import com.juu.common.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionInterceptor {

    @ExceptionHandler(RuntimeException.class)
    public JsonResult handleException(RuntimeException ex){
        log.error("unknown exception",ex);
        if(ex instanceof BusinessException){
            return JsonResult.fail(ex.getMessage());
        }
        return JsonResult.fail("系统异常，请稍后再试");
    }

    @ExceptionHandler(Error.class)
    public JsonResult handleError(Error ex){
        log.error("unknown error",ex);
        return JsonResult.fail("系统异常，请联系管理员");
    }

}
