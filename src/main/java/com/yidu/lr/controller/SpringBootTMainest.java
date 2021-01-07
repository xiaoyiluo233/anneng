package com.yidu.lr.controller;

import com.yidu.entity.*;
import com.yidu.lr.service.*;
import com.yidu.lr.service.impl.OrdersServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTMainest {
    //省服务对象
    @Resource
    private ProvinceService provinceService;

    //市服务对象
    @Resource
    private CityService cityService;

    //区服务对象
    @Resource
    private DistrictService districtService;

    //线路服务对象
    @Resource
    private PathService pathService;

    //订单服务对象
    @Autowired
    private OrdersServiceImpl ordersService;

    //地址服务对象
    @Resource
    private AddressService addressService;

    //货物服务对象
    @Resource
    private ProductService productService;

    //货物服务对象
    @Resource
    private ParcelService parcelService;

    //区信息暂存集合
    List<District> listDistrict = new ArrayList<>();
    //市信息暂存集合
    List<City> listCity = new ArrayList<>();
    //省信息暂存集合
    List<Province> listProvince = new ArrayList<>();
    //订单信息暂存集合
    List<Orders> orders = new ArrayList<>();

    //创建set集合
    HashSet<Integer> setprovince=new HashSet<>();
    HashSet<Integer> setcity=new HashSet<>();
    HashSet<Integer> setdistrict=new HashSet<>();

    HashMap provincemap = new HashMap();
    HashMap citymap = new HashMap();
    HashMap districtmap = new HashMap();

    int count=0;

    @Test
    public void selectAll() {

        forOrders();
        for (Integer integer : setprovince) {
            provincemap.put(integer,"");
        }

        for (Integer integer : setcity) {
            citymap.put(integer,"");
        }

        for (Integer integer : setdistrict) {
            districtmap.put(integer,"");
        }


        //循环订单列表
        for (Orders order : orders) {
            //单个订单信息 （根据订单货物id查询货物信息）
            Product product = productService.queryById(order.getPid());

            //寄件人地址 （根据货物地址id查询地址信息）
            Address myaddress = addressService.queryById(product.getMyaid());
            //寄件人地区信息 （根据地址区级id查询区级信息）
            District mydistrict = districtService.queryById(myaddress.getDistrictid());
            //寄件人市信息 （根据地区市级id查询市级信息）
            City mycity = cityService.queryById(mydistrict.getCityid());
            //寄件人省信息 （根据市省级id查询省信息）
            Province myprovince = provinceService.queryById(mycity.getProvinceid());

//            //收件人地址 （根据货物地址id查询地址信息）
//            Address youaddress = addressService.queryById(product.getYouaid());

            //收件人地区信息 （根据地址区级id查询区级信息）
            District youdistrict = listDistrict.get(count);
            //收件人市信息 （根据地区市级id查询市级信息）
            City youcity = listCity.get(count);
            //收件人省信息 （根据市省级id查询省信息）
            Province youprovince = listProvince.get(count);
                        
            for (Integer integer : setprovince) {
                if (youprovince.getProvinceid() == integer) {
                    provincemap.put(integer, provincemap.get(integer).toString() + order.getOid() + "-");
                }

            }

            for (Integer integer : setcity) {
                if(youcity.getCityid()==integer){
                    citymap.put(integer,citymap.get(integer).toString() + order.getOid() + "-");
                }
            }

            for (Integer integer : setdistrict) {
                if(youdistrict.getDistrictid()==integer){
                    districtmap.put(integer,districtmap.get(integer).toString() + order.getOid() + "-");
                }
            }

            //所有订单寄收省地址判断
            if (myprovince.getProvincename().equals(youprovince.getProvincename())) {
                System.out.println("同省");
                //市判断
                if (mycity.getCityname().equals(youcity.getCityname())) {
                    System.out.println("同市");
                    //区判断
                    if (mydistrict.getDistrictname().equals(youdistrict.getDistrictname())) {
                        System.out.println("同区");
                    }
                }
            }
            count++;
        }

        Set set = provincemap.keySet();
        for (Object o : set) {
            System.out.println("省id"+o+"="+provincemap.get(o));
        }

        Set set1 = citymap.keySet();
        for (Object o : set1) {
            System.out.println("市id"+o+"="+citymap.get(o));
        }

        Set set2 = districtmap.keySet();
        for (Object o : set2) {
            System.out.println("区id"+o+"="+districtmap.get(o));
        }

    }





    @Test
    public void forOrders(){
        //所有订单对象列表
        orders = ordersService.queryAll(null);

        //循环
        for (Orders order : orders) {
            //单个订单信息 （根据订单货物id查询货物信息）
            Product product = productService.queryById(order.getPid());

            //收件人地址 （根据货物地址id查询地址信息）
            Address youaddress = addressService.queryById(product.getYouaid());
            //收件人地区信息 （根据地址区级id查询区级信息）
            District youdistrict = districtService.queryById(youaddress.getDistrictid());
            //收件人市信息 （根据地区市级id查询市级信息）
            City youcity = cityService.queryById(youdistrict.getCityid());
            //收件人省信息 （根据市省级id查询省信息）
            Province youprovince = provinceService.queryById(youcity.getProvinceid());

            //查询信息暂存list集合
            listDistrict.add(youdistrict);
            listCity.add(youcity);
            listProvince.add(youprovince);

            //保存收货地址总共省
            setprovince.add(youprovince.getProvinceid());
            //保存收货地址总共市
            setcity.add(youcity.getCityid());
            //保存收货地址总共区
            setdistrict.add(youdistrict.getDistrictid());
        }
//        for (District district : listDistrict) {
//            System.out.println("listDistrict = " + district.getDistrictname());
//        }
//        for (City City : listCity) {
//            System.out.println("listCity = " + City.getCityname());
//        }
//        for (Province province : listProvince) {
//            System.out.println("listProvince = " + province.getProvincename());
//        }
//        for (Integer integer : setprovince) {
//            System.out.println("integerprovince = " + integer);
//        }
//
//        for (Integer integer : setcity) {
//            System.out.println("integercity = " + integer);
//        }
//
//        for (Integer integer : setdistrict) {
//            System.out.println("integerdistrict = " + integer);
//        }
    }

    @Test
    public void test01(){
        String[] str1="1-2-3".split("-");
        for (int i = 0; i < str1.length; i++) {
            System.out.println("str1[i] = " + str1[i]);
        }

        String[] str2="1-2-3-".split("-");
        for (int i = 0; i < str2.length; i++) {
            System.out.println("str2[i] = " + str2[i]);
        }

        
    }

}
