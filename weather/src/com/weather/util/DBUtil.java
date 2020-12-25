package com.weather.util;

import com.weather.bean.City;
import com.weather.bean.County;
import com.weather.bean.Province;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname DBUtil
 * @Description
 * @Date 2020/11/30 14:15
 * @Created by Administrator
 */
public class DBUtil {
    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static Connection getConnection() {
        try {
            //1.加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.创建连接
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/weather?serverTimezone=UTC", "root", "root");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动文件没有找到！");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("创建连接失败！");
            e.printStackTrace();
        }
        return conn;
    }

    public static List<Province> findAllProvince(){
        List<Province> list = new ArrayList<>();

        conn = getConnection();
        String sql = "select * from province";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Province pro = new Province();
                pro.setName(rs.getString("provincename"));
                pro.setId(rs.getInt("provincecode"));
                list.add(pro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return list;
    }

    public static List<City> findAllCity(int pid){
        List<City> list = new ArrayList<City>();

        conn = getConnection();
        String sql = "select * from city where provinceid = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,pid);
            rs = ps.executeQuery();
            while (rs.next()){
                City city = new City();
                city.setName(rs.getString("cityname"));
                city.setId(rs.getInt("id"));
                list.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return list;
    }

    public static List<County> findAllCounty(int cid){
        List<County> list = new ArrayList<>();

        conn = getConnection();
        String sql = "select * from county where cityid = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,cid);
            rs = ps.executeQuery();
            while (rs.next()){
                County city = new County();
                city.setId(rs.getInt("id"));
                city.setName(rs.getString("countyname"));
                city.setWeather_id(rs.getString("weatherid"));
                list.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return list;
    }

    private static void close(){
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
