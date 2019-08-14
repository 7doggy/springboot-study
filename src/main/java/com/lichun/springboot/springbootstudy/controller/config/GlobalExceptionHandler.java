package com.lichun.springboot.springbootstudy.controller.config;

import com.lichun.springboot.springbootstudy.common.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一处理404和500异常
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseData defaultErrorHandler(HttpServletRequest req, Exception ex) {
        log.error("", ex);
        ResponseData r = new ResponseData();
        r.setMessage(ex.getMessage());
        if (ex instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            r.setCode(404);
        } else {
            r.setCode(500);
        }
        r.setData(null);
        r.setStatus(false);
        return r;
    }
}
