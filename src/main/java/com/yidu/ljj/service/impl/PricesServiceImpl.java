package com.yidu.ljj.service.impl;

import com.yidu.entity.Prices;
import com.yidu.ljj.dao.PricesDao;
import com.yidu.ljj.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Prices)表服务实现类
 *
 * @author makejava
 * @since 2021-01-08 16:27:06
 */
@Service
public class PricesServiceImpl implements PricesService {
    @Autowired
    PricesDao pricesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param priceid 主键
     * @return 实例对象
     */
    @Override
    public Prices queryById(Integer priceid ) {
        return this.pricesDao.queryById(priceid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public HashMap<String,Object> queryAllByLimit(int offset, int limit,String text) {
        HashMap<String,Object> map=new HashMap<>();
        map.put("rows",pricesDao.queryAllByLimit(offset, limit,text));
        map.put("total",pricesDao.count(text));
        return map;
    }

    /**
     * 新增数据
     *
     * @param prices 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(Prices prices) {
        int insert = this.pricesDao.insert(prices);
        if(insert>0){
            return "新增成功！";
        }
        return "新增失败";
    }

    /**
     * 修改数据
     *
     * @param prices 实例对象
     * @return 实例对象
     */
    @Override
    public String update(Prices prices) {
        int update = this.pricesDao.update(prices);
        if (update>0){
            return "修改成功！";
        }
        return "修改失败";
    }

    /**
     * 通过主键删除数据
     *
     * @param priceid 主键
     * @return 是否成功
     */
    @Override
    public String deleteById(Integer priceid ) {
        int delete = this.pricesDao.deleteById(priceid);
        if(delete>0){
            return "删除成功！";
        }
        return "删除失败";
    }
}