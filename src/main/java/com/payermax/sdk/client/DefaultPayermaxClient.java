package com.payermax.sdk.client;

import com.alibaba.fastjson.JSON;
import com.payermax.sdk.config.MerchantConfig;
import com.payermax.sdk.domain.GatewayRequest;
import com.payermax.sdk.domain.Result;
import com.payermax.sdk.enums.ErrorCodeEnum;
import com.payermax.sdk.exceptions.PayermaxException;
import com.payermax.sdk.utils.RsaUtils;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import javax.management.DescriptorAccess;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author zhu.q
 */
public class DefaultPayermaxClient implements PayermaxClient{

    public static final MediaType JSON_TYPE = MediaType.get("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient().newBuilder()
            .retryOnConnectionFailure(false)
            .connectionPool(new ConnectionPool(200, 5, TimeUnit.MINUTES))
            .callTimeout(15L, TimeUnit.SECONDS)
            .build();

    private MerchantConfig defaultConfig;

    public DefaultPayermaxClient(MerchantConfig config) {
        this.defaultConfig = config;
    }

    @Override
    public String send(String apiName, Object busData) {
        return this.send(apiName, busData, null);
    }

    @Override
    public String send(String apiName, Object busData, MerchantConfig customerConfig) {

        try {
            MerchantConfig config = getConfig(customerConfig);
            String reqString = buildReqString(config, busData);
            RequestBody body = RequestBody.create(reqString, JSON_TYPE);
            Request request = new Request.Builder()
                    .header("sign", calcSign(config, reqString))
                    .url(config.getPayerMaxBaseUrl().concat("/").concat(apiName))
                    .post(body)
                    .build();
            Response response = null;
            response = client.newCall(request).execute();
            String respBody = response.body().string();
            Result result = JSON.parseObject(respBody, Result.class);
            if(result.isSuccess()) {
                checkSign(config, respBody, response.header("sign"));
            }
            return respBody;
        } catch (PayermaxException e) {
            throw e;
        } catch (IOException e) {
            throw new PayermaxException(e);
        }
    }

    public boolean verifySign(String body, String sign) {
        return this.verifySign(body, sign, null);
    }
    @Override
    public boolean verifySign(String body, String sign, MerchantConfig customerConfig) {
        MerchantConfig config = getConfig(customerConfig);
        return RsaUtils.verify(body, sign, config.getPayermaxPublicKey(), RsaUtils.CHAR_SET);
    }

    private String buildReqString(MerchantConfig config, Object busData) {
        GatewayRequest busReq = new GatewayRequest();
        busReq.setData(busData);
        busReq.setMerchantNo(config.getMerchantNo());
        busReq.setMerchantAppId(config.getMerchantAppId());
        busReq.setRequestTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));

        return JSON.toJSONString(busReq);
    }

    private String calcSign(MerchantConfig config, String str) {
        return RsaUtils.signForRSA(str, config.getMerchantPrivateKey(), RsaUtils.CHAR_SET);
    }

    private void checkSign(MerchantConfig config, String str, String sign) {
        if(config.getCheckSign()) {
            if (!RsaUtils.verify(str, sign, config.getPayermaxPublicKey(), RsaUtils.CHAR_SET)) {
                throw new PayermaxException(ErrorCodeEnum.SIGN_CHECK_INCORRECT);
            }
        }
    }

    private MerchantConfig getConfig(MerchantConfig customerConfig) {
        if(customerConfig == null) {
            return this.defaultConfig;
        }

        if(StringUtils.isEmpty(customerConfig.getPayerMaxBaseUrl())) {
            customerConfig.setPayerMaxBaseUrl(defaultConfig.getPayerMaxBaseUrl());
        }

        if(StringUtils.isEmpty(customerConfig.getMerchantPrivateKey())) {
            customerConfig.setMerchantPrivateKey(defaultConfig.getMerchantPrivateKey());
        }

        if(StringUtils.isEmpty(customerConfig.getPayermaxPublicKey())) {
            customerConfig.setPayermaxPublicKey(defaultConfig.getPayermaxPublicKey());
        }

        if(StringUtils.isEmpty(customerConfig.getMerchantNo())) {
            customerConfig.setMerchantNo(defaultConfig.getMerchantNo());
        }

        if(StringUtils.isEmpty(customerConfig.getMerchantAppId())) {
            customerConfig.setMerchantAppId(defaultConfig.getMerchantAppId());
        }

        if(!customerConfig.getCheckSign()) {
            customerConfig.setCheckSign(Boolean.FALSE);
        }

        return customerConfig;
    }
}
