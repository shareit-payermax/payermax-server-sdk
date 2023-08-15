package com.payermax.sdk.req;

import com.payermax.sdk.api.BaseRequest;
import com.payermax.sdk.resp.PayoutResponse;

import java.io.Serializable;

/**
 * @author raoxw
 **/
public class PayoutRequest extends BaseRequest<PayoutResponse> implements Serializable {
    private static final long serialVersionUID = 6694416012345909439L;

    private String outTradeNo;

    /**
     * 商户版本 1.0为走迁移商户流程商户 2.0为走新商户流程商户 不填默认新商户
     * <p>
     * sample:  M36977092608
     */
    private String merchantVersion;

    /**
     * 商户批次号 MMC调用时需要
     */
    private String merchantBatchNo;

    /**
     * 商户批次申请计费时间
     */
    private Long merchantBatchApplyTime;

    /**
     * 扣款帐号（币种）
     */
    private String sourceAccount;

    /**
     * 到账币种
     */
    private String destinationCurrency;


    /**
     * 国家代码
     * <p>
     * sample:  ID
     */
    private String country;


    /**
     * 交易金额信息
     */
    private Trade trade;

    /**
     * 收款方信息
     */
    private PayeeInfo payeeInfo;

    /**
     * 付款方信息
     */
    private PayerInfo payerInfo;

    /**
     * 取款码有效天数，当前仅在FawryCash中有效，支持传入1~15整数（1=24Hours），其他值或不传则默认为7
     */
    private String expiryDays;

    /**
     * 付款方信息
     */
    private String remark;
    /**
     * 透传数据，在付款异步回调通知中原样返回，该字段主要用于商户携带订单的自定义数据
     */
    private String reference;
    /**
     * 商户接收付款结果的后台回调地址，以http/https开头
     */
    private String notifyUrl;
    /**
     * 收款方通知邮箱
     */
    private String notifyEmail;
    /**
     * 收款方通知电话
     */
    private String notifyPhone;

    /**
     * 出款的目的
     */
    private String purpose;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getMerchantVersion() {
        return merchantVersion;
    }

    public void setMerchantVersion(String merchantVersion) {
        this.merchantVersion = merchantVersion;
    }

    public String getMerchantBatchNo() {
        return merchantBatchNo;
    }

    public void setMerchantBatchNo(String merchantBatchNo) {
        this.merchantBatchNo = merchantBatchNo;
    }

    public Long getMerchantBatchApplyTime() {
        return merchantBatchApplyTime;
    }

    public void setMerchantBatchApplyTime(Long merchantBatchApplyTime) {
        this.merchantBatchApplyTime = merchantBatchApplyTime;
    }

    public String getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public String getDestinationCurrency() {
        return destinationCurrency;
    }

