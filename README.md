# PayerMAX Server sdk

```xml
<dependency>
  <groupId>com.payermax</groupId>
  <artifactId>payermax-server-sdk</artifactId>
  <version>1.0.2</version>
</dependency>
```

## Init Config

```java
PayermaxClient client=DefaultPayermaxClient.getInstance();
        client.setEnv(Env.UAT);
// or set the other base url
// client.setBaseUrl("https://the-other-url.payermax.com/aggregate-pay/api/gateway");
```

### If you have only one merchant

```java
        String merchantPrivateKey="get your private key from testGenKeyPair()";
        String payermaxPublicKey="get payermax public key from dashboard";
        String merchantNo="get merchantNo from dashboard";
        String merchantAppId="get appId from dashboard";
        MerchantConfig merchantConfig=MerchantConfig.Builder.builder()
        .merchantPrivateKey(merchantPrivateKey)
        .payermaxPublicKey(payermaxPublicKey)
        .merchantNo(merchantNo)
        .merchantAppId(merchantAppId)
        .build();
        GlobalMerchantConfig.setDefaultConfig(merchantConfig);
```

### If you have multi merchants

```java
Map<String, String> keyPair=RsaUtils.createKeyPair();
        String merchantPrivateKey=keyPair.get(RsaUtils.PRIVATE_KEY_FILE);
        String payermaxPublicKey="get payermax public key from dashboard";
        String merchantNo="the other merchant no";
        String merchantAppId="get appId from dashboard";
        MerchantConfig merchantConfig=MerchantConfig.Builder.builder()
        .merchantPrivateKey(merchantPrivateKey)
        .payermaxPublicKey(payermaxPublicKey)
        .merchantNo(merchantNo)
        .merchantAppId(merchantAppId)
        .build();
        GlobalMerchantConfig.addConfig(merchantConfig);
// MerchantConfig merchantConfig2 = ....
// GlobalMerchantConfig.addConfig(merchantConfig2);
// MerchantConfig merchantConfig3 = ....
// GlobalMerchantConfig.addConfig(merchantConfig3);
```

## Send request

### Use json api

```java

String json="{\"outTradeNo\":\"out1254125412\",\"subject\":\"this is subject\",\"totalAmount\":\"10000\",\"currency\":\"IDR\",\"country\":\"ID\",\"userId\":\"userId\",\"language\":\"\",\"reference\":\"\",\"frontCallbackURL\":\"https://www.qq2ddsdfsadfsdfsd.com\",\"notifyUrl\":\"https://www.noticddddasdfasdfe.com\",\"goodsDetails\":[{\"goodsId\":\"D002\",\"goodsName\":\"????????????????????????\",\"quantity\":\"2\",\"price\":\"500\",\"goodsCurrency\":\"IDR\",\"showUrl\":\"https://xxxx.light.png\"}],\"shippingInfo\":{\"firstName\":\"zhang\",\"middleName\":\"shang\",\"lastName\":\"feng\",\"phoneNo\":\"13009090980\",\"email\":\"bacde@ushareit.com\",\"address1\":\"?????????\",\"address2\":\"????????????\",\"city\":\"?????????\",\"region\":\"?????????\",\"state\":\"???\",\"country\":\"ID\",\"zipCode\":\"000000\"},\"billingInfo\":{\"firstName\":\"?????????\",\"middleName\":\"???????????????\",\"lastName\":\"?????????\",\"email\":\"abse@ushareit.com\",\"phone\":\"182927192799\",\"address1\":\"????????????1\",\"address2\":\"????????????2\",\"city\":\"????????????????????????\",\"region\":\"????????????????????????\",\"state\":\"?????????????????????\",\"country\":\"??????\",\"zipCode\":\"710603\"}}";
        JSONObject jsonObject=JSON.parseObject(json);

// client????????????????????????????????????????????????????????????????????????
// send with default merchant config        
        String result=client.send("orderAndPay",jsonObject);
```

### Use easy request api

```java
TradeOrderRequest request=new TradeOrderRequest();
        request.setOutTradeNo("out41254125412");
        request.setSubject("this is subject");
        request.setTotalAmount(new BigDecimal(10000));
        request.setCurrency("IDR");
        request.setCountry("ID");
        request.setUserId("test userId");
// set the other information
// request.setLanguage();
// ......
// send with default merchant config        
        GatewayResult<TradePayOrderResponse> resp=request.send();
```

### Use specify merchant config

```java
client.send("merchant no");
```

## Verify Notification

```java
String body="";// from http post body
        String sign="";// from http header, header name is 'sign'        
        boolean result=client.verifyNotification(body,sign);
```
