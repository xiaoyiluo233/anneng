package com.yidu.luoxiao.service.impl;

import com.yidu.entity.Joborders;
import com.yidu.luoxiao.dao.JobordersDao;
import com.yidu.luoxiao.service.JobordersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Joborders)表服务实现类
 *
 * @author makejava
 * @since 2020-12-30 14:21:15
 */
@Service
public class JobordersServiceImpl implements JobordersService {
    @Autowired
    private JobordersDao jobordersDao;

    @Override
    public List<Joborders> querAll() {
        List<Joborders> joborders = jobordersDao.queryAll(null);
        return joborders;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param jid 主键
     * @return 实例对象
     */
    @Override
    public Joborders queryById(Integer jid) {
        return this.jobordersDao.queryById(jid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Joborders> queryAllByLimit(int offset, int limit) {
        return this.jobordersDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     * @param joborders 实例对象
     * @return
     */
    @Override
    public Boolean insert(Joborders joborders) {
        int insert = this.jobordersDao.insert(joborders);
        if (insert>0) {
            return true;
        }
        return false;
    }

    /**
     * 修改数据
     * @param joborders 实例对象
     * @return
     */
    @Override
    public Boolean update(Joborders joborders) {
        int update = this.jobordersDao.update(joborders);
        if (update>0){
            return true;
        }
        return false;
    }

    /**
     * 通过主键删除数据
     *
     * @param jid 主键
     * @return 是否成功
     */
    @Override
    public Boolean deleteById(Integer jid) {
        return this.jobordersDao.deleteById(jid) > 0;
    }
}