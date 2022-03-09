package com.payermax.sdk.client;

/**
 *
 */
public interface PayermaxClient {

    public static final PayermaxClient client = new DefaultPayermaxClient();
    public static PayermaxClient getInstance() {
        return client;
    }

    /**
     * 请求payermax处理类，并负责加签、验签
     * @param request
     * @return
     */
    public String send(String apiName, Object request);
    public String send(String apiName, Object request, String merchantNo);

    /**
     * 验证签名比如paymer回调进行签名验证
     * @param body
     * @param sign
     * @return
     */
    public boolean verifySign(String body, String sign);
    public boolean verifySign(String body, String sign, String merchantNo);




}
