package com.payermax.sdk.domain;

import java.io.Serializable;

/**
 * 网关请求领域模型 新架构
 *
 * @author zhu.q
 * @author zhanglong
 */
public class GatewayRequest implements Serializable {
    /**
     * 格式为 yyyy-MM-dd'T'HH:mm:ss.SSSZ,  符合ISO 8601 规范，paymax会校验此时间和服务器的时间差不超过两分钟
     */
    private String requestTime;
    private String version = "1.4";
    private String appId;
    private String merchantNo;
    private String spMerchantNo;
    private String keyVersion = "1";
    private Object data;

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    public String getSpMerchantNo() {
        return spMerchantNo;
    }

    public void setSpMerchantNo(String spMerchantNo) {
        this.spMerchantNo = spMerchantNo;
    }

    public String getKeyVersion() {
        return keyVersion;
    }

    public void setKeyVersion(String keyVersion) {
        this.keyVersion = keyVersion;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
