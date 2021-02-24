package com.yidu.lr.controller;

import com.yidu.entity.Path;
import com.yidu.lr.service.PathService;
import com.yidu.lr.service.impl.LRPathServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Path)表控制层
 *
 * @author makejava
 * @since 2021-01-11 10:12:32
 */
@RestController
@RequestMapping("path")
public class PathController {
    /**
     * 服务对象
     */
    @Autowired
    private LRPathServiceImpl pathService;

    /**
     * 查询所有
     * @return 对象列表
     */
    @GetMapping("selectAll")
    public List<Path> selectAll() {
        return this.pathService.queryAll(null);
    }

}