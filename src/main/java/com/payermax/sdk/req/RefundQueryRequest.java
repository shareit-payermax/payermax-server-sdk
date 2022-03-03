package com.payermax.sdk.req;

import java.io.Serializable;

/**
 * @param
 * @author raoxw
 * @date 2021/12/1 20:08
 * @return
 **/
public class RefundQueryRequest implements Serializable {
    /**
     * 退款申请号【特殊可选-和退款交易单号字段有一个必输】
     *
     * @mock RE2021111814340001
     */
    private String outRefundNo;
    /**
     * 退款交易单号【特殊可选-和退款申请号字段有一个必输】
     *
     * @mock MO20211118000001
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
}
