package com.yidu.lf.service.impl;

import com.yidu.entity.Complaint;
import com.yidu.lf.dao.ComplaintDao;
import com.yidu.lf.service.ComplaintService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Complaint)表服务实现类
 *
 * @author makejava
 * @since 2021-03-03 13:55:23
 */
@Service("complaintService")
public class ComplaintServiceImpl implements ComplaintService {
    @Resource
    private ComplaintDao complaintDao;

    /**
     * 通过ID查询单条数据
     *
     * @param complaintid 主键
     * @return 实例对象
     */
    @Override
    public Complaint queryById(Integer complaintid) {
        return this.complaintDao.queryById(complaintid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public HashMap<String,Object> queryAllByLimit(int offset, int limit, String text) {
        //申明一个map
        HashMap<String,Object> hashMap=new HashMap<>();
        //将查询出的员工列表放入map
        hashMap.put("rows",this.complaintDao.queryAllByLimit(offset, limit,text));
        //将总行数放入map
        hashMap.put("total",this.complaintDao.count(text));
        //返回map
        return hashMap;
    }

    /**
     * 新增数据
     *
     * @param complaint 实例对象
     * @return 是否成功
     */
    @Override
    public boolean insert(Complaint complaint) {
        return this.complaintDao.insert(complaint)>0;
    }

    /**
     * 修改数据
     *
     * @param complaint 实例对象
     * @return 是否成功
     */
    @Override
    public boolean update(Complaint complaint) {
        return this.complaintDao.update(complaint)>0;
    }

    /**
     * 通过主键删除数据
     *
     * @param complaintid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer complaintid) {
        return this.complaintDao.deleteById(complaintid) > 0;
    }
}