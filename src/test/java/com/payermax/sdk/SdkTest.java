package com.payermax.sdk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.payermax.sdk.client.DefaultPayermaxClient;
import com.payermax.sdk.client.PayermaxClient;
import com.payermax.sdk.config.GlobalMerchantConfig;
import com.payermax.sdk.config.MerchantConfig;
import com.payermax.sdk.domain.GatewayResult;
import com.payermax.sdk.enums.Env;
import com.payermax.sdk.req.TradeOrderRequest;
import com.payermax.sdk.resp.TradePayOrderResponse;
import com.payermax.sdk.utils.RsaUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Hello world!
 */
public class SdkTest {

    private static PayermaxClient client;

    @BeforeClass
    public static void init() throws Exception {
        client = DefaultPayermaxClient.getInstance();
        client.setEnv(Env.UAT);
        // or set the other base url
        // client.setBaseUrl("https://the-other-url.payermax.com/aggregate-pay/api/gateway");

        // init default MerchantConfig
        Map<String, String> keyPair = RsaUtils.createKeyPair();
        String merchantPrivateKey = keyPair.get(RsaUtils.PRIVATE_KEY_NAME);
        String payermaxPublicKey = "get payermax public key from dashboard";
        String merchantNo = "get merchantNo from dashboard";
        String merchantAppId = "get appId from dashboard";
        MerchantConfig merchantConfig = MerchantConfig.Builder.builder()
                .merchantPrivateKey(merchantPrivateKey)
                .payermaxPublicKey(payermaxPublicKey)
                .merchantNo(merchantNo)
                .merchantAppId(merchantAppId)
                .build();
        GlobalMerchantConfig.setDefaultConfig(merchantConfig);
    }

    @Test(testName = "test use default merchant config and use common api mode")
    public void testUseDefaultMerchantConfig() throws Exception {

        //1.通用api调用 不论服务端是何接口都可以进行调用
        String json = "{\"outTradeNo\":\"out1254125412\",\"subject\":\"this is subject\",\"totalAmount\":\"10000\",\"currency\":\"IDR\",\"country\":\"ID\",\"userId\":\"userId\",\"language\":\"\",\"reference\":\"\",\"frontCallbackURL\":\"http://www.qq2ddsdfsadfsdfsd.com\",\"notifyUrl\":\"http://www.noticddddasdfasdfe.com\",\"goodsDetails\":[{\"goodsId\":\"D002\",\"goodsName\":\"韩版修身牛仔裤男\",\"quantity\":\"2\",\"price\":\"500\",\"goodsCurrency\":\"IDR\",\"showUrl\":\"http://xxxx.light.png\"}],\"shippingInfo\":{\"firstName\":\"zhang\",\"middleName\":\"shang\",\"lastName\":\"feng\",\"phoneNo\":\"13009090980\",\"email\":\"bacde@ushareit.com\",\"address1\":\"二仙桥\",\"address2\":\"成华大道\",\"city\":\"成都市\",\"region\":\"武侯区\",\"state\":\"州\",\"country\":\"ID\",\"zipCode\":\"000000\"},\"billingInfo\":{\"firstName\":\"账单各\",\"middleName\":\"账单中间名\",\"lastName\":\"账单姓\",\"email\":\"abse@ushareit.com\",\"phone\":\"182927192799\",\"address1\":\"账单地址1\",\"address2\":\"账单地址2\",\"city\":\"账单地址所在城市\",\"region\":\"账单地址所在区域\",\"state\":\"账单地址所在州\",\"country\":\"地址\",\"zipCode\":\"710603\"}}";
        JSONObject jsonObject = JSON.parseObject(json);

        // client构造完成后，可以进行反复使用，不需要重复获取实例
        String result = client.send("orderAndPay", jsonObject);
        System.out.println(result);
    }

    @Test(testName = "test use default merchant config and use common api mode")
    public void testUseDefaultMerchantConfig2() throws Exception {
        TradeOrderRequest request = new TradeOrderRequest();
        request.setOutTradeNo("out41254125412");
        request.setSubject("this is subject");
        request.setTotalAmount(new BigDecimal(10000));
        request.setCurrency("IDR");
        request.setCountry("ID");
        request.setUserId("test userId");
        // set the other information
        // request.setLanguage();
        // ......

        GatewayResult<TradePayOrderResponse> resp = request.send();
        System.out.println(resp);

    }

