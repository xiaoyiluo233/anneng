package com.yidu.tgh.service.impl;
import com.yidu.entity.Goods;
import com.yidu.entity.Trucks;
import com.yidu.entity.Warehouse;
import com.yidu.ly.dao.WarehouseDao;
import com.yidu.tgh.dao.GoodsDao;
import com.yidu.tgh.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * (Goods)表服务实现类
 *
 * @author makejava
 * @since 2021-01-05 16:25:16
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private WarehouseDao warehouseDao;

    @Override
    public int[] getWids() {
        //得到所有仓库信息集合
        List<Warehouse> warehouses = warehouseDao.queryAll(null);
        //创建数组用于存储仓库id
        int[] wids = new int[warehouses.size()];
        //循环取出仓库集合
        for (int i = 0; i < warehouses.size(); i++) {
            //得到仓库实体类
            Warehouse warehouse = warehouses.get(i);
            //得到仓库id
            Integer wid = warehouse.getWid();
            //将仓库id存入数组
            wids[i] = wid;
        }
        return wids;
    }

    @Override
    public String[] getWnames() {
        //得到所有仓库信息集合
        List<Warehouse> warehouses = warehouseDao.queryAll(null);
        //创建数组用于存储仓库名
        String[] wnames = new String[warehouses.size()];
        //循环取出仓库集合
        for (int i = 0; i < warehouses.size(); i++) {
            //得到仓库实体类
            Warehouse warehouse = warehouses.get(i);
            //得到仓库名
            String widname = warehouse.getWname();
            //将仓库id存入数组
            wnames[i] = widname;
        }
        return wnames;
    }

    @Override
    public List<Goods> selects(Goods goods) {
        return this.goodsDao.selects(goods);
    }

    @Override
    public Goods inserts(Goods goods) {
        this.goodsDao.insert(goods);
        return goods;

    }

    @Override
    public Goods updates(Goods goods) {
        this.goodsDao.inserts(goods);
        return goods;


    }

    /**
     * 查询所有物流信息并存入集合
     * @return hashMapList
     */

    @Override
    public List<HashMap<String, Object>> getNames() {
        //调用查询
        List<Goods> goods = goodsDao.queryAll(null);
        //得到仓库名
        List<HashMap<String, Object>> hashMapList = goodsDao.getNames();
        //返回集合
        return hashMapList;
    }

    /**
     * 查询物流的信息
     * @param goods 物流跟踪实体
     * @return map
     */
    @Override
    public HashMap<String, Object> queryAll(Goods goods) {
        //创建集合
        HashMap<String, Object> map = new HashMap<>();
        //添加行数据
        map.put("rows", goodsDao.queryAll(goods));
        //添加总行数
        map.put("total", goodsDao.count(null));
        //返回map集合
        return map;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param taid 主键
     * @return 实例对象
     */

    public Goods queryById(Integer taid) {
        return this.goodsDao.queryById(taid);
    }

    @Override
    public HashMap<String, Object> queryAllByLimit(Integer offset, Integer limit, String tnumbers) {
        //创建集合
        HashMap<String, Object> map = new HashMap<>();
        //添加行数据
        map.put("rows", goodsDao.queryAllByLimit(offset, limit, tnumbers));
        //添加总行数
        map.put("total", goodsDao.count(tnumbers));
        //返回map集合
        return map;
    }


    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */

    public String insert(Goods goods) {
        //得到时间工具类设置格式
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        System.out.println("format = " + format);
        //得到当前具体时间并存入字段
        goods.setTimes(format);
        //申明变量用于返回值
        String result = "新增失败";
        /*  String times=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());*/
        //新增物流
        int insert = this.goodsDao.insert(goods);
        //判断是否新增成功
        if (insert > 0) {
            result = "新增成功";
        }
        //返回变量
        return result;
    }

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */

    public String update(Goods goods) {
        //得到时间工具类设置格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //得到当前时间
        String format = sdf.format(new Date());
        //得到当前具体时间并存入字段
        goods.setTimes(format);
        //申明变量用于返回值
        String result = "修改失败";
        //修改物流
        int update = this.goodsDao.update(goods);
        //判断物流是否修改成功
        if (update > 0) {
            result = "修改成功";
        }
        //返回
        return result;

    }

    /**
     * 通过主键删除数据
     *
     * @param taid 主键
     * @return 删除
     */

    public String deleteById(String taid) {
        //申明变量用于返回值
        int result = 0;
        //根据,截取id
        String[] split = taid.split(",");
        //循环出所有的id
        for (int i = 0; i < split.length; i++) {
            //调用删除并且转成string
            int deleteById = goodsDao.deleteById(Integer.parseInt(split[i]));
            //判断删除的个数是否大于零
            if (deleteById > 0) {
                //加加
                result++;
            }
        }
        //判断是否删除成功
        if (result == split.length) {
            return "删除成功！";
        } else {
            return "删除失败！";
        }

    }


}
