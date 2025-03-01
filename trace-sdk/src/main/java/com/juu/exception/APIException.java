package com.juu.exception;

import lombok.Data;

@Data
public class APIException extends BusinessException{
    private String appCode;
    private String path;
    private String msg;
    private Object data;
}
