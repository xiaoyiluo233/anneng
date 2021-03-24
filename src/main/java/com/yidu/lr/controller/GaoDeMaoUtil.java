package com.yidu.lr.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GaoDeMaoUtil {
    /**
     * 高德地图通过地址获取经纬度
     */
    public static String httpURLConectionGET(String address,String city) {
        //"http://restapi.amap.com/v3/geocode/geo?address=上海市东方明珠&output=JSON&key=xxxxxxxxx";
        String geturl;
        if (city.equals("")) {
            geturl = "http://restapi.amap.com/v3/geocode/geo?key=389880a06e3f893ea46036f030c94700&address="+address;
        }else {
            geturl = "http://restapi.amap.com/v3/geocode/geo?key=389880a06e3f893ea46036f030c94700&address="+address+"&city="+city;
        }

        String location = "";
        try {
            URL url = new URL(geturl);    // 把字符串转换为URL请求地址
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 打开连接
            connection.connect();// 连接会话
            // 获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {// 循环读取流
                sb.append(line);
            }
            br.close();// 关闭流
            connection.disconnect();// 断开连接
            JSONObject a = JSON.parseObject(sb.toString());

            JSONArray sddressArr = JSON.parseArray(a.get("geocodes").toString());

            JSONObject c = JSON.parseObject(sddressArr.get(0).toString());
            location = c.get("location").toString();
        }catch (IndexOutOfBoundsException index) {
            throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("失败!");
        }
        return location;
    }

    public static void main(String[] args) {
        System.out.println(httpURLConectionGET("北京",""));
    }

}
