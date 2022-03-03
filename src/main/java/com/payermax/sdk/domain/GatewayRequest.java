package com.payermax.sdk.domain;

import java.io.Serializable;

/**
 * 网关请求领域模型 新架构
 * @design zhanglong
 * @author zhu.q
 */
public class GatewayRequest implements Serializable {
    /**
     * 格式为 yyyy-MM-dd'T'HH:mm:ss.SSSZ,  符合ISO 8601 规范，paymax会校验此时间和服务器的时间差不超过两分钟
     */
    private String requestTime;
    private String version = "1.0";
    private String merchantAppId;
    private String merchantNo;
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

    public String getMerchantAppId() {
        return merchantAppId;
    }

    public void setMerchantAppId(String merchantAppId) {
        this.merchantAppId = merchantAppId;
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
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
