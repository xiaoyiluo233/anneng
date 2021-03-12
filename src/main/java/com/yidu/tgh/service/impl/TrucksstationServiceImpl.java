package com.yidu.tgh.service.impl;
import com.yidu.entity.Trucksstation;
import com.yidu.tgh.dao.TrucksstationDao;
import com.yidu.tgh.service.TrucksstationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * (Trucksstation)表服务实现类
 *
 * @author makejava
 * @since 2021-01-11 09:02:03
 */
@Service
public class TrucksstationServiceImpl implements TrucksstationService {
    @Autowired
    private TrucksstationDao trucksstationDao;

    @Override
    public List<HashMap<String, Object>> getName() {
        List<Trucksstation> trucksstations = trucksstationDao.queryAll(null);

        List<HashMap<String, Object>> hashMapList = trucksstationDao.getName();
        for (HashMap<String, Object> hashMap : hashMapList) {
            Set<String> strings = hashMap.keySet();
            for (String string : strings) {
            }
        }
        //返回集合
        return hashMapList;
    }

    @Override
    public HashMap<String, Object> queryAll(Trucksstation trucksstation) {
        //创建集合
        HashMap<String, Object> map = new HashMap<>();
        //添加行数据
        map.put("rows", trucksstationDao.queryAll(trucksstation));
        //添加总行数
        map.put("total", trucksstationDao.count(null));
        //返回map集合
        return map;

    }

    /**
     * 通过ID查询单条数据
     *
     * @param tsid 主键
     * @return 实例对象
     */
    @Override
    public Trucksstation queryById(Integer tsid) {
       /* return this.trucksstationDao.queryById(tsid);*/
        //返回调用查询单个
        return this.trucksstationDao.queryById(tsid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public HashMap<String, Object> queryAllByLimit(Integer offset, Integer limit, String tnumbers) {
        //创建集合
        HashMap<String, Object> map = new HashMap<>();
        //添加行数据
        map.put("rows", trucksstationDao.queryAllByLimit(offset, limit, tnumbers));
        //添加总行数
        map.put("total", trucksstationDao.count(tnumbers));
        //返回map集合
        return map;
    }
    /**
     * 新增数据
     *
     * @param trucksstation 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(Trucksstation trucksstation) {
        //申明变量用于返回值
        String result = "新增失败";
        //设置
        trucksstation.setTid(0);
        //调用新增
        int insert = this.trucksstationDao.insert(trucksstation);
        //判断修改是否大于0
        if (insert > 0){
            //成功返回成功
            result = "新增成功";
    }
        //返回变量
        return result;
    }
    /**
     * 修改数据
     *
     * @param trucksstation 实例对象
     * @return 实例对象
     */
    @Override
    public String update(Trucksstation trucksstation) {
        //申明变量用于返回值
        String result = "修改失败";
        //修改物流
        int update=this.trucksstationDao.update(trucksstation);
        //判断物流是否修改成功
        if (update > 0) {
            //成功返回成功
            result = "修改成功";
        }
        //返回结果
        return result;

    }

    @Override
    public String deleteById(String tsid) {
        //申明变量用于返回值
        int result = 0;
        //根据,截取id
        String[] split = tsid.split(",");
        //循环出所有的id
        for (int i = 0; i < split.length; i++) {
            //调用删除并且转成string
            int deleteById = trucksstationDao.deleteById(Integer.parseInt(split[i]));
            //判断删除的个数是否大于零
            if (deleteById > 0) {
                //加加
                result++;
            }
        }
        //判断是否删除成功
        if (result==split.length){
            //成功返回成功
            return "删除成功！";
        }else {
            //失败返回失败
            return "删除失败！";
        }
    }

}


