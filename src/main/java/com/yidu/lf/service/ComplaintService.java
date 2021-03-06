package com.yidu.lf.service;

import com.yidu.entity.Complaint;

import java.util.HashMap;
import java.util.List;

/**
 * (Complaint)表服务接口
 *
 * @author makejava
 * @since 2021-03-03 13:55:23
 */
public interface ComplaintService {

    /**
     * 通过ID查询单条数据
     *
     * @param complaintid 主键
     * @return 实例对象
     */
    Complaint queryById(Integer complaintid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    HashMap<String,Object> queryAllByLimit(int offset, int limit , String text);

    /**
     * 新增数据
     *
     * @param complaint 实例对象
     * @return 是否成功
     */
    boolean insert(Complaint complaint);

    /**
     * 修改数据
     *
     * @param complaint 实例对象
     * @return 是否成功
     */
    boolean update(Complaint complaint);

    /**
     * 通过主键删除数据
     *
     * @param complaintid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer complaintid);

}