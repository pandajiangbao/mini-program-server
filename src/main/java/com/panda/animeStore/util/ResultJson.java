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
public class ResultJson {
	private String status;
	private Object result;

	public static ResultJson create(String status, Object result) {
		ResultJson res = new ResultJson();
		res.setStatus(status);
		res.setResult(result);
		return res;
	}

	public static ResultJson result(Object result) {
		//get caller method name
		String caller=Thread.currentThread().getStackTrace()[2].getMethodName();
		log.info("{}请求成功,返回数据",caller);
		return ResultJson.create("success", result);
	}

	public static ResultJson success() {
		//get caller method name
		String caller=Thread.currentThread().getStackTrace()[2].getMethodName();
		log.info("{}请求成功",caller);
		return ResultJson.create("success", caller+"成功");
	}

	public static ResultJson failed() {
		//get caller method name
		String caller=Thread.currentThread().getStackTrace()[2].getMethodName();
		log.error("{}请求失败",caller);
		return ResultJson.create("failed", caller+"失败");
	}
}
