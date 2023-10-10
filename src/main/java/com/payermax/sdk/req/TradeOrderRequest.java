package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.TradePayOrderResponse;

import java.io.Serializable;
import java.util.List;

public class TradeOrderRequest extends BaseRequest<TradePayOrderResponse> implements Serializable {
    /**
     * 优先交互模式
     * Hosted_Checkout //  Direct_Payment
     */
    private String integrate;
    /**
     * 分账标识，Y：分账，N：不分账
     * 默认不分账,Y大写
     */
    private String separateIndicate;
    /**
     * 分账参与方列表，最大支持10个参与方
     * 校验在代码中进行，会有不同错误码逻辑
     */
    private List<SeparateAccountInfo> separateAccountInfo;
    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 订单金额
     * 单位：元
     */
    private String totalAmount;

    /**
     * 订单币种，例如 ：IDR
     */
    private String currency;

    /**
     * 订单标题
     */
    private String subject;

    /**
     * 支付方式信息
     */
    private PaymentDetail paymentDetail;

    /**
     * 商户指定的跳转URL，用户完成支付后会被跳转到该地址
     */
    @Deprecated
    private String frontCallbackURL;
    private String frontCallbackUrl;

    /**
     * 国家代码
     */
    private String country;

    /**
     * 商户用户id
     */
    private String userId;

    private String referralCode;

    /**
     * 指定关单时间
     */
    private String expireTime;

    /**
     * 风控业务数据
     */
    private Object riskParams;

    /**
     * 请求终端类型
     */
    private String terminalType;
    /**
     * 操作系统类型. IOS；ANDROID
     */
    private String osType;
    /**
     * 服务端支付结果通知URL地址
     */
    private String notifyUrl;

    /**
     * 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用
     */
    private String reference;

    /**
     * 语言
     */
    private String language;

    /**
     * 订单包含的商品列表信息
     */
    private List<GoodsDetailItem> goodsDetails;

    /**
     * 配送信息--【电商场景必填】
     */
    private ShippingInfo shippingInfo;

    /**
     * 商户用户信息
     */
    private OutUserInfo buyerInfo;

    /**
     * 信用卡账单信息--【电商场景必填】
     */
    private BillingInfo billingInfo;

    /**
     * 二级商户信息
     * 平台类商户需要上送子商户信息
     * 非必输
     */
    private SubMerchant subMerchant;


    public static class SubMerchant implements Serializable {

        private static final long serialVersionUID = 6805974273464129119L;
        /**
         * 二级商户号
         */
        private String subMerchantNo;

        /**
         * 二级商户名
         */
        private String subMerchantName;

        public String getSubMerchantNo() {
            return subMerchantNo;
        }

        public void setSubMerchantNo(String subMerchantNo) {
            this.subMerchantNo = subMerchantNo;
        }

        public String getSubMerchantName() {
            return subMerchantName;
        }

        public void setSubMerchantName(String subMerchantName) {
            this.subMerchantName = subMerchantName;
        }
    }

    @Override
    protected String getApiName() {
        return "orderAndPay";
    }

    public String getFrontCallbackUrl() {
        return frontCallbackUrl;
    }

    public void setFrontCallbackUrl(String frontCallbackUrl) {
        this.frontCallbackUrl = frontCallbackUrl;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
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
        return this.frontCallbackUrl;
    }

