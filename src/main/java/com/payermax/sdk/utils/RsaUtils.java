package com.payermax.sdk.utils;


import com.payermax.sdk.exceptions.PayermaxException;

import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhu.q
 */
public class RsaUtils {

    public static final String CHAR_SET = "UTF-8";
    public static final String PUBLIC_KEY_NAME = "PublicKey";
    public static final String PRIVATE_KEY_NAME = "PrivateKey";
    /**
     * key生成算法
     */
    private static final String KEY_ALGORITHM = "RSA";
    /**
     * 签名算法
     */
    private static final String SIGN_ALGORITHMS = "SHA256WithRSA";

    /**
     * 获取签名
     *
     * @param body       参数
     * @param privateKey 私钥
     * @param charSet    字符集
     * @return 返回加签结果
     */
    public static String signForRSA(String body, String privateKey, String charSet) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
            KeyFactory keyf = KeyFactory.getInstance(KEY_ALGORITHM);
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);
            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
            signature.initSign(priKey);
            signature.update(body.getBytes(charSet));
            byte[] signed = signature.sign();
            return Base64.getEncoder().encodeToString(signed);
        } catch (Exception e) {
            throw new PayermaxException(e);
        }
    }

    /**
     * 公钥验证签名
     *
     * @param body      参数
     * @param sign      签名
     * @param publicKey 公钥
     * @param charSet   字符集
     * @return 返回验证结果
     */
    public static boolean verify(String body, String sign, String publicKey, String charSet) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            byte[] encodeKey = Base64.getDecoder().decode(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodeKey));
            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
            signature.initVerify(pubKey);
            signature.update(body.getBytes(charSet));
            return signature.verify(Base64.getDecoder().decode(sign));
        } catch (Exception e) {
            throw new PayermaxException(e);
        }
    }

    /**
     * 生成密钥对
     *
     * @return Map
     */
    public static Map<String, String> createKeyPair() {
        //使用RSA算法获得密钥对生成器对象keyPairGenerator
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        //设置密钥长度为2048
        keyPairGenerator.initialize(2048);
        //生成密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //获取公钥
        Key publicKey = keyPair.getPublic();
        //获取私钥
        Key privateKey = keyPair.getPrivate();

        Map<String, String> keyMap = new HashMap<>(2);
        keyMap.put(PRIVATE_KEY_NAME, Base64.getEncoder().encodeToString(privateKey.getEncoded()));
        keyMap.put(PUBLIC_KEY_NAME, Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        return keyMap;
    }

}
