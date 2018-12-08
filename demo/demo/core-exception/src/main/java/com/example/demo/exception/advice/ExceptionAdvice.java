package com.example.demo.exception.advice;

import com.example.demo.exception.exception.BaseException;
import com.example.demo.exception.exception.ValidateCodeException;
import com.example.demo.exception.response.ApiResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyi  2018-09-09-11:11
 * @description
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {

    /**
     * BaseException异常处理方法
     * @param e BaseException异常对象
     * @return
     */
    @ExceptionHandler(BaseException.class)
    @ResponseStatus(code = HttpStatus.OK)
    public ApiResponseEntity BaseException(BaseException e){
        log.error("遇到业务逻辑异常：【errorCode:{}, errorMsg:{}】", e.getErrCode(), e.getErrMsg());
        ApiResponseEntity apiResponseEntity = new ApiResponseEntity() ;

//        apiResponseEntity.<String>builder().errorMsg(e.getErrMsg()).build() ;
//        apiResponseEntity.<String>builder().errorMsg(e.getErrCode()).build() ;

        String errorCode = e.getErrCode() ;
        apiResponseEntity.setErrorMsg(e.getErrMsg());
        apiResponseEntity.setErrorCode(errorCode);
        apiResponseEntity.setSuccess(false);
        apiResponseEntity.setData(null);
        return apiResponseEntity ;
    }


    /**
     * 默认统一异常处理方法
     * @param e 默认Exception异常对象
     * @return
     */
    @ExceptionHandler
    @ResponseStatus
    public ApiResponseEntity runtimeExceptionHandler(Exception e) {
        log.error("遇到业务逻辑异常：【errorMsg:{}】", e.getMessage());
        ApiResponseEntity apiResponseEntity = new ApiResponseEntity() ;

        apiResponseEntity.setErrorMsg(e.getMessage());
        apiResponseEntity.setErrorCode("99999");
        apiResponseEntity.setSuccess(false);
        apiResponseEntity.setData(null);

        return apiResponseEntity ;
    }


}
