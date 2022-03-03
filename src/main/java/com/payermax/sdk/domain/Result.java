package com.payermax.sdk.domain;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private String code;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public Result(T data, String msg, String code) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Result<T> mapper(Result<?> biz) {
        this.setCode(biz.getCode());
        this.setMsg(biz.getMsg());
        return this;
    }

    public boolean isSuccess() {
        return "APPLY_SUCCESS".equals(this.code);
    }

    public String toString() {
        return "Result{code='" + this.code + '\'' + ", msg='" + this.msg + '\'' + ", data=" + this.data + '}';
    }
}
