package com.example.demo.exception.response;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 接口响应实体
 */
@Slf4j
@Data
//@Builder
public class ApiResponseEntity<T extends Object> {
    /**
     * 错误消息
     */
    private String errorMsg;

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 数据内容
     */
    private T data;


    /**
     * 接口是否返回正常
     */
    private boolean isSuccess ;

    public ApiResponseEntity(String errorMsg){
        this.errorMsg = errorMsg ;
    }

    public ApiResponseEntity(){}
}
