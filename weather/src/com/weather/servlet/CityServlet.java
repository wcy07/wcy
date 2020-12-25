package com.weather.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.bean.City;
import com.weather.bean.County;
import com.weather.bean.Province;
import com.weather.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Classname ${NAME}
 * @Description
 * @Date 2020/11/30 15:17
 * @Created by Administrator
 */
@WebServlet(value = "/api/china/*")
public class CityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pid;
        String json;
        ObjectMapper om = new ObjectMapper();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String[] split = request.getRequestURI().split("/");
        int len = split.length;

        if (len == 5) {
            pid = Integer.parseInt(split[4]);
            List<County> list = DBUtil.findAllCounty(pid);
            json = om.writeValueAsString(list);
        }else if (len == 4){
            pid = Integer.parseInt(split[3]);
            List<City> list = DBUtil.findAllCity(pid);
            json = om.writeValueAsString(list);
        }else if (len == 3){
            List<Province> list = DBUtil.findAllProvince();
            json = om.writeValueAsString(list);
        }else{
            json = "";
        }

        response.getWriter().write(json);
    }
}
