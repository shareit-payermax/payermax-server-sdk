package com.payermax.sdk.enums;

public enum ErrorCodeEnum {

    SIGN_CHECK_INCORRECT("SIGN_CHECK_INCORRECT", "sign check incorrect"),
    PARAMS_INVALID("PARAMS_INVALID", ""),
    ;

    private String code;
    private String msg;

    ErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