    public void setFrontCallbackURL(String frontCallbackURL) {
        this.frontCallbackUrl = frontCallbackURL;
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

    public String getIntegrate() {
        return integrate;
    }

    public void setIntegrate(String integrate) {
        this.integrate = integrate;
    }

    public String getSeparateIndicate() {
        return separateIndicate;
    }

    public void setSeparateIndicate(String separateIndicate) {
        this.separateIndicate = separateIndicate;
    }

    public List<SeparateAccountInfo> getSeparateAccountInfo() {
        return separateAccountInfo;
    }

    public void setSeparateAccountInfo(List<SeparateAccountInfo> separateAccountInfo) {
        this.separateAccountInfo = separateAccountInfo;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public Object getRiskParams() {
        return riskParams;
    }

    public void setRiskParams(Object riskParams) {
        this.riskParams = riskParams;
    }

    public String getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public SubMerchant getSubMerchant() {
        return subMerchant;
    }

    public void setSubMerchant(SubMerchant subMerchant) {
        this.subMerchant = subMerchant;
    }

    public static final class PaymentDetail implements Serializable {

        private static final long serialVersionUID = -7937394894543296555L;

        /**
         * 绑卡支付token
         */
        String paymentTokenID;
        /**
         * 支付方式（跟踪产品，将支付方式改为编码）
         */
        @Deprecated
        private String paymentMethod;
        /**
         * 支付方式 新老版本统一字段，替换paymentMethod字段
         */
        private String paymentMethodType;
        /**
         * 目标机构（跟踪产品，将支付方式改为编码）
         */
        private String targetOrg;

        /**
         * 支付账户号信息
         */
        private List<PayAccountInfo> payAccountInfo;

        /**
         * 卡信息--【电商场景必填】
         */
        private CardInfo cardInfo;
        /**
         * 商户自主3DS信息
         */
        private Info3DSecure info3DSecure;
        /**
         * 商户用户信息
         */
        private OutUserInfo buyerInfo;

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

        public String getPaymentTokenID() {
            return paymentTokenID;
        }

        public void setPaymentTokenID(String paymentTokenID) {
            this.paymentTokenID = paymentTokenID;
        }

        public String getPaymentMethodType() {
            return paymentMethodType;
        }

        public void setPaymentMethodType(String paymentMethodType) {
            this.paymentMethodType = paymentMethodType;
        }

        public Info3DSecure getInfo3DSecure() {
            return info3DSecure;
        }

        public void setInfo3DSecure(Info3DSecure info3DSecure) {
            this.info3DSecure = info3DSecure;
        }
    }

    public static final class PayAccountInfo implements Serializable {

        private static final long serialVersionUID = 7910969920253946128L;
        /**
         * 账户类型（EMAIL,PHONE,ID，CARD）
         */
        private String accountNoType;
        /**
         * 账户号--accountType类型是EMAIL,PHONE,ID
         */
        private String accountNo;
        /**
         * 卡信息
         */
        private CardInfo cardInfo;

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
        private String cardIdentifierNo;
        /**
         * 持卡人姓名
         */
        private String cardHolderFullName;
        /**
         * 卡有效期-年
         */
        private String cardExpirationYear;
        /**
         * 卡有效期-月
         */
        private String cardExpirationMonth;
        /**
         * 卡组织
         **/
        private String cardOrg;

        private String cardOrgType;
        /**
         * 卡cvv
         */
        private String cvv;
        /**
         * 动态3ds
         * do3DS：发起3ds支付，不区分大小写
         * no3DS：发起非3ds支付，不区分大小写
         * 商户需要联系PayerMax的商务开通动态3ds，
         * 开通后则根据商户传入的dynamic3DS字段判断该笔支付请求是否要发起3ds。
         * 未传或传入其他值，由PayerMax判断是否发起3ds
         */
        private String dynamic3DS;

        public String getCardOrgType() {
            return cardOrgType;
        }

        public void setCardOrgType(String cardOrgType) {
            this.cardOrgType = cardOrgType;
        }

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

        public String getDynamic3DS() {
            return dynamic3DS;
        }

        public void setDynamic3DS(String dynamic3DS) {
            this.dynamic3DS = dynamic3DS;
        }
    }

    public static final class Info3DSecure implements Serializable {

        private String threeDSVersion;

        private String eci;

        private String cavv;

        private String dsTransactionId;

        private String xid;

        public String getThreeDSVersion() {
            return threeDSVersion;
        }

        public void setThreeDSVersion(String threeDSVersion) {
            this.threeDSVersion = threeDSVersion;
        }

        public String getEci() {
            return eci;
        }

        public void setEci(String eci) {
            this.eci = eci;
        }

        public String getCavv() {
            return cavv;
        }

        public void setCavv(String cavv) {
            this.cavv = cavv;
        }

        public String getDsTransactionId() {
            return dsTransactionId;
        }

        public void setDsTransactionId(String dsTransactionId) {
            this.dsTransactionId = dsTransactionId;
        }

        public String getXid() {
            return xid;
        }

        public void setXid(String xid) {
            this.xid = xid;
        }
    }

    public static final class GoodsDetailItem implements Serializable {

        private static final long serialVersionUID = 6715003596934540820L;
        /**
         * 商品编号
         */
        private String goodsId;
        /**
         * 商品名称
         */
        private String goodsName;
        /**
         * 商品数量
         */
        private String quantity;
        /**
         * 商品单价,单位：元
         */
        private String price;

        /**
         * 商品报价币种
         */
        private String goodsCurrency;

        /**
         * 商品展示地址
         */
        private String showUrl;

        private String goodsCategory;

        public String getGoodsCategory() {
            return goodsCategory;
        }

        public void setGoodsCategory(String goodsCategory) {
            this.goodsCategory = goodsCategory;
        }

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
         */
        private String email;
        /**
         * 配送人first姓名
         */
        private String firstName;
        /**
         * 配送人middle姓名
         */
        private String middleName;
        /**
         * 配送人last姓名
         */
        private String lastName;
        /**
         * 配送地址1
         */
        private String address1;
        /**
         * 配送地址2
         */
        private String address2;
        /**
         * 配送地址所在城市
         */
        private String city;
        /**
         * 配送地址所在区域
         */
        private String region;
        /**
         * 配送地址所在州
         */
        private String state;
        /**
         * 配送所在国家
         */
        private String country;
        /**
         * 配送地邮编
         */
        private String zipCode;
        /**
         * 配送人手机
         */
        private String phoneNo;

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
         */
        private String firstName;
        /**
         * 中间名
         */
        private String middleName;
        /**
         * 姓
         */
        private String lastName;
        /**
         * 用户邮箱
         */
        private String email;
        /**
         * 用户手机号
         */
        private String phoneNo;
        /**
         * 用户证件类型（IDCARD PASSPORT DNI T.C.KimlikNo.）
         */
        private String idType;
        /**
         * 用户证件号
         */
        private String idNo;
        /**
         * 税类型
         */
        private String taxType;
        /**
         * 用户证件号
         */
        private String taxNo;
        /**
         * 用户所在区域
         */
        private String region;
        /**
         * 用户所在城市
         */
        private String city;
        /**
         * 用户详细地址
         */
        private String address;
        /**
         * 邮编
         */
        private String zipCode;
        /**
         * 用户客户端ip
         */
        private String clientIp;
        /**
         * 浏览器ua信息
         */
        private String userAgent;

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

        public String getIdNo() {
            return idNo;
        }

        public void setIdNo(String idNo) {
            this.idNo = idNo;
        }

        public String getTaxType() {
            return taxType;
        }

        public void setTaxType(String taxType) {
            this.taxType = taxType;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }
    }

    public static final class BillingInfo implements Serializable {

        private static final long serialVersionUID = -1047316389038662697L;

        /**
         * 账单各
         */
        private String firstName;
        /**
         * 账单中间名
         */
        private String middleName;
        /**
         * 账单姓
         */
        private String lastName;
        /**
         * 账单email
         */
        private String email;
        /**
         * 账单手机号
         */
        private String phoneNo;
        /**
         * 账单地址1
         */
        private String address1;
        /**
         * 账单地址2
         */
        private String address2;
        /**
         * 账单地址所在城市
         */
        private String city;
        /**
         * 账单地址所在区域
         */
        private String region;
        /**
         * 账单地址所在州
         */
        private String state;
        /**
         * 账单地址所在国家
         */
        private String country;
        /**
         * 账单地址邮编
         */
        private String zipCode;

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

    public static final class SeparateAccountInfo implements Serializable {
        private static final long serialVersionUID = -7937394894543293512L;

        /**
         * 分账参与方
         */
        private String participantId;
        /**
         * 分账描述
         */
        private String separateAccountDesc;

        public String getParticipantId() {
            return participantId;
        }

        public void setParticipantId(String participantId) {
            this.participantId = participantId;
        }

        public String getSeparateAccountDesc() {
            return separateAccountDesc;
        }

        public void setSeparateAccountDesc(String separateAccountDesc) {
            this.separateAccountDesc = separateAccountDesc;
        }
    }
}
