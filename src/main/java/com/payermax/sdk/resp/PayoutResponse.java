package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * @author ctl
 * @description
 **/

public class PayoutResponse implements Serializable {
    private static final long serialVersionUID = 2649437349115110791L;


    /**
     * 商户订单号
     *
     * @mock Test202111092100001
     */
    private String outTradeNo;
    /**
     * 交易token
     *
     * @mock 20201112400101244339
     */
    private String tradeNo;

    /**
     * 交易状态
     *
     * @mock SUCCESS
     */
    private String status;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
