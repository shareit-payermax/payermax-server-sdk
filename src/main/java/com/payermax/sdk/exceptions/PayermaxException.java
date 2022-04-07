package com.payermax.sdk.exceptions;

import com.payermax.sdk.enums.ErrorCodeEnum;

/**
 * @author zhu.q
 */
public class PayermaxException extends RuntimeException {
    private ErrorCodeEnum errorCode;

    public PayermaxException() {
        super();
    }

    public PayermaxException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public PayermaxException(Throwable cause) {
        super(cause);
    }

    public PayermaxException(ErrorCodeEnum code, String msg) {
        super(code + ":" + msg);
        this.errorCode = code;
    }

    public PayermaxException(ErrorCodeEnum codeEnum) {
        super(codeEnum.getCode() + ":" + codeEnum.getMsg());
        this.errorCode = codeEnum;
    }

    public ErrorCodeEnum getErrorCode() {
        return errorCode;
    }
}