    public void setDestinationCurrency(String destinationCurrency) {
        this.destinationCurrency = destinationCurrency;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Trade getTrade() {
        return trade;
    }

    public void setTrade(Trade trade) {
        this.trade = trade;
    }

    public PayeeInfo getPayeeInfo() {
        return payeeInfo;
    }

    public void setPayeeInfo(PayeeInfo payeeInfo) {
        this.payeeInfo = payeeInfo;
    }

    public PayerInfo getPayerInfo() {
        return payerInfo;
    }

    public void setPayerInfo(PayerInfo payerInfo) {
        this.payerInfo = payerInfo;
    }

    public String getExpiryDays() {
        return expiryDays;
    }

    public void setExpiryDays(String expiryDays) {
        this.expiryDays = expiryDays;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getNotifyEmail() {
        return notifyEmail;
    }

    public void setNotifyEmail(String notifyEmail) {
        this.notifyEmail = notifyEmail;
    }

    public String getNotifyPhone() {
        return notifyPhone;
    }

    public void setNotifyPhone(String notifyPhone) {
        this.notifyPhone = notifyPhone;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    protected String getApiName() {
        return "paymentOrderPay";
    }

    public static final class Trade implements Serializable {

        private static final long serialVersionUID = -6481233477607379621L;
        /**
         * 交易金额
         */
        private String amount;
        /**
         * 交易币种
         */

        private String currency;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }
    }

    public static final class PayeeInfo implements Serializable {

        private static final long serialVersionUID = -6498731477607379621L;
        /**
         * 支付方式
         */
        private String paymentMethod;
        /**
         * 目标机构
         */
        private String targetOrg;
        /**
         * 收款方类型（PERSONAL/CORPORATION），默认PERSONAL
         */
        private String payeeType;
        /**
         * 卡信息
         */
        private CardInfo cardInfo;
        /**
         * 账号信息
         */
        private AccountInfo accountInfo;

        /**
         * 银行信息
         */
        private BankInfo bankInfo;

        /**
         * payeename信息
         */
        private Name name;

        /**
         * document
         */
        private Document document;

        /**
         * address
         */
        private Address address;

        private String payeePhone;

        private String birthDate;

        private String email;

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

        public String getPayeeType() {
            return payeeType;
        }

        public void setPayeeType(String payeeType) {
            this.payeeType = payeeType;
        }

        public CardInfo getCardInfo() {
            return cardInfo;
        }

        public void setCardInfo(CardInfo cardInfo) {
            this.cardInfo = cardInfo;
        }

        public AccountInfo getAccountInfo() {
            return accountInfo;
        }

        public void setAccountInfo(AccountInfo accountInfo) {
            this.accountInfo = accountInfo;
        }

        public BankInfo getBankInfo() {
            return bankInfo;
        }

        public void setBankInfo(BankInfo bankInfo) {
            this.bankInfo = bankInfo;
        }

        public Name getName() {
            return name;
        }

        public void setName(Name name) {
            this.name = name;
        }

        public Document getDocument() {
            return document;
        }

        public void setDocument(Document document) {
            this.document = document;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public String getPayeePhone() {
            return payeePhone;
        }

        public void setPayeePhone(String payeePhone) {
            this.payeePhone = payeePhone;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }


    public static final class PayerInfo implements Serializable {

        private static final long serialVersionUID = -6498731477607379621L;


        /**
         * payername信息
         */
        private Name name;

        /**
         * 二级商户信息
         */
        private String subMerchantNo;

        public Name getName() {
            return name;
        }

        public void setName(Name name) {
            this.name = name;
        }

        public String getSubMerchantNo() {
            return subMerchantNo;
        }

        public void setSubMerchantNo(String subMerchantNo) {
            this.subMerchantNo = subMerchantNo;
        }
    }


    public static final class AccountInfo implements Serializable {

        private static final long serialVersionUID = -6494231477607379621L;
        /**
         * 收款方账号，根据付款方式不同填入相应账号
         */
        private String accountNo;
        /**
         * 收款账户类型,在不同国家-支付方式下规范不同
         */
        private String accountType;
        /**
         * 收款方账户验证数字
         */
        private String checkDigit;

        public String getAccountNo() {
            return accountNo;
        }

        public void setAccountNo(String accountNo) {
            this.accountNo = accountNo;
        }

        public String getAccountType() {
            return accountType;
        }

        public void setAccountType(String accountType) {
            this.accountType = accountType;
        }

        public String getCheckDigit() {
            return checkDigit;
        }

        public void setCheckDigit(String checkDigit) {
            this.checkDigit = checkDigit;
        }
    }

    public static final class BankInfo implements Serializable {

        private static final long serialVersionUID = -6456231477607379621L;
        /**
         * 用于识别特定金融机构下的收款方银行代码，在不同国家下填写规范不同，参见【银行编码】
         */

        private String bankCode;
        /**
         * 收款方银行名称
         */
        private String bankName;
        /**
         * 收款人银行网点号/分行号
         */
        private String bankBranch;
        /**
         * 收款方银行所在城市
         */
        private String bankCity;
        /**
         * 收款方银行的代理账号（correspondent account）
         */
        private String corAccountNo;

        public String getBankCode() {
            return bankCode;
        }

        public void setBankCode(String bankCode) {
            this.bankCode = bankCode;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getBankBranch() {
            return bankBranch;
        }

        public void setBankBranch(String bankBranch) {
            this.bankBranch = bankBranch;
        }

        public String getBankCity() {
            return bankCity;
        }

        public void setBankCity(String bankCity) {
            this.bankCity = bankCity;
        }

        public String getCorAccountNo() {
            return corAccountNo;
        }

        public void setCorAccountNo(String corAccountNo) {
            this.corAccountNo = corAccountNo;
        }
    }

    public static final class Name implements Serializable {

        private static final long serialVersionUID = -6118231477607379621L;
        /**
         * 名
         */

        private String firstName;
        /**
         * 中间名，多段中间名时，使用空格进行分隔
         */
        private String middleName;
        /**
         * 姓
         */
        private String lastName;
        /**
         * 全名
         */
        private String fullName;

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

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }
    }

    public static final class Document implements Serializable {

        private static final long serialVersionUID = -6298231477607379621L;
        /**
         * 收款方个人身份证明类型，在不同国家下可选类型不同，参见【身份证明】
         */

        private String documentType;
        /**
         * 收款方个人识别号码，在不同国家下可选类型不同，参见【身份证明】
         */
        private String documentId;
        /**
         * 收款方个人识别号码生效日期，在不同国家下可选类型不同，yyyy-MM-dd格式
         */
        private String documentIssueDate;
        /**
         * 全名
         */
        private String documentExpireDate;

        public String getDocumentType() {
            return documentType;
        }

        public void setDocumentType(String documentType) {
            this.documentType = documentType;
        }

        public String getDocumentId() {
            return documentId;
        }

        public void setDocumentId(String documentId) {
            this.documentId = documentId;
        }

        public String getDocumentIssueDate() {
            return documentIssueDate;
        }

        public void setDocumentIssueDate(String documentIssueDate) {
            this.documentIssueDate = documentIssueDate;
        }

        public String getDocumentExpireDate() {
            return documentExpireDate;
        }

        public void setDocumentExpireDate(String documentExpireDate) {
            this.documentExpireDate = documentExpireDate;
        }
    }

    public static final class Address implements Serializable {

        private static final long serialVersionUID = -6398231477607379621L;
        /**
         * 收款方地址
         */

        private String address;
        /**
         * 收款方城市
         */
        private String city;
        /**
         * 州
         */
        private String state;
        /**
         * 收款方邮编
         */
        private String zipCode;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }
    }


    public static final class CardInfo implements Serializable {

        private static final long serialVersionUID = -6398231477607119621L;
        /**
         * 卡组织
         */

        private String cardOrg;
        /**
         * cardIdentifierNo
         */
        private String cardIdentifierNo;
        /**
         * 持卡人姓名
         */
        private String cardHolderFullName;
        /**
         * 卡有效期-年，只取后两位年份
         */

        private String cardExpirationYear;
        /**
         * 卡有效期-月
         */
        private String cardExpirationMonth;
        /**
         *
         */
        private String cvv;


        public String getCardOrg() {
            return cardOrg;
        }

        public void setCardOrg(String cardOrg) {
            this.cardOrg = cardOrg;
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

        public String getCvv() {
            return cvv;
        }

        public void setCvv(String cvv) {
            this.cvv = cvv;
        }
    }

}
