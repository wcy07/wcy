package com.weather.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Classname Province
 * @Description
 * @Date 2020/11/28 15:47
 * @Created by Administrator
 */
public class Province {

    private int id;
    private String name;

    @JsonIgnore
    private int provinceId;

    public Province() {
    }

    public Province(int provinceId, String name, int id) {
        this.provinceId = provinceId;
        this.name = name;
        this.id = id;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
