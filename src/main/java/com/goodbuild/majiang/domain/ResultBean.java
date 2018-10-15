package com.goodbuild.majiang.domain;

import java.io.Serializable;

/**
 * @Author: xue.l
 * @Date: 2018/10/11 16:02
 * @Description:
 * @Version: 1.0.0
 */
public class ResultBean<T extends Serializable> implements Serializable {

    public static final int SUCCESSFUL = 200;

    public static final int FAILURE = 300;

   private int code;

    private String message;

   private T data;


    public ResultBean(T data) {
        this.data = data;
        code = SUCCESSFUL;
    }

    public ResultBean(Throwable e) {
        message = e.toString();
        code = FAILURE;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
