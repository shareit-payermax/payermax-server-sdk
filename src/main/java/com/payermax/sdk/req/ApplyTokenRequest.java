package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.ApplyTokenResponse;

import java.io.Serializable;

/**
 * @author raoxw
 **/
public class ApplyTokenRequest extends BaseRequest<ApplyTokenResponse> implements Serializable {

    private static final long serialVersionUID = 639088064924524423L;
    /**
     * 商户订单号
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

    @Override
    protected String getApiName() {
        return "applyToken";
    }
}
