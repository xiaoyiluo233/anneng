package com.yidu.ljj.controller;

import com.yidu.entity.Prices;
import com.yidu.ljj.service.PricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * (Prices)表控制层
 *
 * @author makejava
 * @since 2021-01-08 16:27:06
 */
@Controller
public class PricesController {

    @Autowired
    PricesService pricesService;

    @RequestMapping("/prices_update")
    @ResponseBody
    public String update(Prices prices){
        return pricesService.update(prices);
    }

    @RequestMapping("/prices_insert")
    @ResponseBody
    public String insert(Prices prices){
        return pricesService.insert(prices);
    }

    @RequestMapping("/prices_delete")
    @ResponseBody
    public String delete(int id){
        return pricesService.deleteById(id);
    }

    @RequestMapping("/prices_selectAll")
    @ResponseBody
    public HashMap<String,Object> selectAll(int offset, int pageNumber, String text){
        return pricesService.queryAllByLimit(offset,pageNumber,text);
    }

}