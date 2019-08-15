package com.leebx.pojo;

import java.io.Serializable;
import java.util.Date;

public class OrderStatus implements Serializable {
    private Long orderId;//订单id
    private Integer status;//状态：1、未付款 2、已付款,未发货 3、已发货,未确认 4、交易成功 5、交易关闭 6、已评价
    private Date createTime;//订单创建时间
    private Date paymentTime;//订单创建时间
    private Date consignTime;//发货时间
    private Date endTime;//交易完成时间
    private Date closeTime;//交易关闭时间
    private Date commentTime;//评价时间

    public Long getOrderId() {
        return orderId;
    }

    public OrderStatus(Long orderId, Integer status) {
        this.orderId = orderId;
        this.status = status;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getConsignTime() {
        return consignTime;
    }

    public void setConsignTime(Date consignTime) {
        this.consignTime = consignTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
}
