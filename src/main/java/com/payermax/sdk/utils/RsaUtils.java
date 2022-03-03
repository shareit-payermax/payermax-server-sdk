package com.payermax.sdk.utils;


import com.payermax.sdk.exceptions.PayermaxException;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import sun.misc.BASE64Encoder;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhu.q
 */
public class RsaUtils {

    public static final String CHAR_SET = "UTF-8";
    /**
     * 默认公钥的持久化文件存放位置
     */
    private static final String PUBLIC_KEY_FILE = "PublicKey";
    /**
     * 默认私钥的持久化文件存放位置
     */
    private static final String PRIVATE_KEY_FILE = "PrivateKey";
    /**
     * key生成算法
     */
    private static final String KEY_ALGORITHM = "RSA";
    /**
     * 签名算法
     */
    private static final String SIGN_ALGORITHMS = "SHA256WithRSA";
    /**
     * 签名标识
     */
    private static final String SIGN = "sign";
    /**
     * 签名标识
     */
    private static final String SIGN_TYPE = "signType";

    /**
     * 获取签名
     *
     * @param body    参数
     * @param privateKey 私钥
     * @param charSet    字符集
     * @return 返回加签结果
     */
    public static String signForRSA(String body, String privateKey, String charSet) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
            KeyFactory keyf = KeyFactory.getInstance(KEY_ALGORITHM);
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);
            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
            signature.initSign(priKey);
            signature.update(body.getBytes(charSet));
            byte[] signed = signature.sign();
            return Base64.encode(signed);
        } catch (Exception e) {
            throw new PayermaxException(e);
        }
    }

    /**
     * 公钥验证签名
     *
     * @param body   参数
     * @param sign      签名
     * @param publicKey 公钥
     * @param charSet   字符集
     * @return 返回验证结果
     */
    public static boolean verify(String body, String sign, String publicKey, String charSet) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            byte[] encodeKey = Base64.decode(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodeKey));
            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
            signature.initVerify(pubKey);
            signature.update(body.getBytes(charSet));
            return signature.verify(Base64.decode(sign));
        } catch (Exception e) {
            throw new PayermaxException(e);
        }
    }

    /**
     * 生成密钥对
     * @return
     * @throws Exception
     */
    public static Map<String, String> createKeyPair() throws Exception {
        //使用RSA算法获得密钥对生成器对象keyPairGenerator
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        //设置密钥长度为2048
        keyPairGenerator.initialize(2048);
        //生成密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //获取公钥
        Key publicKey = keyPair.getPublic();
        //获取私钥
        Key privateKey = keyPair.getPrivate();

        Map<String, String> keyMap = new HashMap<>();
        keyMap.put(PRIVATE_KEY_FILE, Base64.encode(privateKey.getEncoded()));
        keyMap.put(PUBLIC_KEY_FILE, Base64.encode(publicKey.getEncoded()));
        return keyMap;
    }

    /**
     * 校验示例 demo
     * 注意事项：
     * 1.商户需提供RSA公钥和私钥，如不提供，将由shareit生成并管理，私钥会提供给商户；
     * 2.加签字符集与demo一致，采用utf-8
     *
     * @param args arg
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //生成公私钥，把公钥给payermax
        Map<String, String> keyMap = createKeyPair();
        String pubKey1 = keyMap.get(PUBLIC_KEY_FILE);
        String priKey1 = keyMap.get(PRIVATE_KEY_FILE);

        System.out.println(pubKey1);
        System.out.println(priKey1);

        String pubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAybRQ39Dmt+Re1pVmNHzC" +
                "dVdMpSYauLB5Ydb1yiDZBObneSrBwcDDHm3Jbn6/Gpzoo3lgX+kiR0PtYszpybjI" +
                "Zo3Xu7rhOE7//VfYvHWHLuxeglaUnsPGc37fVB8FM+HB3AfI+Jpw/HMAFZGHFZZ8" +
                "xcGbgW5n4S0d6ExBu/RDjX0ssZeDRWG/NGmuVukmu79RlX2+gmaIth5R+TI+fVL1" +
                "tqlQ5bYenTt1iCYUQXjfuNaeRQvxxjgXCtwKkhsg+gRKJRTypDsUxOxq0qRmn7fZ" +
                "X8Lw9LJsbiIRG6u4EupSiPeU2rqAELIhLFvR57KTapQ+emS6FTdd651KZK97qYy7" +
                "fQIDAQAB";
        System.out.println(pubKey);
        String priKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDJtFDf0Oa35F7W" +
                "lWY0fMJ1V0ylJhq4sHlh1vXKINkE5ud5KsHBwMMebclufr8anOijeWBf6SJHQ+1i" +
                "zOnJuMhmjde7uuE4Tv/9V9i8dYcu7F6CVpSew8Zzft9UHwUz4cHcB8j4mnD8cwAV" +
                "kYcVlnzFwZuBbmfhLR3oTEG79EONfSyxl4NFYb80aa5W6Sa7v1GVfb6CZoi2HlH5" +
                "Mj59UvW2qVDlth6dO3WIJhRBeN+41p5FC/HGOBcK3AqSGyD6BEolFPKkOxTE7GrS" +
                "pGaft9lfwvD0smxuIhEbq7gS6lKI95TauoAQsiEsW9HnspNqlD56ZLoVN13rnUpk" +
                "r3upjLt9AgMBAAECggEAA53HAWxGZq+if6hoD7LY7a+mASQAwKTxWC65c2lJWswl" +
                "BEge9zFUjjwbq258UKbViPDJKI8OfUabf/T6kBJPDX+niYcdOJw5/LnRefeFd/Lm" +
                "8uFIgtwxt6pjqKdxuW9nwWEmWkayleQd8UUNrfZnwEfrWNO46xGbAqozV4JWn7fB" +
                "qNPQxQbxX9qyUcjus7659fHUfutR9e8hodL1G0CvD/7qtEwvmxeWwE0AuqOz4VMR" +
                "6evOutBl3S/EVrb6IUWg4Bn37B5dLUsp48htxbijrnZrgVEzUi2n8G+LP6wanzHu" +
                "zEHhe9uy8ll56gWxAcXKixNmzNgaHJez243S7M1URQKBgQDsTKRL/SptriRLFrH8" +
                "p29rmCYVvT+EEjDwt4nIhPKnTzcns2M8zMrIfK07Y1Yo3roQfFqXzpEuKmVKKz66" +
                "fPqUkYdx9FQO9YHfk4dVw4ozePcHd47aKGxqEmqqBeMZo/fzriJTOD9EJISZkpgs" +
                "u+A/7WU4HGvADi8AStl0fR79dwKBgQDahU8+8SE50hM9PHTvGzDOh/Rub1nO/QRZ" +
                "28iA0Ww4eAI9aXgox67Nv+yH5arFcYsuW5l2J8YitBkrfXNrcfqk2+ueTH2CEnJY" +
                "7f7g5T0/Qu825Anw9thEwXgHCCh+HN7zRUi1SlsoZ2T/W/FvS9VCjlE8oooL9QBi" +
                "OpYWSck7qwKBgQC6goPrtpeWmqzq168EzOOU+TKWVhmcFP+sADIwoz8j79KI836Q" +
                "rtQgCshw56dJ+wLBoGWhDNpqpevs7tVEPQFL4tIVj9QJOp6X6coYV47tsbzJmASZ" +
                "DO8FiiPGr37g7hr3q6pMJUlKb8h5rsuOA3ys+KO79jLWFFvkzy90Uo3zYQKBgAFQ" +
                "T9unA3YfhzIVDPbrCO4U7ylCzh1qc/4+TgRIPghQ4GKSIcDNAoYGI1vly5MITbfn" +
                "oRKOxqgqwQP76xe4RbN8BvyapR6FEd7q/19GwYmB04JW+KBUO5SePSR9rhCkB8sa" +
                "nYdJfSbPCFJosRjkMdIGnQJqT74mqOvuQjy8ENOlAoGAevpHFp0jL5uQR751Uzc3" +
                "boIJu3SDJm57LUOchsf82bqhUeBpoUZ15BwpbGsnQQdkuiP1he4h4Venpoq9IwCp" +
                "t94KxGWtxRlwjHOYb3muyEU6r1z0amj1TZ73YfIRITcS3ILz6z7PQzWLUWQMJjN3" +
                "GD7kGxnRWaSctc90iP5pcL4=";

        String body = "{\"bizType\":\"payTradeOrder\",\"outTradeNo\":\"order132523452345bbc32453245c\",\"merchantNo\":\"020213827524152\",\"merchantAppId\":\"test_app_002\",\"totalAmount\":\"1000\",\"currency\":\"THB\",\"subject\":\"this is subject\",\"frontCallbackURL\":\"http://www.qq2ddsdfsadfsdfsd.com\",\"buyerInfo\":{\"userId\":\"userId\",\"userAgent\":\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36\",\"clientIp\":\"124.156.108.193\",\"email\":\"basldasdfasdfsdie@ushareit.com\"},\"paymentDetail\":{\"paymentMethod\":\"\",\"targetOrg\":\"\"},\"cardInfo\":{\"cardIdentifierNo\":\"4000010000001000\",\"cardExpirationMonth\":\"12\",\"cardExpirationYear\":\"33\",\"cardHolderFullName\":\"EWREWRW\",\"cvv\":\"234\"},\"country\":\"TH\",\"version\":\"1.0\",\"notifyUrl\":\"http://www.noticddddasdfasdfe.com\",\"goodsDetails\":[],\"shippingInfo\":{},\"billingInfo\":{},\"sign\":\"AcOaQBpRp9LcmdYDXCzyh0y/wLtGQToaLIIA63iemsUSSyocfXIrr/OwTRS1ruXmr0lu/7do45XNToHolK9PA8hSKZrbe1PNo38HnxRU+VauIxoIgAaoHeWGaPjFEut3qDYtG8KTTQjeftvu9B4itM9+tSWbo/QpB3DYZqCr6e0=\"}";
        String sign = signForRSA(body, priKey, CHAR_SET);
        System.out.println("sign is = " + sign);



        //payermax利用接口调用方提供的公钥进行验签，(此处公钥也可以由payermax生成并保存)
        boolean flag = verify(body, sign, pubKey, CHAR_SET);
        System.out.println("verify sign result:" + flag);

    }


}
