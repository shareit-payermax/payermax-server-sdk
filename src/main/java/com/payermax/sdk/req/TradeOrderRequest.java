package com.payermax.sdk.req;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @param
 * @author raoxw
 * @date 2021/12/1 20:08
 * @return
 **/
public class TradeOrderRequest implements Serializable{
    /**
     * 商户订单号
     *
     * @mock Test20211124000000039
     */
    private String outTradeNo;

    /**
     * 订单金额
     *
     * @mock 1000
     */
    private BigDecimal totalAmount;

    /**
     * 订单币种
     *
     * @mock IDR
     */
    private String currency;

    /**
     * 订单标题
     *
     * @mock 简约灯具
     */
    private String subject;

    /**
     * 支付方式信息
     */
    private PaymentDetail paymentDetail;

    /**
     * 商户指定的跳转URL，用户完成支付后会被跳转到该地址
     *
     * @mock http://wwww.baidu.com
     */
    private String frontCallbackURL;

    /**
     * 国家代码
     *
     * @mock ID
     */
    private String country;

    /**
     * 商户用户id
     *
     * @mock TestUser001
     */
    String userId;

    /**
     * 【流量切换使用】订单相对超时时间
     *
     * @mock 1800
     */
    private Integer timeoutExpress;

    /**
     * 服务端支付结果通知URL地址
     *
     * @mock http://www.notice.com
     */
    private String notifyUrl;

    /**
     * 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用
     *
     * @mock test
     */
    private String reference;

    /**
     * 语言
     *
     * @mock en
     */
    private String language;

    /**
     * 订单包含的商品列表信息
     */
    private List<GoodsDetailItem> goodsDetails;

    /**
     * 配送信息--【电商场景必输】
     */
    private ShippingInfo shippingInfo;

    /**
     * 商户用户信息
     */
    private OutUserInfo buyerInfo;

