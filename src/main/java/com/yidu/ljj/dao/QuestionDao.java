package com.yidu.ljj.dao;


import com.yidu.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Question)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-08 14:53:12
 */
@Mapper
@Repository
public interface QuestionDao {

    /**
     * 根据条件统计行数
     *
     * @param text 条件
     * @return 总行数
     */
    int count(String text);

    /**
     * 通过ID查询单条数据
     *
     * @param qid 主键
     * @return 实例对象
     */
    Question queryById(Integer qid );

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Question> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit,@Param("text")String text);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param question 实例对象
     * @return 对象列表
     */
    List<Question> queryAll(Question question);

    /**
     * 新增数据
     *
     * @param question 实例对象
     * @return 影响行数
     */
    int insert(Question question);

    /**
     * 修改数据
     *
     * @param question 实例对象
     * @return 影响行数
     */
    int update(Question question);

    /**
     * 通过主键删除数据
     *
     * @param qid 主键
     * @return 影响行数
     */
    int deleteById(Integer qid );

}