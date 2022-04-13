package com.payermax.sdk.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.payermax.sdk.config.GlobalMerchantConfig;
import com.payermax.sdk.config.MerchantConfig;
import com.payermax.sdk.domain.GatewayRequest;
import com.payermax.sdk.domain.GatewayResult;
import com.payermax.sdk.enums.Env;
import com.payermax.sdk.enums.ErrorCodeEnum;
import com.payermax.sdk.exceptions.PayermaxException;
import com.payermax.sdk.utils.RsaUtils;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author zhu.q
 */
public class DefaultPayermaxClient implements PayermaxClient {

    public static final MediaType JSON_TYPE = MediaType.get("application/json; charset=utf-8");
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
    public static final String HEADER_SIGN = "sign";
    public static final String HEADER_SDK_VER = "sdk-ver";
    public static final String SDK_VER = "1.0.0";

    private String baseUrl;

    private Env env;

    private OkHttpClient httpClient = new OkHttpClient().newBuilder()
            .retryOnConnectionFailure(false)
            .connectionPool(new ConnectionPool(200, 5, TimeUnit.MINUTES))
            .callTimeout(15L, TimeUnit.SECONDS)
            .build();

    private static final DefaultPayermaxClient INSTANCE = new DefaultPayermaxClient();

    public static DefaultPayermaxClient getInstance() {
        return INSTANCE;
    }

    /**
     * custom httpclient
     *
     * @param httpClient http client
     */
    public void setHttpClient(OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Override
    public void setEnv(Env env) {
        this.env = env;
        this.baseUrl = env.getUrl();
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String send(String apiName, Object busData) {
        return this.send(apiName, busData, (String) null);
    }

    @Override
    public String send(String apiName, Object busData, String merchantNo) {
        MerchantConfig config;
        if (StringUtils.isNotBlank(merchantNo)) {
            config = GlobalMerchantConfig.getConfig(merchantNo);
        } else {
            config = GlobalMerchantConfig.getDefaultConfig();
        }
        return send(apiName, busData, config);
    }

    @NotNull
    private String send(String apiName, Object busData, MerchantConfig config) {
        try {
            String reqString = buildReqString(config, busData);
            RequestBody requestBody = RequestBody.create(reqString, JSON_TYPE);
            Request request = new Request.Builder()
                    .header(HEADER_SIGN, calcSign(config, reqString)).header(HEADER_SDK_VER, SDK_VER)
                    .url(this.baseUrl.concat("/").concat(apiName))
                    .post(requestBody)
                    .build();
            Response response = httpClient.newCall(request).execute();
            ResponseBody responseBody = response.body();
            if (responseBody == null) {
                throw new PayermaxException(ErrorCodeEnum.INVOKE_ERROR);
            }
            String respBody = responseBody.string();
            GatewayResult<?> gatewayResult = JSON.parseObject(respBody, GatewayResult.class);
            if (gatewayResult.isSuccess()) {
                checkSign(config, respBody, response.header(HEADER_SIGN));
            }
            return respBody;
        } catch (PayermaxException e) {
            throw e;
        } catch (Exception e) {
            throw new PayermaxException(e);
        }
    }

    @Override
    public boolean verifyNotification(String body, String sign) {
        JSONObject jsonObject = JSON.parseObject(body);
        String merchantNo = jsonObject.getString("merchantNo");
        MerchantConfig config = GlobalMerchantConfig.getConfig(merchantNo);
        if (!config.isNeedCheckSign()) {
            return true;
        }
        return RsaUtils.verify(body, sign, config.getPayermaxPublicKey(), RsaUtils.CHAR_SET);
    }

    private String buildReqString(MerchantConfig config, Object busData) {
        GatewayRequest busReq = new GatewayRequest();
        busReq.setData(busData);
        busReq.setMerchantNo(config.getMerchantNo());
        busReq.setMerchantAppId(config.getMerchantAppId());
        busReq.setRequestTime(DateFormatUtils.format(new Date(), DATE_FORMAT));

        return JSON.toJSONString(busReq);
    }

    private String calcSign(MerchantConfig config, String str) {
        return RsaUtils.signForRSA(str, config.getMerchantPrivateKey(), RsaUtils.CHAR_SET);
    }

    private void checkSign(MerchantConfig config, String str, String sign) {
        if (config.isNeedCheckSign() && !RsaUtils.verify(str, sign, config.getPayermaxPublicKey(), RsaUtils.CHAR_SET)) {
            throw new PayermaxException(ErrorCodeEnum.CHECK_SIGN_ERROR);
        }
    }

    public Env getEnv() {
        return env;
    }

    public OkHttpClient getHttpClient() {
        return httpClient;
    }
}
