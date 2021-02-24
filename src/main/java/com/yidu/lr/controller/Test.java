package com.yidu.lr.controller;

public class Test {




    /**
     * 1、爬楼梯算法：已知一个楼梯有n个台阶，每次可以选择迈上一个或者两个台阶，求走完一共有多少种不同的走法。
     *
     *  已知    climbStairs(2)=x  climbStairs(1)=y    求climbStairs(n)=?     climbStairs(n-1)+climbStairs(n-2)=总走法
     *
     *  n=3    climbStairs(3) = climbStairs(2)+climbStairs(1)=x+y;
     *  n=4    climbStairs(4) = climbStairs(3)+climbStairs(2) = (climbStairs(2)+climbStairs(1))+climbStairs(2) = (x+y)+x = 2x+y;
     *  n=5    climbStairs(5) = climbStairs(4)+climbStairs(3) = ((climbStairs(2)+climbStairs(1))+climbStairs(2))+(climbStairs(2)+climbStairs(1)) = ((x+y)+x)+(x+y) = 3x+2y;
     *  n=6    climbStairs(6) = climbStairs(5)+climbStairs(4) = (3x+2y)+(2x+y) = 5x+3y;
     *  n=7    climbStairs(7) = climbStairs(6)+climbStairs(5) = (5x+3y)+(3x+2y) = 8x+5y
     *  n=n    climbStairs(n)=climbStairs(n-1)+climbStairs(n-2);
     * @param n
     * @return
     */
    public static int climbStairs(int n){
        int i=1;
        if(n<=0)
            return 0;
        if(n==1) {
            return i;
        }if(n==2){
            i++;
            return i;
        }else
            return climbStairs(n-1)+climbStairs(n-2);
    };


    private final int TRIED=3;
    private final int PATH=7;

    private int [][] grid={
            {1,1,1,0,0,1,0,1,0,0},
            {0,0,1,1,1,0,0,0,0,0},
            {1,0,1,0,0,0,1,1,1,1},
            {1,1,1,1,1,0,0,0,1,1},
            {0,0,0,0,1,1,1,0,0,0},
            {1,0,1,0,1,0,0,1,0,0},
            {1,0,0,1,1,1,1,1,1,1}		};
    public boolean traverse(int row,int column){
        boolean done =false;
        if(valid(row,column))
        {
            grid[row][column]=TRIED;
            if(row==grid.length-1&&column==grid[0].length-1)
                done=true;
            else
            {
                done=traverse(row+1,column);//down
                if(!done)
                    done=traverse(row,column+1);//right
                if(!done)
                    done=traverse(row-1,column);//up
                if(!done)
                    done=traverse(row,column-1);//left
            }
            if(done)
                grid[row][column]=PATH;
        }
        return done;
    }
    private boolean valid(int row,int column){
        boolean result=false;
        if(row>=0&&row<grid.length&&column>=0&&column<grid[row].length)
            if(grid[row][column]==1)
                result=true;
        return result;
    }
    public String toString(){
        String result="\n";
        for (int row=0;row<grid.length;row++){
            for(int column=0;column<grid[row].length;column++){
                result +=grid[row][column]+" ";
            }
            result+="\n";
        }
        return result;
    }

