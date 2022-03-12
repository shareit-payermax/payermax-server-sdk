package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * @author raoxw
 * @date 2021/12/2 20:10
 * @description
 **/
public class TradePayOrderResponse implements Serializable {
    private static final long serialVersionUID = 2649437349115114791L;
    /**
     * 商户订单号
     *
     * @mock Test202111092100001
     */
    private String outTradeNo;
    /**
     * 交易token
     *
     * @mock 20201112400101244339
     */
    private String tradeToken;

    /**
     * 交易订单号
     *
     * @mock 20201112400101244301
     */
    private String tradeOrderNo;

    /**
     * 重定向Url
     *
     * @mock http://paymax.xxx.com
     */
    private String redirectUrl;

    /**
     * 隐藏页面地址，在Iframe框中隐藏打开
     *
     * @mock http://paymax.xxx.com
     */
    private String secureUrl;
    /**
     * 交易状态
     *
     * @mock SUCCESS
     */
    private String status;

    /**
     * 交易状态结果描述
     *
     * @mock SUCCESS
     */
    private String resultMsg;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeToken() {
        return tradeToken;
    }

    public void setTradeToken(String tradeToken) {
        this.tradeToken = tradeToken;
    }

    public String getTradeOrderNo() {
        return tradeOrderNo;
    }

    public void setTradeOrderNo(String tradeOrderNo) {
        this.tradeOrderNo = tradeOrderNo;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getSecureUrl() {
        return secureUrl;
    }

    public void setSecureUrl(String secureUrl) {
        this.secureUrl = secureUrl;
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
}
