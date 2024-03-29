package com.payermax.sdk.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.payermax.sdk.client.DefaultPayermaxClient;
import com.payermax.sdk.config.MerchantConfig;
import com.payermax.sdk.domain.GatewayResult;

import java.lang.reflect.ParameterizedType;

/**
 * @author zhu.q
 */
public abstract class BaseRequest<RESP> {

    public GatewayResult<RESP> send(String merchantNo) {
        String result = DefaultPayermaxClient.getInstance().send(getApiName(), this, merchantNo);
        return JSON.parseObject(result, new TypeReference<GatewayResult<RESP>>(
                ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]) {
        });
    }

    public GatewayResult<RESP> sendByconfig(MerchantConfig config) {
        String result = DefaultPayermaxClient.getInstance().send(getApiName(), this, config);
        return JSON.parseObject(result, new TypeReference<GatewayResult<RESP>>(
                ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]) {
        });
    }

    public GatewayResult<RESP> send() {
        return this.send(null);
    }

    /**
     * 接口名称
     *
     * @return api name
     */
    protected abstract String getApiName();
}