    @Test(testName = "test use default merchant config and use common api mode")
    public void testUseDefaultMerchantConfig3() throws Exception {
        String jsonContent = "{\"outTradeNo\":\"out41254125412\",\"subject\":\"this is subject\",\"totalAmount\":\"10000\",\"currency\":\"IDR\",\"country\":\"ID\",\"userId\":\"userId\",\"language\":\"\",\"reference\":\"\",\"frontCallbackURL\":\"http://www.qq2ddsdfsadfsdfsd.com\",\"notifyUrl\":\"http://www.noticddddasdfasdfe.com\",\"goodsDetails\":[{\"goodsId\":\"D002\",\"goodsName\":\"韩版修身牛仔裤男\",\"quantity\":\"2\",\"price\":\"500\",\"goodsCurrency\":\"IDR\",\"showUrl\":\"http://xxxx.light.png\"}],\"shippingInfo\":{\"firstName\":\"zhang\",\"middleName\":\"shang\",\"lastName\":\"feng\",\"phoneNo\":\"13009090980\",\"email\":\"bacde@ushareit.com\",\"address1\":\"二仙桥\",\"address2\":\"成华大道\",\"city\":\"成都市\",\"region\":\"武侯区\",\"state\":\"州\",\"country\":\"ID\",\"zipCode\":\"000000\"},\"billingInfo\":{\"firstName\":\"账单各\",\"middleName\":\"账单中间名\",\"lastName\":\"账单姓\",\"email\":\"abse@ushareit.com\",\"phone\":\"182927192799\",\"address1\":\"账单地址1\",\"address2\":\"账单地址2\",\"city\":\"账单地址所在城市\",\"region\":\"账单地址所在区域\",\"state\":\"账单地址所在州\",\"country\":\"地址\",\"zipCode\":\"710603\"}}";
        TradeOrderRequest request = JSON.parseObject(jsonContent, TradeOrderRequest.class);
        GatewayResult<TradePayOrderResponse> resp = request.send();
        System.out.println(resp);
    }

    @Test(testName = "test has multi merchant configs")
    public void testUseMultiMerchantConfig() throws Exception {
        String jsonContent = "{\"outTradeNo\":\"out41254125412\",\"subject\":\"this is subject\",\"totalAmount\":\"10000\",\"currency\":\"IDR\",\"country\":\"ID\",\"userId\":\"userId\",\"language\":\"\",\"reference\":\"\",\"frontCallbackURL\":\"http://www.qq2ddsdfsadfsdfsd.com\",\"notifyUrl\":\"http://www.noticddddasdfasdfe.com\",\"goodsDetails\":[{\"goodsId\":\"D002\",\"goodsName\":\"韩版修身牛仔裤男\",\"quantity\":\"2\",\"price\":\"500\",\"goodsCurrency\":\"IDR\",\"showUrl\":\"http://xxxx.light.png\"}],\"shippingInfo\":{\"firstName\":\"zhang\",\"middleName\":\"shang\",\"lastName\":\"feng\",\"phoneNo\":\"13009090980\",\"email\":\"bacde@ushareit.com\",\"address1\":\"二仙桥\",\"address2\":\"成华大道\",\"city\":\"成都市\",\"region\":\"武侯区\",\"state\":\"州\",\"country\":\"ID\",\"zipCode\":\"000000\"},\"billingInfo\":{\"firstName\":\"账单各\",\"middleName\":\"账单中间名\",\"lastName\":\"账单姓\",\"email\":\"abse@ushareit.com\",\"phone\":\"182927192799\",\"address1\":\"账单地址1\",\"address2\":\"账单地址2\",\"city\":\"账单地址所在城市\",\"region\":\"账单地址所在区域\",\"state\":\"账单地址所在州\",\"country\":\"地址\",\"zipCode\":\"710603\"}}";
        TradeOrderRequest request = JSON.parseObject(jsonContent, TradeOrderRequest.class);

        Map<String, String> keyPair = RsaUtils.createKeyPair();
        String merchantPrivateKey = keyPair.get(RsaUtils.PRIVATE_KEY_NAME);
        String payermaxPublicKey = "get payermax public key from dashboard";
        String merchantNo = "the other merchant no";
        String merchantAppId = "get appId from dashboard";
        MerchantConfig merchantConfig = MerchantConfig.Builder.builder()
                .merchantPrivateKey(merchantPrivateKey)
                .payermaxPublicKey(payermaxPublicKey)
                .merchantNo(merchantNo)
                .merchantAppId(merchantAppId)
                .build();
        GlobalMerchantConfig.addConfig(merchantConfig);

        GatewayResult<TradePayOrderResponse> resp = request.send(merchantNo);
        System.out.println(resp);
    }
}
