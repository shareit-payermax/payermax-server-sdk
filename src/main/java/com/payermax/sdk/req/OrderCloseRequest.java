package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.OrderCloseResponse;

import java.io.Serializable;


/**
 * @description: 商户交易关单请求体
 * @author: WangTao
 * @create: 2023-08-23 21:37
 **/

public class OrderCloseRequest extends BaseRequest<OrderCloseResponse> implements Serializable {
    private static final long serialVersionUID = 639088064924524423L;

    private String outTradeNo;
    /**
     * 请求原因
     */
    private String reason;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    protected String getApiName() {
        return "orderClose";
    }
}
