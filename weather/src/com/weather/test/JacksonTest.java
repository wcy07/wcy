package com.weather.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.bean.County;
import com.weather.bean.Province;
import com.weather.util.DBUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname JacksonTest
 * @Description
 * @Date 2020/11/30 14:04
 * @Created by Administrator
 */
public class JacksonTest {
    public static void main(String[] args) throws JsonProcessingException {

        List<County> list = DBUtil.findAllCounty(334);

        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(list);

        System.out.println(json);



    }

    
    
    private static void jsonTest() throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();

        Province p1 = new Province(1, "四川", 1);
        Province p2 = new Province(2, "河南", 2);
        Province p3 = new Province(3, "河北", 3);

        map.put("四川", p1);
        map.put("河南", p2);
        map.put("河北", p3);

        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(map);

        System.out.println(json);

    }
}
