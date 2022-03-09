package com.payermax.sdk.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.payermax.sdk.client.PayermaxClient;
import com.payermax.sdk.config.MerchantConfig;
import com.payermax.sdk.domain.GatewayResult;
import com.payermax.sdk.req.*;
import com.payermax.sdk.resp.*;

/**
 * @author zhu.q
 */
public abstract class BaseRequest<RESP> {

    public GatewayResult<RESP> send(String merchantNo) {
        String result = PayermaxClient.getInstance().send(getApiName(), this, merchantNo);
        return JSON.parseObject(result, new TypeReference<GatewayResult<RESP>>(){});
    }

    public GatewayResult<RESP> send() {
        return this.send(null);
    }

    /**
     * 接口名称
     * @return
     */
    protected abstract String getApiName();
}
