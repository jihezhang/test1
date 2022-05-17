package com.ithiema.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(Exception.class)
    public R doException(Exception ex) {
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员
         ex.printStackTrace();
         return new R("系统错误，请稍后尝试");
    }
}
