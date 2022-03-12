package com.payermax.sdk.client;

/**
 *
 */
public interface PayermaxClient {

    PayermaxClient client = new DefaultPayermaxClient();
    static PayermaxClient getInstance() {
        return client;
    }

    /**
     * 请求payermax处理类，并负责加签、验签
     * @param request
     * @return
     */
    String send(String apiName, Object request);
    String send(String apiName, Object request, String merchantNo);

    /**
     * 验证签名比如paymer回调进行签名验证
     * @param body
     * @param sign
     * @return
     */
    boolean verifySign(String body, String sign);
    boolean verifySign(String body, String sign, String merchantNo);




}
