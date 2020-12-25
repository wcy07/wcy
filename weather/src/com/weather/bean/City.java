package com.weather.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Classname City
 * @Description
 * @Date 2020/11/28 15:49
 * @Created by Administrator
 */
public class City {

    private int id;
    private String name;

    @JsonIgnore
    private int cityId;
    @JsonIgnore
    private int provinceId;

    public City() {
    }

    public City(int cityId, String name, int id, int provinceId) {
        this.cityId = cityId;
        this.name = name;
        this.id = id;
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
