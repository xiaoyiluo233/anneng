package com.yidu.lf.controller;

import com.yidu.lf.entity.Complaint;
import com.yidu.lf.service.ComplaintService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Complaint)表控制层
 *
 * @author makejava
 * @since 2021-03-03 13:55:23
 */
@RestController
@RequestMapping("complaint")
public class ComplaintController {
    /**
     * 服务对象
     */
    @Resource
    private ComplaintService complaintService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Complaint selectOne(Integer id) {
        return this.complaintService.queryById(id);
    }

}