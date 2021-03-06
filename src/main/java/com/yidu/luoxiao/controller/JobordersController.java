package com.yidu.luoxiao.controller;

import com.yidu.entity.Joborders;
import com.yidu.luoxiao.service.JobordersService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Joborders)表控制层
 *
 * @author makejava
 * @since 2020-12-30 14:21:15
 */
@Controller
public class JobordersController {
    /**
     * 服务对象
     */
    @Resource
    private JobordersService jobordersService;

    @RequestMapping("joborders_querAll")
    @ResponseBody
    List<Joborders> queryAll(){
        return jobordersService.querAll();
    }


    /**
     * 修改
     * @param joborders
     * @return
     */
    @RequestMapping("joborders_update")
    @ResponseBody
    public  Boolean update(Joborders joborders){
        Boolean update = jobordersService.update(joborders);
        return  update;
    }

    /**
     * 删除单个
     * @param jid
     * @return
     */
    @ResponseBody
    @RequestMapping("joborders_delete")
    public Boolean delete(Integer jid){
        Boolean delete = jobordersService.deleteById(jid);
        return  delete;
    }

    /**
     * 删除多个
     * @param jid
     * @return
     */
    @ResponseBody
    @RequestMapping("joborders_deletes")
    public String deletes(String jid){
        //将员工id切割
        String[] split = jid.split(",");
        //删除结果
        boolean result=true;
        //切割后的员工id
        for (String id:
             split) {
            //根据员工id删除菜单并接受返回值
            boolean insert = this.jobordersService.deleteById(Integer.parseInt(id));
            //判断是否成功
            if (!insert){
                //删除结果改为假
                result=false;
                //结束循环
                break;
            }
        }
        //判断删除结果是否成功
        if (result){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }

    /**
     * 新增增加
     * @param joborders
     * @return
     */
    @ResponseBody
    @RequestMapping("joborders_insert")
    public Boolean insert(Joborders joborders){
        Boolean insert = jobordersService.insert(joborders);
        return insert;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("joborders_selectOne")
    public Joborders selectOne(Integer id) {
        return this.jobordersService.queryById(id);
    }

}