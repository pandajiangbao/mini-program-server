package com.panda.animeStore.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

/**
 * @author panda
 * @date 2019-01-15 10:37 AM
 * 请求响应工具类
 */
@Slf4j
@Data
public class Result {
    public static ResponseEntity<String> status(boolean status) {
        //get caller method name
        String caller = Thread.currentThread().getStackTrace()[2].getMethodName();
        if (status) {
            log.info("{}请求成功", caller);
            return ResponseEntity.ok().body(caller + "成功");
        } else {
            log.error("{}请求失败", caller);
            return ResponseEntity.badRequest().body(caller + "失败");
        }
    }
}
