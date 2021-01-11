package com.yidu.sj.dao;

import com.yidu.sj.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Userinfo)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-08 09:12:56
 */
@Mapper
public interface UserinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    Userinfo queryById(Integer uid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Userinfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userinfo 实例对象
     * @return 对象列表
     */
    List<Userinfo> queryAll(Userinfo userinfo);

    /**
     * 新增数据
     *
     * @param userinfo 实例对象
     * @return 影响行数
     */
    int insert(Userinfo userinfo);

    /**
     * 修改数据
     *
     * @param userinfo 实例对象
     * @return 影响行数
     */
    int update(Userinfo userinfo);

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 影响行数
     */
    int deleteById(Integer uid);

    /**
     * 根据用户名密码查询
     * @param userinfo
     * @return 对象
     */
    Userinfo login(Userinfo userinfo);

    /**
     * 根据用户名修改密码
     * @param userinfo
     * @return 影响行数
     */
    int updateByName(Userinfo userinfo);

    /**
     * 根据用户名查询
     * @param uname
     * @return 对象
     */
    Userinfo queryByName(String uname);
}