package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.RefundApplyResponse;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 退款申请
 *
 * @author raoxw
 **/
public class RefundApplyRequest extends BaseRequest<RefundApplyResponse> implements Serializable {
    private static final long serialVersionUID = 3274773109795706046L;
    /**
     * 商户退款申请号
     */
    private String outRefundNo;
    /**
     * 商户订单号
     */
    private String outTradeNo;
    /**
     * 退款金额
     * 单位：元
     */
    private BigDecimal refundAmount;
    /**
     * 退款币种
     */
    private String refundCurrency;
    /**
     * 退款回调地址
     */
    private String refundNotifyUrl;
    /**
     * 退款说明（商户用户退款理由）
     */
    private String comments;
    /**
     * 请求来源
     * 0:重复支付退款 1:商户退款 2:运营平台退款 3:商户后台退款 4:商户后台退款
     */
    private Integer refundType;


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

    public String getRefundNotifyUrl() {
        return refundNotifyUrl;
    }

    public void setRefundNotifyUrl(String refundNotifyUrl) {
        this.refundNotifyUrl = refundNotifyUrl;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
    }

    @Override
    protected String getApiName() {
        return "refund";
    }
}
