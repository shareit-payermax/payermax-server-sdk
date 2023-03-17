package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.PayoutQueryResponse;


/**
 * 交易查询
 *
 * @param
 * @author ctl
 * @return
 **/
public class PayoutQueryRequest extends BaseRequest<PayoutQueryResponse> {

    private static final long serialVersionUID = 8307443010191124381L;
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
        return "paymentOrderQry";
    }
}
