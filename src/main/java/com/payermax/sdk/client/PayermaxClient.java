package com.payermax.sdk.client;

import com.payermax.sdk.config.MerchantConfig;
import com.payermax.sdk.enums.Env;

/**
 * @author zhu.q
 */
public interface PayermaxClient {

    /**
     * set env
     *
     * @param env env
     */
    void setEnv(Env env);

    /**
     * Send the request with the default merchantNo
     * use default merchant config
     *
     * @param apiName apiName
     * @param request requestObject
     * @return json content
     */
    String send(String apiName, Object request);

    /**
     * Use the specified merchantNO to send the request, when you have multiple merchantNo, please use this method to
     * send request.
     *
     * @param apiName    apiName
     * @param request    requestObject
     * @param merchantNo merchantNo
     * @return json content
     */
    String send(String apiName, Object request, String merchantNo);

    String send(String apiName, Object request, MerchantConfig config);

    /**
     * used to verify the notification come from payermax
     *
     * @param body notification's http body content
     * @param sign the signature in http header
     * @return verify result
     */
    boolean verifyNotification(String body, String sign);

}
