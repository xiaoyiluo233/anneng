package com.yidu.lixiang.service.impl;

import com.yidu.entity.Warerecord;
import com.yidu.lixiang.dao.WarerecordDao;
import com.yidu.lixiang.service.WarerecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 仓库记录表业务接口层
 * @author: lixiang
 * @date: 2021/3/11 18:29
 * @version 1.0
 */
@Service
public class WarerecordServiceImpl implements WarerecordService {
    @Autowired
    private WarerecordDao warerecordDao;

    /**
     * 连表查询出员工名、仓库名以及仓库记录表的基本数据
     * @return 数据集合
     */
    @Override
    public List<HashMap<String, Object>> getMainData() {
        //调用查询出员工名、仓库名以及仓库记录表的基本数据的方法
        List<HashMap<String, Object>> mainData = warerecordDao.getMainData();
        return mainData;
    }

    /**
     * 通过ID查询单条数据
     * @param wrid 主键
     * @return 实例对象
     */
    @Override
    public Warerecord queryById(Integer wrid) {
        return this.warerecordDao.queryById(wrid);
    }

    /**
     * 查询多条数据
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Warerecord> queryAllByLimit(int offset, int limit) {
        return this.warerecordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     * @param warerecord 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(Warerecord warerecord) {
        //创建时间格式类
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //得到时间
        String format = sdf.format(new Date());
        //设置到实体类中
        warerecord.setTimes(format);
        //调用新增的方法
        int insert = this.warerecordDao.insert(warerecord);
        //判断新增是否成功
        if (insert>0){
            return "新增成功！";
        }else {
            return "新增失败！";
        }
    }

    /**
     * 修改数据
     * @param warerecord 实例对象
     * @return 实例对象
     */
    @Override
    public String update(Warerecord warerecord) {
        //创建时间格式类
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //得到时间
        String format = sdf.format(new Date());
        //设置到实体类中
        warerecord.setTimes(format);
        //调用修改的方法
        int update = this.warerecordDao.update(warerecord);
        //判断修改是否成功
        if (update>0){
            return "修改成功！";
        }else {
            return "修改失败！";
        }
    }

    /**
     * 通过主键删除数据
     * @param wrids 主键字符串
     * @return 删除成功
     */
    @Override
    public String deleteById(String wrids) {
        //将字符串切割为数组
        String[] array = wrids.split(",");
        //申明变量用于记录删除成功的次数
        int sum=0;
        //循环取出id
        for (int i = 0; i < array.length; i++) {
            //得到id并转成int
            int parseInt = Integer.parseInt(array[i]);
            //调用删除的方法
            int deleteById = warerecordDao.deleteById(parseInt);
            //判断是否删除成功
            if (deleteById>0){
                //成功则sum++
                sum++;
            }
        }
        //判断sum是否与数组的长度相同
        if (sum==array.length){
            return "删除成功！";
        }else {
            return "删除失败！";
        }

    }
}