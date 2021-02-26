package com.yidu.ljj.service;

import com.yidu.entity.Question;

import java.util.HashMap;

/**
 * (Question)表服务接口
 *
 * @author makejava
 * @since 2021-01-08 14:53:12
 */
public interface QuestionService {

    /**
     * 通过ID查询单条数据
     *
     * @param qid 主键
     * @return 实例对象
     */
    Question queryById(Integer qid );

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    HashMap<String,Object> queryAllByLimit(int offset, int limit,String text);

    /**
     * 新增数据
     *
     * @param question 实例对象
     * @return 实例对象
     */
    String insert(Question question);

    /**
     * 修改数据
     *
     * @param question 实例对象
     * @return 实例对象
     */
    String update(Question question);

    /**
     * 通过主键删除数据
     *
     * @param qid 主键
     * @return 是否成功
     */
    String deleteById(Integer qid );

}