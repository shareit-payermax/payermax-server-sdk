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

    private static MerchantConfig DEFAULT_MERCHANT_CONFIG = null;

    private static final Map<String, MerchantConfig> MERCHANT_CONFIG_MAP = new ConcurrentHashMap<>();


    public static void setDefaultConfig(MerchantConfig defaultMerchantConfig) {
        DEFAULT_MERCHANT_CONFIG = defaultMerchantConfig;
        MERCHANT_CONFIG_MAP.put(defaultMerchantConfig.getMerchantNo(), defaultMerchantConfig);
    }

    public static void addConfig(MerchantConfig config) {
        if (StringUtils.isEmpty(config.getMerchantAppId())) {
            throw new PayermaxException(ErrorCodeEnum.CONFIG_INVALID, "merchantAppId is empty");
        }
        if (StringUtils.isEmpty(config.getMerchantPrivateKey())) {
            throw new PayermaxException(ErrorCodeEnum.CONFIG_INVALID, "merchantPrivateKey is empty");
        }
        if (StringUtils.isEmpty(config.getPayermaxPublicKey())) {
            throw new PayermaxException(ErrorCodeEnum.CONFIG_INVALID, "payermaxPublicKey is empty");
        }
        MERCHANT_CONFIG_MAP.put(config.getMerchantNo(), config);
    }

    public static MerchantConfig getDefaultConfig() {
        if (DEFAULT_MERCHANT_CONFIG == null) {
            throw new PayermaxException(ErrorCodeEnum.CONFIG_INVALID, "default merchant config is null");
        }
        return DEFAULT_MERCHANT_CONFIG;
    }

    public static MerchantConfig getConfig(String merchantNo) {

        if (StringUtils.isEmpty(merchantNo)) {
            throw new PayermaxException(ErrorCodeEnum.PARAMS_INVALID, "merchantNo is empty");
        }

        MerchantConfig merchantConfig = MERCHANT_CONFIG_MAP.get(merchantNo);
        if (merchantConfig == null) {
            throw new PayermaxException(ErrorCodeEnum.PARAMS_INVALID,
                    "can not find merchant config by merchantNo:" + merchantNo);
        }
        return merchantConfig;
    }

}
