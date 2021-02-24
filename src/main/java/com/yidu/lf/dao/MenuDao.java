package com.yidu.lf.dao;

import com.yidu.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * (Menu)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-30 16:45:27
 */
@Repository
@Mapper
public interface MenuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param menuid 主键
     * @return 实例对象
     */
    Menu queryById(String menuid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数1
     * @return 对象列表
     */
    List<Menu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("text") String text);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param menu 实例对象
     * @return 对象列表
     */
    List<Menu> queryAll(Menu menu);

    /**
     * 新增数据
     *
     * @param menu 实例对象
     * @return 影响行数
     */
    int insert(Menu menu);

    /**
     * 修改数据
     *
     * @param menu 实例对象
     * @return 影响行数
     */
    int update(Menu menu);

    /**
     * 通过主键删除数据
     *
     * @param menuid 主键
     * @return 影响行数
     */
    int deleteById(String menuid);

    int count(@Param("text") String text);
}