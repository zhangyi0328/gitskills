package com.example.demo.exception.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhangyi  2018-09-09-7:44
 * @description
 */
@Slf4j
public class BaseException extends RuntimeException{
    private String errMsg ;
    private String errCode ;
    private Object[] params ;

    public String getErrMsg(){
        return this.errMsg ;
    }

    public String getErrCode(){
        return this.errCode ;
    }

    public BaseException(String errCode, Object... params){
        this.errCode = errCode ;
        this.params = params ;
        log.error("系统遇到如下异常，异常码：{}>>>异常信息：{}", errCode, errMsg);
    }

    public BaseException(String errCode, String errMsg){
        this.errCode = errCode ;
        this.errMsg = errMsg ;
    }

}
