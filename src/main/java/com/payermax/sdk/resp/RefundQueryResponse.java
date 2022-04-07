package com.payermax.sdk.resp;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author raoxw
 **/
public class RefundQueryResponse implements Serializable {
    private static final long serialVersionUID = -345588528576865187L;

    /**
     * 退款申请号
     */
    private String outRefundNo;

    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 退款交易单号
     */
    private String refundTradeNo;

    /**
     * 退款状态
     */
    private String status;

    /**
     * 交易状态结果描述
     */
    private String resultMsg;

    /**
     * 退款金额
     */
    private BigDecimal refundAmount;
    /**
     * 退款币种
     */
    private String refundCurrency;

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getRefundTradeNo() {
        return refundTradeNo;
    }

    public void setRefundTradeNo(String refundTradeNo) {
        this.refundTradeNo = refundTradeNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundCurrency() {
        return refundCurrency;
    }

    public void setRefundCurrency(String refundCurrency) {
        this.refundCurrency = refundCurrency;
    }
}
