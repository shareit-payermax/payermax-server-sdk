package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * @author raoxw
 **/
public class RefundApplyResponse implements Serializable {

    private static final long serialVersionUID = -8306500846105063312L;
    /**
     * 商户退款申请号
     */
    private String outRefundNo;
    /**
     * 退款订单号
     */
    private String refundTradeNo;

    /**
     * 原始交易单号
     */
    private String tradeOrderNo;

    /**
     * 退款状态
     */
    private String status;

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

    public String getTradeOrderNo() {
        return tradeOrderNo;
    }

    public void setTradeOrderNo(String tradeOrderNo) {
        this.tradeOrderNo = tradeOrderNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
