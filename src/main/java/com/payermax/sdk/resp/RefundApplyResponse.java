package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * @author raoxw
 * @date 2021/12/2 20:30
 * @description
 **/
public class RefundApplyResponse implements Serializable {

    private static final long serialVersionUID = -8306500846105063312L;
    /**
     * 商户退款申请号
     *
     * @mock RE2021111814340001
     */
    private String outRefundNo;
    /**
     * 退款订单号
     *
     * @mock RE2021111814410001
     */
    private String refundTradeNo;

    /**
     * 原始交易单号
     *
     * @mock 20201112400101244339
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
