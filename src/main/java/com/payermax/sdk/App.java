package com.payermax.sdk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.payermax.sdk.api.PayApi;
import com.payermax.sdk.client.PayermaxClient;
import com.payermax.sdk.config.MerchantConfig;
import com.payermax.sdk.domain.GatewayResult;
import com.payermax.sdk.req.TradeOrderRequest;
import com.payermax.sdk.resp.TradePayOrderResponse;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        String url = MerchantConfig.SAND_BOX_URL;
        String merchantPrivateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKExZ32j0CdzwZtJixKDHmwk6P6Xe2s1JyEVJ5VYBf7MDs/tD611KH6LnxCf6M3DbIJs2gPx6/nk70H94d7ZR+vDC0Ru7oC3YArGXxjcwkjivGJ4pkjj63+q5MorIm+5/s323y3HE8J81MTNsUK1G6B1mPsn5n6MziKj9Bc9SS4hAgMBAAECgYBb246RX5/IS8QB3VgedZAJqsMICoUvo/unc6m6Bo5sFBdA0GRFweUQsDo2PBpr37jfXm6jHuMN5jOeVLK5zvKXdGoRpkoxdUtYtR51KCWkzUkz6LRH+ooLuC7k3iUVVnZZ7zNLgQORRlFwMCA2gHa3mvbdzW3tP92rgdM3oCDHAQJBAN7jQ0C5eyfymjIRJ/AEJPw+oH7Vr+evFuJRahjViE3es7INpFZDmwBLwuHHLMATwNuQ5kniH02IzXA0h+hborECQQC5I81iab/RYJSY45pxTIusUqJGF4ZQg3ZxdnnNsxbtl0uMw17RArLF/czV3DwwCnGGepp9TNBkIrbglTj7R75xAkEA0jgfEkjes4rJjDdKJ8KA77hRv87jne0x9Ds9ija73FYTvffH6+TPqLPMFw64UmFPIMfFrCGtzH8e5JlnJexnwQJAA3UvuM7QzlBHdjOKBuOvGCDS9wwpbgeGhsf3rmfR3c4dkxtzAeRTAm+jC7t5RExtol1X1U9B9RzQ3ZDr54WHgQJAeicYgZYMymBbxcmlz6+GhvnNQWNh0vJcsKb3YQ/uolMv3ymiglj89QiInTJmvXsU8oEdSv7XE+Pq7Od+MrJ/NA==";
        String payermaxPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQChMWd9o9Anc8GbSYsSgx5sJOj+l3trNSchFSeVWAX+zA7P7Q+tdSh+i58Qn+jNw2yCbNoD8ev55O9B/eHe2UfrwwtEbu6At2AKxl8Y3MJI4rxieKZI4+t/quTKKyJvuf7N9t8txxPCfNTEzbFCtRugdZj7J+Z+jM4io/QXPUkuIQIDAQAB";
        String merchantNo = "020213827186970";
        String merchantAppId = "95e1f610d6c94bc3b018282fc9acaba8";

        //1.通用api调用 不论服务端是何接口都可以进行调用
        String json = "{\"country\":\"ID\",\"goodsDetails\":[{\"quantity\":\"2\",\"goodsId\":\"D002\",\"price\":\"500\",\"showUrl\":\"[http://xxxx.light.png](http://xxxx.light.png)\",\"goodsCurrency\":\"IDR\",\"goodsName\":\"韩版修身牛仔裤男\"}],\"frontCallbackURL\":\"[http://www.qq2ddsdfsadfsdfsd.com](http://www.qq2ddsdfsadfsdfsd.com)\",\"subject\":\"this is subject\",\"shippingInfo\":{\"firstName\":\"zhang\",\"lastName\":\"feng\",\"country\":\"ID\",\"zipCode\":\"000000\",\"address2\":\"成华大道\",\"city\":\"成都市\",\"address1\":\"二仙桥\",\"middleName\":\"shang\",\"state\":\"州\",\"region\":\"武侯区\",\"phoneNo\":\"13009090980\",\"email\":\"bacde@ushareit.com\"},\"language\":\"\",\"userId\":\"userId001\",\"reference\":\"\",\"totalAmount\":\"1000\",\"billingInfo\":{\"firstName\":\"billingInfo-firstName\",\"lastName\":\"feng\",\"country\":\"ID\",\"zipCode\":\"000000\",\"address2\":\"成华大道\",\"city\":\"成都市\",\"address1\":\"二仙桥\",\"middleName\":\"shang\",\"state\":\"州\",\"region\":\"武侯区\",\"phoneNo\":\"13009090980\",\"email\":\"bacde@ushareit.com\"},\"paymentDetail\":{\"targetOrg\":\"DANA\",\"paymentMethod\":\"WALLET\"},\"outTradeNo\":\"RenshTest1642579353180\",\"notifyUrl\":\"http://www.noticddddasdfasdfe.com](http://www.noticddddasdfasdfe.com)\",\"currency\":\"IDR\"}";
        JSONObject jsonObject = JSON.parseObject(json);
        MerchantConfig config = MerchantConfig.Builder.builder()
                .payerMaxBaseUrl("https://pay-test.shareitpay.in/aggregate-pay/api/gateway")
                .merchantPrivateKey(merchantPrivateKey)
                .payermaxPublicKey(payermaxPublicKey)
                .merchantNo(merchantNo)
                .merchantAppId(merchantAppId)
                .build();
        PayermaxClient client = PayermaxClient.defaultInstance(config);
        //client构造完成后，可以进行反复使用，不需要重复获取实例
        String result = client.send("orderAndPay", jsonObject);
        System.out.println(result);




        //2.封装api调用 对业务数据请求进行包装，方便调用
        //此实例构造完成后，可以进行反复使用，不需要重复获取实例
        PayApi payApi = PayApi.getInstance("https://pay-test.shareitpay.in/aggregate-pay/api/gateway",
                merchantPrivateKey,
                payermaxPublicKey,
                merchantNo,
                merchantAppId);

        String sss = "{\"outTradeNo\":\"RenshTest1642579353180\",\"subject\":\"this is subject\",\"totalAmount\":\"1000\",\"currency\":\"IDR\",\"country\":\"ID\",\"userId\":\"userId001\",\"language\":\"\",\"reference\":\"\",\"frontCallbackURL\":\"[http://www.qq2ddsdfsadfsdfsd.com](http://www.qq2ddsdfsadfsdfsd.com)\",\"notifyUrl\":\"http://www.noticddddasdfasdfe.com](http://www.noticddddasdfasdfe.com)\",\"paymentDetail\":{\"paymentMethod\":\"WALLET\",\"targetOrg\":\"DANA\"},\"goodsDetails\":[{\"goodsId\":\"D002\",\"goodsName\":\"韩版修身牛仔裤男\",\"quantity\":\"2\",\"price\":\"500\",\"goodsCurrency\":\"IDR\",\"showUrl\":\"[http://xxxx.light.png](http://xxxx.light.png)\"}],\"shippingInfo\":{\"firstName\":\"zhang\",\"middleName\":\"shang\",\"lastName\":\"feng\",\"phoneNo\":\"13009090980\",\"email\":\"bacde@ushareit.com\",\"address1\":\"二仙桥\",\"address2\":\"成华大道\",\"city\":\"成都市\",\"region\":\"武侯区\",\"state\":\"州\",\"country\":\"ID\",\"zipCode\":\"000000\"},\"billingInfo\":{\"firstName\":\"billingInfo-firstName\",\"middleName\":\"shang\",\"lastName\":\"feng\",\"phoneNo\":\"13009090980\",\"email\":\"bacde@ushareit.com\",\"address1\":\"二仙桥\",\"address2\":\"成华大道\",\"city\":\"成都市\",\"region\":\"武侯区\",\"state\":\"州\",\"country\":\"ID\",\"zipCode\":\"000000\"}}";
        TradeOrderRequest request = JSON.parseObject(sss, TradeOrderRequest.class);
        GatewayResult<TradePayOrderResponse> resp = payApi.orderAndPay(request);
        System.out.println(resp);


        //多商户场景可以在调用的时候传递MerchantConfig
        MerchantConfig newMerchantConfig = MerchantConfig.Builder.builder()
                .payerMaxBaseUrl("https://pay-test.shareitpay.in/aggregate-pay/api/gateway")
                .merchantPrivateKey("商户私钥")
                .payermaxPublicKey(payermaxPublicKey)
                .merchantNo("商户号")
                .merchantAppId("商户appId")
                .build();
        //使用新商户信息进行调用
        payApi.orderAndPay(request, newMerchantConfig);


        //还是使用第一次初始化用的商户信息
        payApi.orderAndPay(request);
    }
}
