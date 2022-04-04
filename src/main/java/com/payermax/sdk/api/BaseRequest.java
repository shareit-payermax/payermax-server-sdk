package com.payermax.sdk.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.payermax.sdk.client.DefaultPayermaxClient;
import com.payermax.sdk.domain.GatewayResult;

/**
 * @author zhu.q
 */
public abstract class BaseRequest<RESP> {

    public GatewayResult<RESP> send(String merchantNo) {
        String result = DefaultPayermaxClient.getInstance().send(getApiName(), this, merchantNo);
        return JSON.parseObject(result, new TypeReference<GatewayResult<RESP>>() {
        });
    }

    public GatewayResult<RESP> send() {
        return this.send(null);
    }

    /**
     * 接口名称
     *
     * @return
     */
    protected abstract String getApiName();
}
