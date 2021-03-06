package com.payermax.sdk.config;

/**
 * @author zhu.q
 */
public class MerchantConfig {

    private String merchantPrivateKey;

    private String payermaxPublicKey;

    private String merchantAppId;

    private String merchantNo;

    private boolean needCheckSign = true;

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


    public static final class Builder {
        private String merchantPrivateKey;
        private String payermaxPublicKey;
        private String merchantAppId;
        private String merchantNo;
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

        public Builder merchantAppId(String merchantAppId) {
            this.merchantAppId = merchantAppId;
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

        public MerchantConfig build() {
            MerchantConfig payermaxMerchantConfig = new MerchantConfig();
            payermaxMerchantConfig.setMerchantPrivateKey(merchantPrivateKey);
            payermaxMerchantConfig.setPayermaxPublicKey(payermaxPublicKey);
            payermaxMerchantConfig.setMerchantAppId(merchantAppId);
            payermaxMerchantConfig.setMerchantNo(merchantNo);
            payermaxMerchantConfig.setNeedCheckSign(checkSign);
            return payermaxMerchantConfig;
        }
    }
}
