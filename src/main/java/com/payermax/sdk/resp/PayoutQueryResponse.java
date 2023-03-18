package com.payermax.sdk.resp;


import com.payermax.sdk.req.PayoutRequest;

import java.io.Serializable;

/**
 * @author ctl
 **/
public class PayoutQueryResponse implements Serializable {
    private static final long serialVersionUID = 5793977216189911546L;
    /**
     * 商户订单号
     * <p>
     * sample:  MO20211118000001
     */
    private String outTradeNo;

    /**
     * 交易单号
     * <p>
     * sample:  20201112400101244339
     */
    private String tradeNo;

    /**
     * 交易订单状态(PENDING,SUCCESS,FAILED,BOUNCEBACK)
     * <p>
     * sample:  SUCCESS
     */
    private String status;
    /**
     * 交易创建时间
     * <p>
     * sample:  ID
     */
    private String transactionUtcTime;

    /**
     * 该笔订单可以取款的最晚时间（仅在线下场景中出现）
     */
    private String expiryTime;
    /**
     * 取款码
     */
    private String redeemCode;
    /**
     * 该笔订单成功、失败的时间
     */
    private String payFinishTime;
    /**
     * 该笔订单退票的时间（仅在退票中出现）
     */
    private String bounceBackTime;

    /**
     * 附加数据，原样返回
     */
    private String reference;

    /**
     * 通知电话
     */
    private String notifyPhone;
    /**
     * 通知email
     */
    private String notifyEmail;
    /**
     * 失败错误码
     */
    private String responseCode;

    /**
     * 失败描述
     */
    private String responseMsg;

    /**
     * 交易金额信息
     */
    private PayoutRequest.Trade trade;

    /**
     * 付款金额信息
     */
    private Source source;

    /**
     * 到账金额信息
     */
    private Destination destination;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionUtcTime() {
        return transactionUtcTime;
    }

    public void setTransactionUtcTime(String transactionUtcTime) {
        this.transactionUtcTime = transactionUtcTime;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getRedeemCode() {
        return redeemCode;
    }

    public void setRedeemCode(String redeemCode) {
        this.redeemCode = redeemCode;
    }

    public String getPayFinishTime() {
        return payFinishTime;
    }

    public void setPayFinishTime(String payFinishTime) {
        this.payFinishTime = payFinishTime;
    }

    public String getBounceBackTime() {
        return bounceBackTime;
    }

    public void setBounceBackTime(String bounceBackTime) {
        this.bounceBackTime = bounceBackTime;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNotifyPhone() {
        return notifyPhone;
    }

    public void setNotifyPhone(String notifyPhone) {
        this.notifyPhone = notifyPhone;
    }

    public String getNotifyEmail() {
        return notifyEmail;
    }

    public void setNotifyEmail(String notifyEmail) {
        this.notifyEmail = notifyEmail;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public PayoutRequest.Trade getTrade() {
        return trade;
    }

    public void setTrade(PayoutRequest.Trade trade) {
        this.trade = trade;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public static final class Source implements Serializable {

        private static final long serialVersionUID = -6498233477607373626L;
        /**
         * 扣费金额，为扣除付款方账户的金额
         */
        private String amount;
        /**
         * 扣费币种，为扣除付款方账户的币种
         */
        private String currency;
        /**
         * 付款方承担的手续费
         */
        private String fee;

        private String feeCurrency;
        /**
         * 付款方承担的税费
         */
        private String tax;
        /**
         * 收款方承担的税费币种
         */
        private String taxCurrency;
        /**
         * 交易金额转换为扣费金额使用的汇率
         */
        private String exchangeRate;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getFee() {
            return fee;
        }

        public void setFee(String fee) {
            this.fee = fee;
        }

        public String getFeeCurrency() {
            return feeCurrency;
        }

        public void setFeeCurrency(String feeCurrency) {
            this.feeCurrency = feeCurrency;
        }

        public String getTax() {
            return tax;
        }

        public void setTax(String tax) {
            this.tax = tax;
        }

        public String getTaxCurrency() {
            return taxCurrency;
        }

        public void setTaxCurrency(String taxCurrency) {
            this.taxCurrency = taxCurrency;
        }

        public String getExchangeRate() {
            return exchangeRate;
        }

        public void setExchangeRate(String exchangeRate) {
            this.exchangeRate = exchangeRate;
        }
    }

    public static final class Destination implements Serializable {

        private static final long serialVersionUID = -6498233477604373626L;
        /**
         * 收款方到账金额
         */
        private String amount;
        /**
         * 收款方到账币种
         */
        private String currency;
        /**
         * 收款方承担的手续费
         */
        private String fee;
        /**
         * 收款方承担的手续费币种
         */
        private String feeCurrency;
        /**
         * 收款方承担的税费
         */
        private String tax;
        /**
         * 收款方承担的税费币种
         */
        private String taxCurrency;
        /**
         * 交易金额转换为支付金额使用的汇率
         */
        private String exchangeRate;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getFee() {
            return fee;
        }

        public void setFee(String fee) {
            this.fee = fee;
        }

        public String getFeeCurrency() {
            return feeCurrency;
        }

        public void setFeeCurrency(String feeCurrency) {
            this.feeCurrency = feeCurrency;
        }

        public String getTax() {
            return tax;
        }

        public void setTax(String tax) {
            this.tax = tax;
        }

        public String getTaxCurrency() {
            return taxCurrency;
        }

        public void setTaxCurrency(String taxCurrency) {
            this.taxCurrency = taxCurrency;
        }

        public String getExchangeRate() {
            return exchangeRate;
        }

        public void setExchangeRate(String exchangeRate) {
            this.exchangeRate = exchangeRate;
        }
    }

}
