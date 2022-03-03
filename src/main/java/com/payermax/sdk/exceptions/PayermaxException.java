package com.payermax.sdk.exceptions;

import com.payermax.sdk.enums.ErrorCodeEnum;

/**
 * @author zhu.q
 */
public class PayermaxException extends RuntimeException{
    private String msg;
    private String code;

    public PayermaxException() {
        super();
    }

    public PayermaxException(Throwable cause, String msg) {
        super(cause);
        this.msg = msg;
    }

    public PayermaxException(Throwable cause) {
        super(cause);
    }

    public PayermaxException(String code, String msg) {
        super(code + ":" + msg);
        this.code = code;
        this.msg = msg;
    }

    public PayermaxException(ErrorCodeEnum codeEnum) {
        super(codeEnum.getCode() + ":" + codeEnum.getMsg());
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
    }
}
