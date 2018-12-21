package com.panda.springboot01helloworld.handler;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sun.rmi.runtime.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * @author panda
 * @date 2018-12-10 3:06
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    private String exceptionHandler(Exception e){
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("status",false);
        jsonObject.addProperty("errMsg",e.getMessage());
        log.warn("抛出异常信息:{}",e.getMessage());
        return  jsonObject.toString();
    }
}
