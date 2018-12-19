package com.anshare.project.core.ResultCore;

/**
 * 响应结果生成工具
 */
public class ResultGenerator_temp {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result_temp genSuccessResult() {
        return new Result_temp()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }
    public static Result_temp genSuccessResult(String message) {
        return new Result_temp()
                .setCode(ResultCode.SUCCESS)
                .setMessage(message);
    }
    public static Result_temp genSuccessResult(String data,String message) {
        return new Result_temp()
                .setCode(ResultCode.SUCCESS)
                .setMessage(message)
        .setData(data);
    }

    public static <T> Result_temp<T> genSuccessResult(T data) {
        return new Result_temp()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static <T> Result_temp<T> genSuccessResult(T data,String message) {
        return new Result_temp()
                .setCode(ResultCode.SUCCESS)
                .setMessage(message)
                .setData(data);
    }

    public static Result_temp genFailResult(String message) {
        return new Result_temp()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }
    public static Result_temp genAuthTokenErrResult(String message) {
        return new Result_temp()
                .setCode(ResultCode.UNAUTHORIZED)
                .setMessage(message);
    }
}
