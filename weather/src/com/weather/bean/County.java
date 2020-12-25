package com.weather.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Classname County
 * @Description
 * @Date 2020/11/28 15:50
 * @Created by Administrator
 */
public class County {


    private int id;
    private String name;
    private String weather_id;
    @JsonIgnore
    private int cityId;

    public County() {
    }

    public County(int id, String name, String weather_id, int cityId) {
        this.id = id;
        this.name = name;
        this.weather_id = weather_id;
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

    public String getWeather_id() {
        return weather_id;
    }

    public void setWeather_id(String weather_id) {
        this.weather_id = weather_id;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
