package com.lichun.springboot.springbootstudy.common;

import lombok.Data;

/**
 * 统一响应对象格式
 */
@Data
public class ResponseData {
    private boolean status;
    private long code;
    private String message;
    private Object data;
}
