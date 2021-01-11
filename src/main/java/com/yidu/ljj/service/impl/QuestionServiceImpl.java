package com.yidu.ljj.service.impl;

import com.yidu.entity.Question;
import com.yidu.ljj.dao.QuestionDao;
import com.yidu.ljj.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * (Question)表服务实现类
 *
 * @author makejava
 * @since 2021-01-08 14:53:12
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionDao questionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param qid 主键
     * @return 实例对象
     */
    @Override
    public Question queryById(Integer qid ) {
        return this.questionDao.queryById(qid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public HashMap<String,Object> queryAllByLimit(int offset, int limit,String text) {
        HashMap<String,Object> map=new HashMap<>();
        map.put("rows",questionDao.queryAllByLimit(offset, limit,text));
        map.put("total",questionDao.count(text));
        return map;
    }

    /**
     * 新增数据
     *
     * @param question 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(Question question) {
        int insert = this.questionDao.insert(question);
        if(insert>0){
            return "新增成功！";
        }
        return "新增失败";
    }

    /**
     * 修改数据
     *
     * @param question 实例对象
     * @return 实例对象
     */
    @Override
    public String update(Question question) {
        int update = this.questionDao.update(question);
        if(update>0){
            return "修改成功！";
        }
        return "修改失败";
    }

    /**
     * 通过主键删除数据
     *
     * @param qid 主键
     * @return 是否成功
     */
    @Override
    public String deleteById(Integer qid ) {
        int delete = questionDao.deleteById(qid);
        if(delete>0){
            return "删除成功！";
        }
        return "删除失败";
    }
}