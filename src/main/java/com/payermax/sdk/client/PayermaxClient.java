package com.payermax.sdk.client;

import com.payermax.sdk.config.MerchantConfig;

/**
 *
 */
public interface PayermaxClient {


    /**
     * 请求payermax处理类，并负责加签、验签
     * @param request
     * @return
     */
    public String send(String apiName, Object request);
    public String send(String apiName, Object request, MerchantConfig customerConfig);

    /**
     * 验证签名比如paymer回调进行签名验证
     * @param body
     * @param sign
     * @return
     */
    public boolean verifySign(String body, String sign);
    public boolean verifySign(String body, String sign, MerchantConfig customerConfig);

    public static PayermaxClient defaultInstance(MerchantConfig config) {
        return new DefaultPayermaxClient(config);
    }
}
