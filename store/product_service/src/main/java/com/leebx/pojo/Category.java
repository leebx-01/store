package com.leebx.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@Table(name = "tb_category")
public class Category implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String name;
    private Long parent_id;
    private int is_parent;
    private int sort;
    private List<Category> subList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public int getIs_parent() {
        return is_parent;
    }

    public void setIs_parent(int is_parent) {
        this.is_parent = is_parent;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public List<Category> getSubList() {
        return subList;
    }

    public void setSubList(List<Category> subList) {
        this.subList = subList;
    }
}
