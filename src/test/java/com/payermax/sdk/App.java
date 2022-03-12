package com.payermax.sdk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.client.PayermaxClient;
import com.payermax.sdk.config.GlobalMerchantConfig;
import com.payermax.sdk.config.MerchantConfig;
import com.payermax.sdk.domain.GatewayResult;
import com.payermax.sdk.req.TradeOrderRequest;
import com.payermax.sdk.req.TradeQueryRequest;
import com.payermax.sdk.resp.TradePayOrderResponse;
import com.payermax.sdk.resp.TradeQueryResponse;

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
        String json = "{\"outTradeNo\":\"out1254125412\",\"subject\":\"this is subject\",\"totalAmount\":\"10000\",\"currency\":\"IDR\",\"country\":\"ID\",\"userId\":\"userId\",\"language\":\"\",\"reference\":\"\",\"frontCallbackURL\":\"http://www.qq2ddsdfsadfsdfsd.com\",\"notifyUrl\":\"http://www.noticddddasdfasdfe.com\",\"goodsDetails\":[{\"goodsId\":\"D002\",\"goodsName\":\"韩版修身牛仔裤男\",\"quantity\":\"2\",\"price\":\"500\",\"goodsCurrency\":\"IDR\",\"showUrl\":\"http://xxxx.light.png\"}],\"shippingInfo\":{\"firstName\":\"zhang\",\"middleName\":\"shang\",\"lastName\":\"feng\",\"phoneNo\":\"13009090980\",\"email\":\"bacde@ushareit.com\",\"address1\":\"二仙桥\",\"address2\":\"成华大道\",\"city\":\"成都市\",\"region\":\"武侯区\",\"state\":\"州\",\"country\":\"ID\",\"zipCode\":\"000000\"},\"billingInfo\":{\"firstName\":\"账单各\",\"middleName\":\"账单中间名\",\"lastName\":\"账单姓\",\"email\":\"abse@ushareit.com\",\"phone\":\"182927192799\",\"address1\":\"账单地址1\",\"address2\":\"账单地址2\",\"city\":\"账单地址所在城市\",\"region\":\"账单地址所在区域\",\"state\":\"账单地址所在州\",\"country\":\"地址\",\"zipCode\":\"710603\"}}";
        JSONObject jsonObject = JSON.parseObject(json);

        //商户的配置信息都add进去就行了，支持多商户场景,不论使用client还是request形式都需要设置这个数据
        GlobalMerchantConfig.addConfig(MerchantConfig.Builder.builder()
                .payerMaxBaseUrl("https://pay-test.shareitpay.in/aggregate-pay/api/gateway")
                .merchantPrivateKey(merchantPrivateKey)
                .payermaxPublicKey(payermaxPublicKey)
                .merchantNo(merchantNo)
                .merchantAppId(merchantAppId)
                .build());

        PayermaxClient client = PayermaxClient.getInstance();
        //client构造完成后，可以进行反复使用，不需要重复获取实例
        String result = client.send("orderAndPay", jsonObject);
        System.out.println(result);




        //2.封装api调用 对业务数据请求进行包装，方便调用
        String sss = "{\"outTradeNo\":\"out41254125412\",\"subject\":\"this is subject\",\"totalAmount\":\"10000\",\"currency\":\"IDR\",\"country\":\"ID\",\"userId\":\"userId\",\"language\":\"\",\"reference\":\"\",\"frontCallbackURL\":\"http://www.qq2ddsdfsadfsdfsd.com\",\"notifyUrl\":\"http://www.noticddddasdfasdfe.com\",\"goodsDetails\":[{\"goodsId\":\"D002\",\"goodsName\":\"韩版修身牛仔裤男\",\"quantity\":\"2\",\"price\":\"500\",\"goodsCurrency\":\"IDR\",\"showUrl\":\"http://xxxx.light.png\"}],\"shippingInfo\":{\"firstName\":\"zhang\",\"middleName\":\"shang\",\"lastName\":\"feng\",\"phoneNo\":\"13009090980\",\"email\":\"bacde@ushareit.com\",\"address1\":\"二仙桥\",\"address2\":\"成华大道\",\"city\":\"成都市\",\"region\":\"武侯区\",\"state\":\"州\",\"country\":\"ID\",\"zipCode\":\"000000\"},\"billingInfo\":{\"firstName\":\"账单各\",\"middleName\":\"账单中间名\",\"lastName\":\"账单姓\",\"email\":\"abse@ushareit.com\",\"phone\":\"182927192799\",\"address1\":\"账单地址1\",\"address2\":\"账单地址2\",\"city\":\"账单地址所在城市\",\"region\":\"账单地址所在区域\",\"state\":\"账单地址所在州\",\"country\":\"地址\",\"zipCode\":\"710603\"}}";
        TradeOrderRequest request = JSON.parseObject(sss, TradeOrderRequest.class);
        GatewayResult<TradePayOrderResponse> resp = request.send();
        //多商户要传递商户号
//        GatewayResult<TradePayOrderResponse> resp = request.send(merchantNo);
        System.out.println(resp);

        TradeQueryRequest tradeQueryRequest = new TradeQueryRequest();
        tradeQueryRequest.setOutTradeNo("RenshTest1642579353180");
        GatewayResult<TradeQueryResponse> tradeQueryResp = tradeQueryRequest.send();
        System.out.println(JSON.toJSONString(tradeQueryResp));
    }
}
