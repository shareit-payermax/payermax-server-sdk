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
public class PayApi {


    private PayermaxClient client;

    public static PayApi getInstance(String url, String merchantPrivateKey, String payermaxPublicKey,
                              String merchantNo, String merchantAppId) {
        MerchantConfig config = MerchantConfig.Builder.builder()
                .payerMaxBaseUrl(url)
                .merchantPrivateKey(merchantPrivateKey)
                .payermaxPublicKey(payermaxPublicKey)
                .merchantNo(merchantNo)
                .merchantAppId(merchantAppId)
                .build();
        return new PayApi(PayermaxClient.defaultInstance(config));
    }

    public PayApi(PayermaxClient client) {
        this.client = client;
    }

    /**
     * 交易下单并支付
     *
     * @param tradeOrderRequest
     * @author raoxw
     * @date 2021/12/2 16:01
     */
    public GatewayResult<TradePayOrderResponse> orderAndPay(TradeOrderRequest tradeOrderRequest) {
        return this.orderAndPay(tradeOrderRequest, null);
    }

    public GatewayResult<TradePayOrderResponse> orderAndPay(TradeOrderRequest tradeOrderRequest, MerchantConfig config) {
        String result = client.send("orderAndPay", tradeOrderRequest, config);
        return JSON.parseObject(result, new TypeReference<GatewayResult<TradePayOrderResponse>>(){});
    }

    /**
     * 交易查询
     *
     * @param tradeQueryRequest
     * @author raoxw
     * @date 2021/12/2 16:01
     */
    public GatewayResult<TradeQueryResponse> orderQuery(TradeQueryRequest tradeQueryRequest, MerchantConfig config) {
        String result = client.send("orderQuery", tradeQueryRequest, config);
        return JSON.parseObject(result, new TypeReference<GatewayResult<TradeQueryResponse>>(){});
    }

    public GatewayResult<TradeQueryResponse> orderQuery(TradeQueryRequest tradeQueryRequest) {
        return this.orderQuery(tradeQueryRequest, null);
    }

    /**
     * 交易token注入
     *
     * @author raoxw
     * @date 2022/1/17 19:29
     **/
    public GatewayResult<ApplyTokenResponse> applyToken(ApplyTokenRequest applyTokenRequest, MerchantConfig config) {
        String result = client.send("applyToken", applyTokenRequest, config);
        return JSON.parseObject(result, new TypeReference<GatewayResult<ApplyTokenResponse>>(){});
    }

    public GatewayResult<ApplyTokenResponse> applyToken(ApplyTokenRequest applyTokenRequest) {
        return this.applyToken(applyTokenRequest, null);
    }


    /**
     * 退款申请
     *
     * @author raoxw
     * @date 2021/12/2 20:33
     */
    public GatewayResult<RefundApplyResponse> refund(RefundApplyRequest request, MerchantConfig config) {
        String result = client.send("refund", request, config);
        return JSON.parseObject(result, new TypeReference<GatewayResult<RefundApplyResponse>>(){});
    }

    public GatewayResult<RefundApplyResponse> refund(RefundApplyRequest request) {
        return this.refund(request);
    }

    /**
     * 退款查询
     *
     * @param request
     * @author raoxw
     * @date 2021/12/2 20:33
     */
    public GatewayResult<RefundQueryResponse> refundQuery(RefundQueryRequest request, MerchantConfig config) {
        String result = client.send("refundQuery", request, config);
        return JSON.parseObject(result, new TypeReference<GatewayResult<RefundQueryResponse>>(){});
    }

    public GatewayResult<RefundQueryResponse> refundQuery(RefundQueryRequest request) {
        return this.refundQuery(request, null);
    }


}
