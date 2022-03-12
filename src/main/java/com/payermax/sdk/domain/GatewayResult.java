package com.payermax.sdk.domain;

import java.io.Serializable;

public class GatewayResult<T> implements Serializable {
    private String code;
    private String msg;
    private T data;

    public GatewayResult() {
    }

    public GatewayResult(T data) {
        this.data = data;
    }

    public GatewayResult(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public GatewayResult(T data, String msg, String code) {
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

    public GatewayResult<T> mapper(GatewayResult<?> biz) {
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
