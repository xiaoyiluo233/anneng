package com.yidu.zsh.service.impl;

import com.yidu.entity.Business;
import com.yidu.zsh.dao.BusinessDao;
import com.yidu.zsh.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Business)表服务实现类
 *
 * @author makejava
 * @since 2021-01-08 14:25:29
 */
@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private BusinessDao businessDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bid 主键
     * @return 实例对象
     */
    @Override
    public Business queryById(Integer bid) {
        return this.businessDao.queryById(bid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Business> queryAllByLimit(int offset, int limit) {
        return this.businessDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Business> queryAll(Business business) {
        return this.businessDao.queryAll(business);
    }

    /**
     * 新增数据
     *
     * @param business 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(Business business) {
        String reuslt = "新增失败";
        int insert = businessDao.insert(business);
        if (insert>0){
            reuslt = "新增成功";
        }
        return reuslt;
    }

    /**
     * 修改数据
     *
     * @param business 实例对象
     * @return 实例对象
     */
    @Override
    public String update(Business business) {
        String reuslt = "修改失败";
        int update = this.businessDao.update(business);
        if (update>0){
            reuslt = "修改成功";
        }
        return reuslt;
    }
    /**
     * 通过主键删除数据
     *
     * @param bid 主键
     * @return 是否成功
     */
    @Override
    public String deleteById(String bid) {
        int result = 0;
        String[] split = bid.split(",");
        for (int i = 0; i < split.length; i++) {
            int deleteById = businessDao.deleteById(Integer.parseInt(split[i]));
            if (deleteById>0){
                result++;
            }
        }
        if (result==split.length){
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
}