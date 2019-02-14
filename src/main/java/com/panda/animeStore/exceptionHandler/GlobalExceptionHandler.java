package com.panda.animeStore.exceptionHandler;

import com.panda.animeStore.util.ResultJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author panda
 * @date 2018-12-10 3:06
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    private static ResultJson globalExceptionHandle(Exception e) {
        log.error("抛出异常信息:{}", e.getMessage());
        return ResultJson.create("failed",e.getMessage());
    }
}
