package com.yidu.lf.dao;

import com.yidu.lf.entity.Complaint;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Complaint)表数据库访问层
 *
 * @author makejava
 * @since 2021-03-03 13:55:23
 */
public interface ComplaintDao {

    /**
     * 通过ID查询单条数据
     *
     * @param complaintid 主键
     * @return 实例对象
     */
    Complaint queryById(Integer complaintid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Complaint> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param complaint 实例对象
     * @return 对象列表
     */
    List<Complaint> queryAll(Complaint complaint);

    /**
     * 新增数据
     *
     * @param complaint 实例对象
     * @return 影响行数
     */
    int insert(Complaint complaint);

    /**
     * 修改数据
     *
     * @param complaint 实例对象
     * @return 影响行数
     */
    int update(Complaint complaint);

    /**
     * 通过主键删除数据
     *
     * @param complaintid 主键
     * @return 影响行数
     */
    int deleteById(Integer complaintid);

}