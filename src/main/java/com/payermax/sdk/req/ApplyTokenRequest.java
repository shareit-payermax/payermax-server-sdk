package com.payermax.sdk.req;

import java.io.Serializable;

/**
 * @Author: raoxw
 * @date 2022/1/17 19:28
 * @description
 **/
public class ApplyTokenRequest implements Serializable {

    private static final long serialVersionUID = 639088064924524423L;
    /**
     * 商户订单号
     *
     * @mock Test20211124000000039
     */
    private String outTradeNo;

    /**
     * 接口版本
     */
    protected String version;

    /**
     * 国家
     */
    private String country;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
