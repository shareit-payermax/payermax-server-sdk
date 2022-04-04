package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.RefundQueryResponse;

import java.io.Serializable;

/**
 * @author raoxw
 * @date 2021/12/1 20:08
 **/
public class RefundQueryRequest extends BaseRequest<RefundQueryResponse> implements Serializable {
    /**
     * 退款申请号【特殊可选-和退款交易单号字段有一个必填】
     */
    private String outRefundNo;
    /**
     * 退款交易单号【特殊可选-和退款申请号字段有一个必填】
     */
    private String refundTradeNo;

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getRefundTradeNo() {
        return refundTradeNo;
    }

    public void setRefundTradeNo(String refundTradeNo) {
        this.refundTradeNo = refundTradeNo;
    }

    @Override
    protected String getApiName() {
        return "refundQuery";
    }
}
