package com.yidu.lf.controller;

import com.yidu.entity.Complaint;
import com.yidu.entity.Employee;
import com.yidu.lf.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * (Complaint)表控制层
 *
 * @author makejava
 * @since 2021-03-03 13:55:23
 */
@Controller
public class ComplaintController {
    /**
     * 服务对象
     */
    @Autowired
    private ComplaintService complaintService;

    /**
     * 查询所有投诉信息
     * @param offset 开始值
     * @param pageNumber 查询个数
     * @param text 查询文本
     * @return 所有投诉信息
     */
    @RequestMapping("/complaint_selectAll")
    @ResponseBody
    public HashMap<String,Object> selectAll(int offset, int pageNumber, String text){
        return this.complaintService.queryAllByLimit(offset,pageNumber,text);
    }

    /**
     * 修改投诉信息
     * @param complaint 投诉信息对象
     * @return 修改结果
     */
    @ResponseBody
    @RequestMapping("/complaint_update")
    public String update(Complaint complaint){
        //修改员工并接收返回值
        boolean update = this.complaintService.update(complaint);
        //判断修改是否成功
        if (update){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

    /**
     * 新增投诉信息
     * @param complaint 投诉信息对象
     * @return 新增结果
     */
    @ResponseBody
    @RequestMapping("/complaint_insert")
    public String insert(Complaint complaint){
        //新增员工并接收返回值
        boolean insert = this.complaintService.insert(complaint);
        //判断新增是否成功
        if (insert){
            return "新增成功";
        }else{
            return "新增失败";
        }
    }

    /**
     * 根据投诉id删除投诉信息
     * @param complaintid 员工id
     * @return 返回删除结果
     */
    @ResponseBody
    @RequestMapping("/complaint_delete")
    public String delete(String complaintid){
        //将员工id切割
        String[] split = complaintid.split(",");
        //删除结果
        boolean result=true;
        //遍历切割后的员工id
        for (String id : split) {
            //根据员工id删除菜单并接收返回值
            boolean insert = this.complaintService.deleteById(Integer.parseInt(id));
            //判断删除是否不成功
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

}