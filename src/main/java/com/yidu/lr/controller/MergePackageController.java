package com.yidu.lr.controller;


import com.yidu.entity.*;
import com.yidu.lr.service.impl.*;
import com.yidu.ly.service.impl.WarehouseServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("merge")
public class MergePackageController {
    //省服务对象
    @Autowired
    private LRProvinceServiceImpl provinceService;

    //市服务对象
    @Autowired
    private LRCityServiceImpl cityService;

    //区服务对象
    @Autowired
    private LRDistrictServiceImpl districtService;

    //订单服务对象
    @Autowired
    private LROrdersServiceImpl ordersService;

    //地址服务对象
    @Autowired
    private LRAddressServiceImpl addressService;

    //货物服务对象
    @Autowired
    private LRProductServiceImpl productService;

    @Autowired
    private LRPathServiceImpl pathService;

    @Autowired
    private LRStationServiceImpl stationService;

    @Autowired
    private LRRouteServiceImpl routeService;

    @Autowired
    private LRTrucksServiceImpl trucksService;

    @Autowired
    private WarehouseServiceImpl warehouseService;


    //货物服务对象
    @Autowired
    private LRParcelServiceImpl parcelService;

    @Autowired
    private Trucks trucks;

    @Autowired
    private Parcel parcel;

    @Autowired
    District mydistrict;

    @Autowired
    Warehouse warehouse;


    //区信息暂存集合
    List<District> listDistrict = new ArrayList<>();
    //市信息暂存集合
    List<City> listCity = new ArrayList<>();
    //省信息暂存集合
    List<Province> listProvince = new ArrayList<>();

    //区信息暂存集合
    List<District> mylistDistrict = new ArrayList<>();
    //市信息暂存集合
    List<City> mylistCity = new ArrayList<>();
    //省信息暂存集合
    List<Province> mylistProvince = new ArrayList<>();
    //订单信息暂存集合
    List<Orders> orders = new ArrayList<>();

    //创建省市区set集合
    HashSet<Province> setprovince=new HashSet<>();
    HashSet<City> setcity=new HashSet<>();
    HashSet<District> setdistrict=new HashSet<>();

    //创建省市区set集合
    HashSet<Integer> mysetprovince=new HashSet<>();
    HashSet<Integer> mysetcity=new HashSet<>();
    HashSet<Integer> mysetdistrict=new HashSet<>();

    //创建省市区订单号暂存map集合
    HashMap provincemap = new HashMap();
    HashMap citymap = new HashMap();
    HashMap districtmap = new HashMap();

    //订单循环次数
    int count=0;

