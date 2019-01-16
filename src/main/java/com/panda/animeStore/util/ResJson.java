package com.panda.animeStore.util;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @author panda
 * @date 2019-01-15 10:37 AM
 * 请求响应工具类
 */
@Slf4j
public class ResJson {
	private static JsonObject res = new JsonObject();

	public static String addSuccess() {
		log.info("添加成功,请求结束");
		res.addProperty("status", "success");
		res.addProperty("message", "添加成功");
		return res.toString();
	}

	public static String addFailed() {
		log.error("添加失败,请求结束");
		res.addProperty("status", "failed");
		res.addProperty("message", "添加失败");
		return res.toString();
	}

	public static String updateSuccess() {
		log.info("修改成功,请求结束");
		res.addProperty("status", "success");
		res.addProperty("message", "修改成功");
		return res.toString();
	}

	public static String updateFailed() {
		log.error("修改失败,请求结束");
		res.addProperty("status", "failed");
		res.addProperty("message", "修改失败");
		return res.toString();
	}

	public static String deleteSuccess() {
		log.info("删除成功,请求结束");
		res.addProperty("status", "success");
		res.addProperty("message", "删除成功");
		return res.toString();
	}

	public static String deleteFailed() {
		log.error("删除失败,请求结束");
		res.addProperty("status", "failed");
		res.addProperty("message", "删除失败");
		return res.toString();
	}
}
