package com.shoestp.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

/**
 * @description: 自定义异常类
 * @author: lingjian
 * @create: 2019/7/25 14:35
 */
@Data
@AllArgsConstructor
public class MyException extends RuntimeException {
    private int code;
    private String errMsg;
}
