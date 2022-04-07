package com.payermax.sdk.resp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author raoxw
 **/

public class TradeQueryResponse implements Serializable {
    /**
     * 商户订单号
     */
    private String outTradeNo;
    /**
     * 交易单号
     */
    private String tradeOrderNo;
    /**
     * 交易单号
     */
    private String tradeToken;
    /**
     * 交易金额
     */
    private BigDecimal totalAmount;
    /**
     * 交易币种
     */
    private String currency;
    /**
     * 交易订单状态(PENDING,SUCCESS,FAILED,CLOSE)
     */
    private String status;
    /**
     * 国家
     */
    private String country;
    /**
     * 附加数据，原样返回
     */
    private String reference;

    /**
     * 交易状态结果描述
     */
    private String resultMsg;

    private List<PaymentDetailItem> paymentDetails;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeOrderNo() {
        return tradeOrderNo;
    }

    public void setTradeOrderNo(String tradeOrderNo) {
        this.tradeOrderNo = tradeOrderNo;
    }

    public String getTradeToken() {
        return tradeToken;
    }

    public void setTradeToken(String tradeToken) {
        this.tradeToken = tradeToken;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public List<PaymentDetailItem> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(List<PaymentDetailItem> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public static class PaymentDetailItem implements Serializable {
        private static final long serialVersionUID = -3706297312399101958L;
        /**
         * 支付方式
         */
        private String paymentMethod;
        /**
         * 目标机构
         */
        private String targetOrg;

        /**
         * 卡组织
         */
        private String cardOrg;
        /**
         * 支付金额
         */
        private BigDecimal payAmount;
        /**
         * 支付币种
         */
        private String payCurrency;

        /**
         * 国家代码
         */
        private String country;
        /**
         * 支付方式类型
         */
        private String paymentMethodType;

        /**
         * 卡信息
         */
        private CardInfo cardInfo;

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public String getTargetOrg() {
            return targetOrg;
        }

        public void setTargetOrg(String targetOrg) {
            this.targetOrg = targetOrg;
        }

        public String getCardOrg() {
            return cardOrg;
        }

        public void setCardOrg(String cardOrg) {
            this.cardOrg = cardOrg;
        }

        public BigDecimal getPayAmount() {
            return payAmount;
        }

        public void setPayAmount(BigDecimal payAmount) {
            this.payAmount = payAmount;
        }

        public String getPayCurrency() {
            return payCurrency;
        }

        public void setPayCurrency(String payCurrency) {
            this.payCurrency = payCurrency;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getPaymentMethodType() {
            return paymentMethodType;
        }

        public void setPaymentMethodType(String paymentMethodType) {
            this.paymentMethodType = paymentMethodType;
        }

        public CardInfo getCardInfo() {
            return cardInfo;
        }

        public void setCardInfo(CardInfo cardInfo) {
            this.cardInfo = cardInfo;
        }
    }

    public static final class CardInfo implements Serializable {

        private static final long serialVersionUID = -6498233477607379626L;

        /**
         * 卡组织
         **/
        String cardOrg;

        public String getCardOrg() {
            return cardOrg;
        }

        public void setCardOrg(String cardOrg) {
            this.cardOrg = cardOrg;
        }
    }


}
