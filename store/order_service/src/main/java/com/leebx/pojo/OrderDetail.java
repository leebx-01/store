package com.leebx.pojo;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    private Long id;//订单详情id
    private Long orderId;//订单id
    private String skuId;//sku商品id
    private Integer num;//购买数量
    private String title;//商品标题
    private String ownSpec;//商品动态属性键值集
    private Long price;//价格,单位：分
    private String image;//商品图片

    public Long getId() {
        return id;
    }

    public OrderDetail(Long id, Long orderId, String skuId, Integer num, String title, String ownSpec, Long price, String image) {
        this.id = id;
        this.orderId = orderId;
        this.skuId = skuId;
        this.num = num;
        this.title = title;
        this.ownSpec = ownSpec;
        this.price = price;
        this.image = image;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwnSpec() {
        return ownSpec;
    }

    public void setOwnSpec(String ownSpec) {
        this.ownSpec = ownSpec;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
