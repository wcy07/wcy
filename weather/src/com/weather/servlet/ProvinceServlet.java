package com.weather.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
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
 * @Date 2020/11/30 14:11
 * @Created by Administrator
 */
@WebServlet("/api/china")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        List<Province> proList = DBUtil.findAllProvince();

        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(proList);
        response.getWriter().write(json);
    }
}