    @ResponseBody
    @RequestMapping("MergePackage")
    public boolean MergePackage(Integer parcelid){
        //根据包裹id查询包裹信息
        Parcel parcel = parcelService.queryById(parcelid);
        //根据包裹id查询车辆信息
        Trucks trucks = trucksService.queryByParcelid(parcelid);
        //根据车辆id查询路由信息
        Route route = routeService.queryByPathId(trucks.getTid());
        //根据路由线路id查询线路信息
        Path path = pathService.queryById(route.getPathid());
        //截取线路经过中转站id
        String[] split = path.getStationids().split("-");
        int upstation=0;
        int nextstation=0;
        //判断包裹合并次数
        if(parcel.getState()<=split.length+1){

            if(parcel.getState()==1){           //第一次合包
                //包裹对象设置上一个中转站为线路起点
                upstation=path.getStartstation();
                //包裹对象设置下一个中转站
                nextstation=Integer.parseInt(split[parcel.getState()-1]);
            }else if(parcel.getState()==split.length+1){     //最后一次合包
                //包裹对象设置下一个中转站为最终点
                nextstation=path.getDestination();
                //包裹对象设置上一个中转站为线路起点
                upstation=Integer.parseInt(split[parcel.getState()-2]);
            }else {
                //包裹对象设置下一个中转站为最终点
                nextstation=Integer.parseInt(split[parcel.getState()-1]);
                //包裹对象设置上一个中转站
                upstation=Integer.parseInt(split[parcel.getState()-2]);
            }

        }


        if(nextstation!=0){
            //设置上个中转站到包裹对象
            parcel.setUpstation(upstation);
            //设置下个中转站到包裹对象
            parcel.setNextstation(nextstation);
            //包裹对象设置记录状态+1
            parcel.setState(parcel.getState()+1);
            //修改包裹表
            parcelService.update(parcel);
            System.out.println("nextstation = " + nextstation);
            //根据下个中转id站查询中转站信息
            Station station = stationService.queryById(nextstation);

            //截取包裹订单号字符串
            String[] split1 = parcel.getOid().split("-");
            //循环订单号字符串
            for (int i = 0; i < split1.length; i++) {
                //单个订单信息 （根据订单货物id查询货物信息）
                Product product = productService.queryById(Integer.parseInt(split1[i]));
                //收件人地址 （根据货物地址id查询地址信息）
                Address youaddress = addressService.queryById(product.getYouaid());
                //收件人地区信息 （根据地址区级id查询区级信息）
                District youdistrict = districtService.queryById(youaddress.getDistrictid());
                //收件人市信息 （根据地区市级id查询市级信息）
                City youcity = cityService.queryById(youdistrict.getCityid());
                //收件人省信息 （根据市省级id查询省信息）
                Province youprovince = provinceService.queryById(youcity.getProvinceid());
                //根据订单id查询订单信息
                Orders orders = ordersService.queryById(Integer.parseInt(split1[i]));
                //根据包裹id查询包裹信息
                Parcel parcel1 = parcelService.queryById(parcelid);
                //去除区多余信息
                String str = youdistrict.getDistrictname().replace("区", "");
                //判断中转站字符串名字是否包含收件人区名字
                if(station.getStationname().contains(str)){
                    //截去订单号
                    String replace = parcel1.getOid().replace(split1[i] + "-", "");
                    if(replace==null || replace.equals("")){
                        replace="无订单";
                    }
                    //设置到包裹对象
                    parcel1.setOid(replace);
                    System.out.println("parcel1 = " + parcel1);
                    Warehouse warehouse1 = warehouseService.queryByWname(str);
                    warehouse.setOid(split1[i] + "-");
                 


                    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                    Date date = new Date(System.currentTimeMillis());
                    System.out.println(warehouse1);
                    if(warehouse1!=null){
                        warehouse1.setOid(warehouse1.getOid()+split1[i] + "-");
                        warehouse1.setTimes(formatter.format(date));
                        warehouse1.setState(1);
                        warehouseService.update(warehouse1);
                    }else {
                        warehouse.setWname(str);
                        warehouse.setTimes(formatter.format(date));
                        warehouse.setState(1);
                        warehouseService.insert(this.warehouse);
                    }
                    //修改包裹表
                    parcelService.update(parcel1);

                }
            }

        }
        //不报错返回真
        return true;
    }

