package com.yidu.lixiang.service;

import com.yidu.entity.Warerecord;

import java.util.HashMap;
import java.util.List;

/**
 * @description: 仓库记录表业务层
 * @author: lixiang
 * @date: 2021/3/11 18:29
 * @version 1.0
 */
public interface WarerecordService {

    /**
     * 连表查询出员工名、仓库名以及仓库记录表的基本数据
     * @return 数据集合
     */
    List<HashMap<String,Object>> getMainData();

    /**
     * 通过ID查询单条数据
     * @param wrid 主键
     * @return 实例对象
     */
    Warerecord queryById(Integer wrid);

    /**
     * 查询多条数据
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Warerecord> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     * @param warerecord 实例对象
     * @return 实例对象
     */
    Warerecord insert(Warerecord warerecord);

    /**
     * 修改数据
     * @param warerecord 实例对象
     * @return 实例对象
     */
    Warerecord update(Warerecord warerecord);

    /**
     * 通过主键删除数据
     * @param wrid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer wrid);

}