    /**
     * 信用卡账单信息--【电商场景必输】
     */
    private BillingInfo billingInfo;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public PaymentDetail getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(PaymentDetail paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    public String getFrontCallbackURL() {
        return frontCallbackURL;
    }

    public void setFrontCallbackURL(String frontCallbackURL) {
        this.frontCallbackURL = frontCallbackURL;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getTimeoutExpress() {
        return timeoutExpress;
    }

    public void setTimeoutExpress(Integer timeoutExpress) {
        this.timeoutExpress = timeoutExpress;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<GoodsDetailItem> getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(List<GoodsDetailItem> goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public OutUserInfo getBuyerInfo() {
        return buyerInfo;
    }

    public void setBuyerInfo(OutUserInfo buyerInfo) {
        this.buyerInfo = buyerInfo;
    }

    public BillingInfo getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(BillingInfo billingInfo) {
        this.billingInfo = billingInfo;
    }

    public static final class PaymentDetail implements Serializable {

        private static final long serialVersionUID = -7937394894543296555L;
        /**
         * 支付方式（跟踪产品，将支付方式改为编码）
         *
         * @mock: P00010
         */
        String paymentMethod;
        /**
         * 目标机构（跟踪产品，将支付方式改为编码）
         *
         * @mock 10000036
         */
        String targetOrg;

        /**
         * 支付账户号信息
         */
        List<PayAccountInfo> payAccountInfo;

        /**
         * 卡信息--【电商场景必输】
         */
        CardInfo cardInfo;

        /**
         * 商户用户信息
         */
        OutUserInfo buyerInfo;

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public String getTargetOrg() {
            return targetOrg;
        }

        public void setTargetOrg(String targetOrg) {
            this.targetOrg = targetOrg;
        }

        public List<PayAccountInfo> getPayAccountInfo() {
            return payAccountInfo;
        }

        public void setPayAccountInfo(List<PayAccountInfo> payAccountInfo) {
            this.payAccountInfo = payAccountInfo;
        }

        public CardInfo getCardInfo() {
            return cardInfo;
        }

        public void setCardInfo(CardInfo cardInfo) {
            this.cardInfo = cardInfo;
        }

        public OutUserInfo getBuyerInfo() {
            return buyerInfo;
        }

        public void setBuyerInfo(OutUserInfo buyerInfo) {
            this.buyerInfo = buyerInfo;
        }
    }

    public static final class PayAccountInfo implements Serializable {

        private static final long serialVersionUID = 7910969920253946128L;
        /**
         * 账户类型（EMAIL,PHONE,ID，CARD）
         *
         * @mock PHONE
         */
        String accountNoType;
        /**
         * 账户号--accountType类型是EMAIL,PHONE,ID
         *
         * @mock 123456789
         */
        String accountNo;
        /**
         * 卡信息
         */
        CardInfo cardInfo;

        public String getAccountNoType() {
            return accountNoType;
        }

        public void setAccountNoType(String accountNoType) {
            this.accountNoType = accountNoType;
        }

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
        }

        public CardInfo getCardInfo() {
            return cardInfo;
        }

        public void setCardInfo(CardInfo cardInfo) {
            this.cardInfo = cardInfo;
        }
    }

    public static final class CardInfo implements Serializable {

        private static final long serialVersionUID = -6498233477607379626L;
        /**
         * 卡号
         */
        String cardIdentifierNo;
        /**
         * 持卡人姓名
         */
        String cardHolderFullName;
        /**
         * 卡有效期-年
         */
        String cardExpirationYear;
        /**
         * 卡有效期-月
         */
        String cardExpirationMonth;
        /**
         * 卡组织
         **/
        String cardOrg;
        /**
         * 卡cvv
         */
        String cvv;

        public String getCardIdentifierNo() {
            return cardIdentifierNo;
        }

        public void setCardIdentifierNo(String cardIdentifierNo) {
            this.cardIdentifierNo = cardIdentifierNo;
        }

        public String getCardHolderFullName() {
            return cardHolderFullName;
        }

        public void setCardHolderFullName(String cardHolderFullName) {
            this.cardHolderFullName = cardHolderFullName;
        }

        public String getCardExpirationYear() {
            return cardExpirationYear;
        }

        public void setCardExpirationYear(String cardExpirationYear) {
            this.cardExpirationYear = cardExpirationYear;
        }

        public String getCardExpirationMonth() {
            return cardExpirationMonth;
        }

        public void setCardExpirationMonth(String cardExpirationMonth) {
            this.cardExpirationMonth = cardExpirationMonth;
        }

        public String getCardOrg() {
            return cardOrg;
        }

        public void setCardOrg(String cardOrg) {
            this.cardOrg = cardOrg;
        }

        public String getCvv() {
            return cvv;
        }

        public void setCvv(String cvv) {
            this.cvv = cvv;
        }
    }

    public static final class GoodsDetailItem implements Serializable {

        private static final long serialVersionUID = 6715003596934540820L;
        /**
         * 商品编号
         *
         * @mock D002
         */
        String goodsId;
        /**
         * 商品名称
         *
         * @mock 韩版修身牛仔裤男
         */
        String goodsName;
        /**
         * 商品数量
         *
         * @mock 2
         */
        String quantity;
        /**
         * 商品单价,单位：元
         *
         * @mock 500
         */
        String price;

        /**
         * 商品报价币种
         *
         * @mock ID
         */
        String goodsCurrency;

        /**
         * 商品展示地址
         *
         * @mock http://xxxx.light.png
         */
        String showUrl;

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getGoodsCurrency() {
            return goodsCurrency;
        }

        public void setGoodsCurrency(String goodsCurrency) {
            this.goodsCurrency = goodsCurrency;
        }

        public String getShowUrl() {
            return showUrl;
        }

        public void setShowUrl(String showUrl) {
            this.showUrl = showUrl;
        }
    }

    public static final class ShippingInfo implements Serializable {

        private static final long serialVersionUID = 2163136516506077767L;

        /**
         * 配送email
         *
         * @mock abc@ushareit.com
         */
        String email;
        /**
         * 配送人first姓名
         *
         * @mock 张
         */
        String firstName;
        /**
         * 配送人middle姓名
         *
         * @mock 三
         */
        String middleName;
        /**
         * 配送人last姓名
         *
         * @mock 丰
         */
        String lastName;
        /**
         * 配送地址1
         *
         * @mock 二仙桥
         */
        String address1;
        /**
         * 配送地址2
         *
         * @mock 成华大道
         */
        String address2;
        /**
         * 配送地址所在城市
         *
         * @mock 成都市
         */
        String city;
        /**
         * 配送地址所在区域
         *
         * @mock 武侯区
         */
        String region;
        /**
         * 配送地址所在州
         */
        String state;
        /**
         * 配送所在国家
         *
         * @mock 中国
         */
        String country;
        /**
         * 配送地邮编
         *
         * @mock 000000
         */
        String zipCode;
        /**
         * 配送人手机
         *
         * @mock 13009090980
         */
        String phoneNo;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }
    }

    public static final class OutUserInfo implements Serializable {

        private static final long serialVersionUID = 8687545027478296178L;
        /**
         * 名
         *
         * @mock 凡
         */
        String firstName;
        /**
         * 中间名
         *
         * @mock 亦
         */
        String middleName;
        /**
         * 姓
         *
         * @mock 吴
         */
        String lastName;
        /**
         * 用户邮箱
         *
         * @mock test@123.com
         */
        String email;
        /**
         * 用户手机号
         *
         * @mock 13119090980
         */
        String phoneNo;
        /**
         * 用户证件类型（IDCARD PASSPORT DNI T.C.KimlikNo.）
         *
         * @mock IDCARD
         */
        String idType;
        /**
         * 用户证件号
         *
         * @mock 158485664684848677456
         */
        String taxNo;
        /**
         * 用户所在区域
         *
         * @mock 朝阳区
         */
        String region;
        /**
         * 用户所在城市
         *
         * @mock 北京市
         */
        String city;
        /**
         * 用户详细地址
         *
         * @mock 北京市朝阳区看守所
         */
        String address;
        /**
         * 用户客户端ip
         */
        String clientIp;
        /**
         * 浏览器ua信息
         */
        String userAgent;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getIdType() {
            return idType;
        }

        public void setIdType(String idType) {
            this.idType = idType;
        }

        public String getTaxNo() {
            return taxNo;
        }

        public void setTaxNo(String taxNo) {
            this.taxNo = taxNo;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getClientIp() {
            return clientIp;
        }

        public void setClientIp(String clientIp) {
            this.clientIp = clientIp;
        }

        public String getUserAgent() {
            return userAgent;
        }

        public void setUserAgent(String userAgent) {
            this.userAgent = userAgent;
        }
    }

    public static final class BillingInfo implements Serializable {

        private static final long serialVersionUID = -1047316389038662697L;

        /**
         * 账单各
         */
        String firstName;
        /**
         * 账单中间名
         */
        String middleName;
        /**
         * 账单姓
         */
        String lastName;
        /**
         * 账单email
         */
        String email;
        /**
         * 账单手机号
         */
        String phoneNo;
        /**
         * 账单地址1
         */
        String address1;
        /**
         * 账单地址2
         */
        String address2;
        /**
         * 账单地址所在城市
         */
        String city;
        /**
         * 账单地址所在区域
         */
        String region;
        /**
         * 账单地址所在州
         */
        String state;
        /**
         * 账单地址所在国家
         */
        String country;
        /**
         * 账单地址邮编
         */
        String zipCode;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }
    }
}