    @ResponseBody
    @RequestMapping("firstMerge")
    public void selectAll() {

        //订单信息等暂存集合
        forOrders();
        //map集合初始值
        for (Integer integer : mysetdistrict) {
            districtmap.put(integer,"");
        }
        for (Integer integer : mysetcity) {
            citymap.put(integer,"");
        }
        for (Integer integer : mysetprovince) {
            provincemap.put(integer,"");
        }
        //循环订单列表
        for (Orders order : orders) {
            //单个订单信息 （根据订单货物id查询货物信息）
            Product product = productService.queryById(order.getPid());

            //寄件人地址 （根据货物地址id查询地址信息）
            Address myaddress = addressService.queryById(product.getMyaid());
            //寄件人地区信息 （根据地址区级id查询区级信息）
            mydistrict = districtService.queryById(myaddress.getDistrictid());
            //寄件人市信息 （根据地区市级id查询市级信息）
            City mycity = cityService.queryById(mydistrict.getCityid());
            //寄件人省信息 （根据市省级id查询省信息）
            Province myprovince = provinceService.queryById(mycity.getProvinceid());


            //收件人地区信息 （根据地址区级id查询区级信息）
            District youdistrict = listDistrict.get(count);
            //收件人市信息 （根据地区市级id查询市级信息）
            City youcity = listCity.get(count);
            //收件人省信息 （根据市省级id查询省信息）
            Province youprovince = listProvince.get(count);



//            //市判断
//            if (mycity.getCityid()!=youcity.getCityid()) {
                //System.out.println("不同市");
            for (Integer integer : mysetcity) {
                if(mycity.getCityid()==integer){
                    //System.out.println("integer = " + integer);
                    //第一次合包id
                    citymap.put(integer,citymap.get(integer).toString()+order.getOid()+"-");
                }
            }

                //循环寄件人set集合
                for (Integer integer : mysetcity) {
                    //设置订单寄件相同市
                    parcel.setOid(citymap.get(integer).toString());
                    //设置订单默认第一次状态
                    parcel.setState(1);
                    //新增包裹
                    parcelService.insert(parcel);
                    //查询新增的包裹信息
                    Parcel parcel1 = parcelService.queryIdMax();
                    //查询所有线路
                    List<Path> paths = pathService.queryAll(null);
                    //循环所有线路
                    for (Path path : paths) {
                        //根据线路起点查询中转站信息
                        Station station = stationService.queryById(path.getStartstation());

                        //根据线路id查询路由信息
                        Route route = routeService.queryByPathId(path.getPathid());
                        //根据路由车辆id查询车辆信息
                        Trucks trucks = trucksService.queryById(route.getTid());
                        //修改包裹id
                        trucks.setParcelid(parcel1.getParcelid());
                        //判断市id
                        if(integer==station.getCityid()){
                            //修改车辆信息
                            trucksService.update(trucks);
                        }
                        //截取线路经过中转站id
                        String[] split = path.getStationids().split("-");
                        //循环截取的字符串
                        for (String s : split) {
                            //根据截取字符串查询中转站信息
                            Station station1 = stationService.queryById(Integer.parseInt(s));
                            //判断中转站市id等于寄件人市id
                            if(station1.getCityid()==integer){
                                //修改车辆信息
                                trucksService.update(trucks);
                            }
                        }

                        //根据线路终点
                        Station station2 = stationService.queryById(path.getDestination());
                        if(integer==station2.getCityid()){
                            //修改车辆信息
                            trucksService.update(trucks);
                        }
                    }

                }

                //省判断
                if (!myprovince.getProvincename().equals(youprovince.getProvincename())) {
                    System.out.println("不同省");

                }else{
                    System.out.println("同省,省合包并发往市中转站再发往区中转站");
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

    }





    public void forOrders(){
        //所有订单对象列表
        orders = ordersService.queryAll(null);

        //循环
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

            //收件人地址 （根据货物地址id查询地址信息）
            Address youaddress = addressService.queryById(product.getYouaid());
            //收件人地区信息 （根据地址区级id查询区级信息）
            District youdistrict = districtService.queryById(youaddress.getDistrictid());
            //收件人市信息 （根据地区市级id查询市级信息）
            City youcity = cityService.queryById(youdistrict.getCityid());
            //收件人省信息 （根据市省级id查询省信息）
            Province youprovince = provinceService.queryById(youcity.getProvinceid());

            //查询信息暂存list集合
            mylistDistrict.add(mydistrict);
            mylistCity.add(mycity);
            mylistProvince.add(myprovince);

            //查询信息暂存list集合
            listDistrict.add(youdistrict);
            listCity.add(youcity);
            listProvince.add(youprovince);

            //保存收货地址总共省
            setprovince.add(youprovince);
            //保存收货地址总共市
            setcity.add(youcity);
            //保存收货地址总共区
            setdistrict.add(youdistrict);

            //保存收货地址总共省
            mysetprovince.add(myprovince.getProvinceid());
            //保存收货地址总共市
            mysetcity.add(mycity.getCityid());
            //保存收货地址总共区
            mysetdistrict.add(mydistrict.getDistrictid());
        }
    }

}
