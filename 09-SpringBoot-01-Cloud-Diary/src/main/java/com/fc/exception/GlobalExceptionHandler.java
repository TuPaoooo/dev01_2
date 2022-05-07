package com.fc.exception;

import com.fc.vo.ResultInfo;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 请求方式不支持
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResultInfo handleException(HttpRequestMethodNotSupportedException e) {
        ResultInfo info = new ResultInfo();
        info.setError("不支持' " + e.getMethod() + "'请求");
        return info;
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public ResultInfo notFount(RuntimeException e) {
        ResultInfo info = new ResultInfo();
        info.setError("运行时异常:" + e.getMessage());
        return info;
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public ResultInfo handleException(Exception e) {
        ResultInfo info = new ResultInfo();
        info.setError("服务器错误，请联系管理员");
        return info;
    }

}