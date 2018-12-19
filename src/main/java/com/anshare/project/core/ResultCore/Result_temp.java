package com.anshare.project.core.ResultCore;

import com.alibaba.fastjson.JSON;

/**
 * 统一API响应结果封装
 */
public class Result_temp<T> {
    private int code;
    private String msg;
    private T result;

    public Result_temp setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return msg;
    }

    public Result_temp setMessage(String message) {
        this.msg = message;
        return this;
    }

    public T getData() {
        return result;
    }

    public Result_temp setData(T data) {
        this.result = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
