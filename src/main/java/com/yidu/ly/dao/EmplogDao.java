package com.yidu.ly.dao;

import com.yidu.entity.Emplog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * (Emplog) 日志表持久层
 *
 * @author makejava
 * @since 2021-01-11 09:54:50
 */
@Mapper
@Repository
public interface EmplogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param elid 主键
     * @return 实例对象
     */
    Emplog queryById(Integer elid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param type 查询值
     * @return 对象列表
     */
    List<Emplog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit, @Param("type") Integer type);

    /**
     * 统计行数
     *
     * @return 影响行数
     */
    int count();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param emplog 实例对象
     * @return 对象列表
     */
    List<Emplog> queryAll(Emplog emplog);

    /**
     * 新增数据
     *
     * @param emplog 实例对象
     * @return 影响行数
     */
    int insert(Emplog emplog);

    /**
     * 修改数据
     *
     * @param emplog 实例对象
     * @return 影响行数
     */
    int update(Emplog emplog);

    /**
     * 修改数据
     *
     * @param eid 员工id
     * @return 影响行数
     */
    int updateEid(Integer eid);

    /**
     * 修改数据
     *
     * @param type 操作类型
     * @return 影响行数
     */
    int updateType(Integer type);

    /**
     * 根据操作类型删除
     * @param type 操作类型
     * @return 影响行数
     */
    int deleteType(Integer type);

    /**
     * 根据操作类型删除
     *
     * @param message 操作信息
     * @return 影响行数
     */
    int deleteMessage(Integer message);

    /**
     * 根据操作类型删除
     *
     * @param times 操作时间
     * @return 影响行数
     */
    int deleteTimes(Integer times);

    /**
     * 通过主键删除数据
     *
     * @param elid 主键
     * @return 影响行数
     */
    int deleteById(Integer elid);

    /**
     * 根据员工id删除数据
     *
     * @param eid 员工id
     * @return 影响行数
     */
    int deleteEid(Integer eid);

}