package com.payermax.sdk.resp;

import java.io.Serializable;

/**
 * @description: 商户交易关单响应体
 * @author: WangTao
 * @create: 2023-08-23 21:31
 **/

public class OrderCloseResponse implements Serializable {
    private static final long serialVersionUID = 2418322898852304113L;
    /**
     * 商户原订单号
     */
    private String outTradeNo;
    /**
     * 关单时间
     */
    private String closedTime;
    /**
     * 订单状态
     */
    private String status;

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getClosedTime() {
        return closedTime;
    }

    public void setClosedTime(String closedTime) {
        this.closedTime = closedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
