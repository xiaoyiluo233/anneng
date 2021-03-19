package com.yidu.tgh.dao;
import com.yidu.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
/**
 * @author 谭光辉
 * @version 1.0
 * @公司 一度教育
 * @since 2021-01-05 16:25:15
 */
@Repository
@Mapper
public interface GoodsDao {

    /**
     * 查询出所有物流信息
     * @param goods
     * @return 实例对象
     */
    List<Goods> selects(Goods goods);


    /**
     * 将得到的名字存入集合
     * @return 实例对象
     */

    List<HashMap<String,Object>> getNames();
    /**
     * 根据条件查询总行数
     * @return 总行数
     */
    int count(String tnumbers);
    /**
     * 通过ID查询单条数据
     *
     * @param taid 主键
     * @return 实例对象
     */
    Goods queryById(Integer taid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Goods> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit, @Param("tnumbers")String tnumbers);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param goods 实例对象
     * @return 对象列表
     */
    List<Goods> queryAll(Goods goods);

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 影响行数
     */
    int insert(Goods goods);
    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 影响行数
     */
    int inserts(Goods goods);


    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 影响行数
     */
    int update(Goods goods);
    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 影响行数
     */
    int updates(Goods goods);

    /**
     * 通过主键删除数据
     *
     * @param taid 主键
     * @return 影响行数
     */
    int deleteById(Integer taid);



}