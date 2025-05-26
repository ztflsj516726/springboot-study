package com.ztf.back.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// 使用 @RestControllerAdvice 代替 @ControllerAdvice，表示返回的是 JSON 格式的响应
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 处理所有其他类型的异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  // 设置状态码为 500
    public Map<String, Object> handleException(Exception ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", ex.getMessage());
        response.put("code", 500);
        return response;
    }
}
