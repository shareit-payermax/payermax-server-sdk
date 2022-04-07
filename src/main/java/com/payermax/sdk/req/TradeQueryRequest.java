package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.TradeQueryResponse;

import java.io.Serializable;

/**
 * 交易查询
 *
 * @author raoxw
 **/
public class TradeQueryRequest extends BaseRequest<TradeQueryResponse> implements Serializable {

    private String outTradeNo;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    @Override
    protected String getApiName() {
        return "orderQuery";
    }
}
