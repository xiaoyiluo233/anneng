package com.yidu.ljj.controller;

import com.yidu.entity.Question;
import com.yidu.ljj.service.impl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * (Question)表控制层
 *
 * @author makejava
 * @since 2021-01-08 14:53:12
 */
@Controller
public class QuestionController {

    @Autowired
    QuestionServiceImpl service;

    @RequestMapping("/question_selectAll")
    @ResponseBody
    public HashMap<String,Object> selectAll(int offset, int pageNumber, String text){
       return service.queryAllByLimit(offset,pageNumber,text);
    }

    @RequestMapping(value = "/question_delete",produces = {("application/json;charset=utf-8")})
    @ResponseBody
    public String delete(int qid){
        return service.deleteById(qid);
    }

    @RequestMapping(value = "/question_update",produces = {("application/json;charset=utf-8")})
    @ResponseBody
    public String update(Question question){
        return service.update(question);
    }

    @RequestMapping(value = "/question_insert",produces = {("application/json;charset=utf-8")})
    @ResponseBody
    public String insert(Question question){
        return service.insert(question);
    }

}