package com.panda.springboot01helloworld.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author panda
 * @date 2018-12-10 3:06
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private Map<String, Object> exceptionHandler(Exception e){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("success",false);
        map.put("errMsg",e.getMessage());
        return  map;
    }
}
