package com.goodbuild.majiang.exception;

/**
 * @Title: 人数不足异常
 * @ProjectName MaJiang
 * @Description:
 * @Author xuelong
 * @Date 2018/9/25下午2:38
 * @Version 1.0.0
 */
public class ExistentException extends Exception {
    private static String errorCode = "10008";
    private static String errorMsg = "已经存在";

    public ExistentException() {
        super(errorMsg);
    }

    public ExistentException(String errorMsg ) {
        super(errorMsg);
    }
}
