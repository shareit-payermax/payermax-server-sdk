package com.payermax.sdk.enums;

/**
 * @author zhu.q
 */
public enum ErrorCodeEnum {

    /**
     * CONFIG_INVALID
     */
    CONFIG_INVALID("merchant config invalid"),

    /**
     * check sign error
     */
    CHECK_SIGN_ERROR("check sign error"),

    /**
     * invoke error
     */
    INVOKE_ERROR("invoke error"),

    /**
     * PARAMS_INVALID
     */
    PARAMS_INVALID(""),
    ;

    private final String msg;

    ErrorCodeEnum(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return name();
    }


    public String getMsg() {
        return msg;
    }
}
