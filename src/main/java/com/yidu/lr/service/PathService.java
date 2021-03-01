package com.yidu.lr.service;

import com.yidu.entity.Path;
import java.util.List;

/**
 * (Path)表服务接口
 *
 * @author makejava
 * @since 2021-01-11 10:12:32
 */
public interface PathService {

    /**
     * 通过ID查询单条数据
     *
     * @param pathid 主键
     * @return 实例对象
     */
    Path queryById(Integer pathid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Path> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param path 实例对象
     * @return 实例对象
     */
    Path insert(Path path);

    /**
     * 修改数据
     *
     * @param path 实例对象
     * @return 实例对象
     */
    Path update(Path path);

    /**
     * 通过主键删除数据
     *
     * @param pathid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer pathid);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param path 实例对象
     * @return 对象列表
     */
    List<Path> queryAll(Path path);

}