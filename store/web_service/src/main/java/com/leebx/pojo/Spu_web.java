package com.leebx.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Spu_web implements Serializable {
    private Long id;
    private String title;
    private String sub_title;
    private Long cid1;
    private Long cid2;
    private Long cid3;
    private Long brand_id;
    private int saleable;
    private int valid;
    private Date create_time;
    private Date last_update;
    private List<Sku_web> skuList;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public Long getCid1() {
        return cid1;
    }

    public void setCid1(Long cid1) {
        this.cid1 = cid1;
    }

    public Long getCid2() {
        return cid2;
    }

    public void setCid2(Long cid2) {
        this.cid2 = cid2;
    }

    public Long getCid3() {
        return cid3;
    }

    public void setCid3(Long cid3) {
        this.cid3 = cid3;
    }

    public Long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }

    public int getSaleable() {
        return saleable;
    }

    public void setSaleable(int saleable) {
        this.saleable = saleable;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public List<Sku_web> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<Sku_web> skuList) {
        this.skuList = skuList;
    }
}
