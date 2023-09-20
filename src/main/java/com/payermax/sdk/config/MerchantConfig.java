package com.payermax.sdk.config;

/**
 * @author zhu.q
 */
public class MerchantConfig {

    private String merchantPrivateKey;

    private String payermaxPublicKey;

    private String appId;

    private String merchantNo;

    private String spMerchantNo;

    private String merchantAuthToken;

    private boolean needCheckSign = true;

    private String apiVersion;

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
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

    public boolean isNeedCheckSign() {
        return needCheckSign;
    }

    public void setNeedCheckSign(boolean needCheckSign) {
        this.needCheckSign = needCheckSign;
    }

    public String getMerchantPrivateKey() {
        return merchantPrivateKey;
    }

    public void setMerchantPrivateKey(String merchantPrivateKey) {
        this.merchantPrivateKey = merchantPrivateKey;
    }

    public String getPayermaxPublicKey() {
        return payermaxPublicKey;
    }

    public void setPayermaxPublicKey(String payermaxPublicKey) {
        this.payermaxPublicKey = payermaxPublicKey;
    }

    public String getSpMerchantNo() {
        return spMerchantNo;
    }

    public void setSpMerchantNo(String spMerchantNo) {
        this.spMerchantNo = spMerchantNo;
    }

    public String getMerchantAuthToken() {
        return merchantAuthToken;
    }

    public void setMerchantAuthToken(String merchantAuthToken) {
        this.merchantAuthToken = merchantAuthToken;
    }

    public static final class Builder {
        private String merchantPrivateKey;
        private String payermaxPublicKey;
        private String appId;
        private String merchantNo;
        private String spMerchantNo;
        private String merchantAuthToken;
        private boolean checkSign = true;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder merchantPrivateKey(String merchantPrivateKey) {
            this.merchantPrivateKey = merchantPrivateKey;
            return this;
        }

        public Builder payermaxPublicKey(String payermaxPublicKey) {
            this.payermaxPublicKey = payermaxPublicKey;
            return this;
        }

        public Builder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public Builder merchantNo(String merchantNo) {
            this.merchantNo = merchantNo;
            return this;
        }

        public Builder checkSign(boolean checkSign) {
            this.checkSign = checkSign;
            return this;
        }
        public Builder spMerchantNo(String spMerchantNo) {
            this.spMerchantNo = spMerchantNo;
            return this;
        }

        public Builder merchantAuthToken(String merchantAuthToken) {
            this.merchantAuthToken = merchantAuthToken;
            return this;
        }

        public MerchantConfig build() {
            MerchantConfig payermaxMerchantConfig = new MerchantConfig();
            payermaxMerchantConfig.setMerchantPrivateKey(merchantPrivateKey);
            payermaxMerchantConfig.setPayermaxPublicKey(payermaxPublicKey);
            payermaxMerchantConfig.setAppId(appId);
            payermaxMerchantConfig.setMerchantNo(merchantNo);
            payermaxMerchantConfig.setSpMerchantNo(spMerchantNo);
            payermaxMerchantConfig.setMerchantAuthToken(merchantAuthToken);
            payermaxMerchantConfig.setNeedCheckSign(checkSign);
            return payermaxMerchantConfig;
        }
    }
}
