package com.payermax.sdk.config;

import com.payermax.sdk.enums.ErrorCodeEnum;
import com.payermax.sdk.exceptions.PayermaxException;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhu.q
 */
public class GlobalMerchantConfig {

    private static Map<String, MerchantConfig> merchantMap = new ConcurrentHashMap<>();

    public static void addConfig(MerchantConfig config) {
        if (StringUtils.isEmpty(config.getMerchantNo())) {
            throw new PayermaxException(ErrorCodeEnum.PARAMS_INVALID.getCode(), "merchantNo is null");
        }
        if (StringUtils.isEmpty(config.getMerchantAppId())) {
            throw new PayermaxException(ErrorCodeEnum.PARAMS_INVALID.getCode(), "merchantAppId is null");
        }
        if (StringUtils.isEmpty(config.getMerchantPrivateKey())) {
            throw new PayermaxException(ErrorCodeEnum.PARAMS_INVALID.getCode(), "merchantPrivateKey is null");
        }
        if (StringUtils.isEmpty(config.getPayermaxPublicKey())) {
            throw new PayermaxException(ErrorCodeEnum.PARAMS_INVALID.getCode(), "payermaxPublicKey is null");
        }
        if (StringUtils.isEmpty(config.getPayerMaxBaseUrl())) {
            throw new PayermaxException(ErrorCodeEnum.PARAMS_INVALID.getCode(), "payermaxBaseUrl is null");
        }
        merchantMap.put(config.getMerchantNo(), config);
    }

    public static MerchantConfig getConfig(String merchantNo) {

        if(StringUtils.isEmpty(merchantNo)) {
            return getDefaultConfig();
        }

        MerchantConfig merchantConfig = merchantMap.get(merchantNo);
        if(merchantConfig == null) {
            throw new PayermaxException(ErrorCodeEnum.PARAMS_INVALID.getCode(), "找不到商户配置信息");
        }
        return merchantConfig;
    }

    public static MerchantConfig getDefaultConfig() {
        if (merchantMap.size() == 1) {
            return merchantMap.entrySet().iterator().next().getValue();
        }

        if(merchantMap.size() > 1) {
            throw new PayermaxException(ErrorCodeEnum.PARAMS_INVALID.getCode(), "多商户配置请传递对应的商户号");
        }

        //<=1
        throw new PayermaxException(ErrorCodeEnum.PARAMS_INVALID.getCode(), "请配置商户信息");
    }


}
