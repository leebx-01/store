package com.leebx.pojo;

import java.util.Date;

public class Sku {
    private Long id;
    private Long spu_id;
    private String title;
    private String images;
    private Long price;
    private String indexes;
    private String own_spec;
    private int enable;
    private Date create_time;
    private Date last_update_time;
    private Integer num;
    private Long total;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(Long spu_id) {
        this.spu_id = spu_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getIndexes() {
        return indexes;
    }

    public void setIndexes(String indexes) {
        this.indexes = indexes;
    }

    public String getOwn_spec() {
        return own_spec;
    }

    public void setOwn_spec(String own_spec) {
        this.own_spec = own_spec;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getLast_update_time() {
        return last_update_time;
    }

    public void setLast_update_time(Date last_update_time) {
        this.last_update_time = last_update_time;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
