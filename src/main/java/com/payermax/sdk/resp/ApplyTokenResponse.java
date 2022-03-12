package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * @Author: raoxw
 * @date 2022/1/17 19:29
 * @description
 **/
public class ApplyTokenResponse implements Serializable {
    /**
     * 隐藏页面地址，在Iframe框中隐藏打开
     *
     * @mock http://paymax.xxx.com
     */
    private String secureUrl;

    /**
     * PayerMax流水号
     */
    private String tradeToken;

    /**
     * 商户订单号
     */
    private String outTradeNo;

    public String getSecureUrl() {
        return secureUrl;
    }

    public void setSecureUrl(String secureUrl) {
        this.secureUrl = secureUrl;
    }

    public String getTradeToken() {
        return tradeToken;
    }

    public void setTradeToken(String tradeToken) {
        this.tradeToken = tradeToken;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }
}
