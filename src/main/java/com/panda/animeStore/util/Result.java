package com.panda.animeStore.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

/**
 * @author panda
 * @date 2019-01-15 10:37 AM
 * 请求响应工具类
 */
@Slf4j
public class Result {
    public static void data() {
        //get caller method name
        String caller = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("{}请求成功,返回数据", caller);
    }

    public static ResponseEntity<String> status(boolean status) {
        //get caller method name
        String caller = Thread.currentThread().getStackTrace()[2].getMethodName();
        if (status) {
            log.info("{}请求成功", caller);
            return ResponseEntity.ok().body(caller + " success");
        } else {
            log.error("{}请求失败", caller);
            return ResponseEntity.badRequest().body(caller + " fail");
        }
    }
}
