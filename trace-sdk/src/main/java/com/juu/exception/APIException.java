package com.juu.exception;

import com.juu.common.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class APIException extends RuntimeException {
    private final ResultCode resultCode;
    private final Object data;
    private String appCode;
    private String msg;
    private String path;
}