    public static void main (String []args){

        //1、爬楼梯算法：已知一个楼梯有n个台阶，每次可以选择迈上一个或者两个台阶，求走完一共有多少种不同的走法。
        //System.out.println("climbStairs(T) = " + climbStairs(3));

        //2.迷宫走法：二维数组构成一个迷宫，1表示通路，0表示不通，找到一条路径从起始点（traverse函数的参数）到终点（右下角点）。
        //
        //基础情形：row=grid.length-1&&column=grid[0].length-1时done=true；
        Test test=new Test();
        System.out.println(test);
        if(test.traverse(0, 0))
            System.out.println("The maze was successfully travelled!");
        else
            System.out.println("There is no possible path.");
        System.out.println(test);
    }

//    //区信息暂存集合
//    List<District> listDistrict = new ArrayList<>();
//    //市信息暂存集合
//    List<City> listCity = new ArrayList<>();
//    //省信息暂存集合
//    List<Province> listProvince = new ArrayList<>();
//    //订单信息暂存集合
//    List<Orders> ordersList = new ArrayList<>();
//
//    //创建省市区set集合
//    HashSet<Integer> setprovince=new HashSet<>();
//    HashSet<Integer> setcity=new HashSet<>();
//    HashSet<Integer> setdistrict=new HashSet<>();
//
//    //创建省市区中转站set集合
//    List<Integer> listpstation=new ArrayList<>();
//    List<Integer> listcstation=new ArrayList<>();
//    List<Integer> listdstation=new ArrayList<>();
//
//    //创建省市区map集合
//    HashMap provincemap = new HashMap();
//    HashMap citymap = new HashMap();
//    HashMap districtmap = new HashMap();
//
//    //订单循环次数
//    int count=0;
//
//    @Test
//    public void selectAll() {
//
//        //订单信息等暂存集合
//        forOrders();
//        //初始化map集合
//        for (Integer integer : setprovince) {
//            provincemap.put(integer,"");
//        }
//
//        for (Integer integer : setcity) {
//            citymap.put(integer,"");
//        }
//
//        for (Integer integer : setdistrict) {
//            districtmap.put(integer,"");
//        }
//
//
//        //循环订单列表
//        for (Orders order : ordersList) {
//            //单个订单信息 （根据订单货物id查询货物信息）
//            Product product = productService.queryById(order.getPid());
//
//            //寄件人地址 （根据货物地址id查询地址信息）
//            Address myaddress = addressService.queryById(product.getMyaid());
//            //寄件人地区信息 （根据地址区级id查询区级信息）
//            District mydistrict = districtService.queryById(myaddress.getDistrictid());
//            //寄件人市信息 （根据地区市级id查询市级信息）
//            City mycity = cityService.queryById(mydistrict.getCityid());
//            //寄件人省信息 （根据市省级id查询省信息）
//            Province myprovince = provinceService.queryById(mycity.getProvinceid());
//
//            //收件人地区信息 （根据地址区级id查询区级信息）
//            District youdistrict = listDistrict.get(count);
//            //收件人市信息 （根据地区市级id查询市级信息）
//            City youcity = listCity.get(count);
//            //收件人省信息 （根据市省级id查询省信息）
//            Province youprovince = listProvince.get(count);
//
//
//            //拼接相同省地址订单id
//            for (Integer integer : setprovince) {
//                if (youprovince.getProvinceid() == integer) {
//                    listpstation.add(youcity.getCityid());
//                    provincemap.put(integer, provincemap.get(integer).toString() + order.getOid() + "-");
//                }
//
//            }
//            //拼接相同市地址订单id
//            for (Integer integer : setcity) {
//                if(youcity.getCityid()==integer){
//                    listcstation.add(youcity.getCityid());
//                    citymap.put(integer,citymap.get(integer).toString() + order.getOid() + "-");
//                }
//            }
//            //拼接相同区地址订单id
//            for (Integer integer : setdistrict) {
//                if(youdistrict.getDistrictid()==integer){
//                    listdstation.add(youcity.getCityid());
//                    districtmap.put(integer,districtmap.get(integer).toString() + order.getOid() + "-");
//                }
//            }
//
//            //所有订单寄收省地址判断
//            if (myprovince.getProvincename().equals(youprovince.getProvincename())) {
//                System.out.println("同省");
//                //市判断
//                if (mycity.getCityname().equals(youcity.getCityname())) {
//                    System.out.println("同市");
//                    //区判断
//                    if (mydistrict.getDistrictname().equals(youdistrict.getDistrictname())) {
//                        System.out.println("同区");
//                    }
//                }
//            }
//        }
//        //新增包裹数据
//        forinsertSet();
//    }
//
//    @Test
//    public void forinsertSet(){
//        //输出省
//        Set set = provincemap.keySet();
//        for (Object o : set) {
//
//            System.out.println("省id"+o+"="+provincemap.get(o));
//            parcel1.setOid(provincemap.get(o).toString());
//            parcel1.setState(1);
//            parcel1.setNextstation(listpstation.get(count));
//            System.out.println("parcel = " + parcel1);
//            parcelService.insert(parcel1);
//            count++;
//            if(count==set.size()){
//                count=0;
//            }
//        }
//        //输出市
//        Set set1 = citymap.keySet();
//        for (Object o : set1) {
//            System.out.println("市id"+o+"="+citymap.get(o));
//            parcel2.setOid(citymap.get(o).toString());
//            parcel2.setState(2);
//            parcel2.setNextstation(listcstation.get(count));
//            parcelService.insert(parcel2);
//            count++;
//            if(count==set1.size()){
//                count=0;
//            }
//        }
//        //输出区
//        Set set2 = districtmap.keySet();
//        for (Object o : set2) {
//            System.out.println("区id"+o+"="+districtmap.get(o));
//            parcel3.setOid(districtmap.get(o).toString());
//            parcel3.setState(3);
//            parcel3.setNextstation(listdstation.get(count));
//            parcelService.insert(parcel3);
//            count++;
//            if(count==set2.size()){
//                count=0;
//            }
//        }
//    }
//
//
//    @Test
//    public void forOrders(){
//        //所有订单对象列表
//        ordersList = ordersService.queryAll(null);
//
//        //循环
//        for (Orders order : ordersList) {
//            //单个订单信息 （根据订单货物id查询货物信息）
//            Product product = productService.queryById(order.getPid());
//
//            //收件人地址 （根据货物地址id查询地址信息）
//            Address youaddress = addressService.queryById(product.getYouaid());
//            //收件人地区信息 （根据地址区级id查询区级信息）
//            District youdistrict = districtService.queryById(youaddress.getDistrictid());
//            //收件人市信息 （根据地区市级id查询市级信息）
//            City youcity = cityService.queryById(youdistrict.getCityid());
//            //收件人省信息 （根据市省级id查询省信息）
//            Province youprovince = provinceService.queryById(youcity.getProvinceid());
//
//            //查询信息暂存list集合
//            listDistrict.add(youdistrict);
//            listCity.add(youcity);
//            listProvince.add(youprovince);
//
//            //保存收货地址总共省
//            setprovince.add(youprovince.getProvinceid());
//            //保存收货地址总共市
//            setcity.add(youcity.getCityid());
//            //保存收货地址总共区
//            setdistrict.add(youdistrict.getDistrictid());
//        }
//    }
}
