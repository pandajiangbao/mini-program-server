package com.panda.animeStore.exceptionHandler.error;

import lombok.ToString;

/**
 * @author panda
 * @date 2019-01-25 5:57 PM
 */
@ToString
public enum BusinessError {
    //参数为空或不符合格式
    PARAMETER_ERROR("参数错误"),
    //数据库操纵出错
    DATA_ACCESS_ERROR("数据库操作时错误"),
    //用户不存在
    USER_NOT_EXIST("用户不存在"),
    //登录失败
    LOGIN_FAILED("登录失败,密码错误"),
    //库存数量错误
    STOCK_ERROR("库存不足"),
    //文件为空
    FILE_EMPTY("文件为空"),
    //文件格式错误
    FILE_FORMAT_ERROR("文件格式错误");

    private String errMsg;

    BusinessError(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}