package com.panda.animeStore.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author panda
 * @date 2019-01-15 10:37 AM
 * 请求响应工具类
 */
@Slf4j
@Data
public class ResJson {
	private String status;
	private Object result;

	public static ResJson create(String status, Object result) {
		ResJson res = new ResJson();
		res.setStatus(status);
		res.setResult(result);
		return res;
	}

	public static ResJson result(Object result) {
		log.info("请求成功,返回数据");
		return ResJson.create("success", result);
	}

	public static ResJson success(String requestName) {
		log.info("{}成功,请求结束",requestName);
		return ResJson.create("success", requestName+"成功");
	}

	public static ResJson failed(String requestName) {
		log.error("{}失败,请求结束",requestName);
		return ResJson.create("failed", requestName+"失败");
	}
}
