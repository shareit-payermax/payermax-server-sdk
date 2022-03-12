package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.TradeQueryResponse;

import java.io.Serializable;

/**
 * 交易查询
 *
 * @param
 * @author raoxw
 * @date 2021/12/1 20:08
 * @return
 **/
public class TradeQueryRequest extends BaseRequest<TradeQueryResponse> implements Serializable {

    /**
     * 商户订单号【特殊可选-和交易订单号至少必输一个】
     *
     * @mock Test20211124000000039
     */
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
