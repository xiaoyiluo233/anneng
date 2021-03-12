package com.yidu.tgh.controller;
import com.yidu.entity.Goods;
import com.yidu.tgh.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author 谭光辉
 * @version 1.0
 * @公司 一度教育
 * @date 2021-01-05 16:25:16
 */
@Controller
public class GoodsController {
    /**
     * 服务对象
     */
    @Autowired
    private GoodsServiceImpl goodsService;

    /**
     * 查询所有物流信息
     * @return getNames
     */
    @RequestMapping("goods_getNames")
    @ResponseBody
    public List<HashMap<String, Object>> getNames(){
         return goodsService.getNames();
    }

    /**
     * 得到仓库id
     * @return getWids
     */
    @RequestMapping("goods_getWids")
    @ResponseBody
    public int[] getWids(){
        //返回仓库id
        return goodsService.getWids();
    }

    /**
     * 得到所有仓库名
     * @return getWnames
     */
    @RequestMapping("goods_getWnames")
    @ResponseBody
    public String[] getWnames(){
        //返回仓库名
        return goodsService.getWnames();
    }
    /**
     * 查询所有物流
     *
     * @param goods 物流
     * @return 实例对象
     */

    @RequestMapping("/selects")
    public ModelAndView select(Goods goods) {
        //创建一个对象
        ModelAndView mv=new ModelAndView();
        //从Service调用查询存入集合
        List<Goods> goodsList=goodsService.selects(goods);
        //得到集合
        mv.addObject("goodsList",goodsList);
        //设置跳转地址
        mv.setViewName("chaxun/tailAfter");
        //返回mv
        return mv;
    }

    /**
     * 新增物流
     * @param goods
     * @return mv
     */
    @RequestMapping("inserts")
    public ModelAndView inserts(Goods goods){
        //创建一个对象
        ModelAndView mv = new ModelAndView();
        //调用新增
        goodsService.insert(goods);
        //跳转地址
        mv.setViewName("/select");
        //返回mv
        return mv;
    }

    @RequestMapping("/updates")
    public ModelAndView updates(Goods goods) {
        //创建一个对象
        ModelAndView mv = new ModelAndView();
        //调用修改
        goodsService.update(goods);
        //跳转地址
        mv.setViewName("/select");
        //返回mv
        return mv;
    }

    /**
     * 通过主键删除单条数据
     *
     * @param taids 主键
     * @return 单条数据
     */

    @RequestMapping(value = "goods_delete",produces={("application/json;charset-utf-8")})
    @ResponseBody
    public String delete(String taids) {
        //调用删除的方法
        String deleteById=goodsService.deleteById(taids);
        return deleteById;

    }


    /**
     * 修改
     * @param goods
     * @return update
     */
    @RequestMapping(value = "goods_update",produces={("application/json;charset-utf-8")})
    @ResponseBody
    public String update(Goods goods){
        //调用修改的方法
        String update=goodsService.update(goods);
        //返回修改
        return update;
    }

    /**
     * 新增
     * @param goods
     * @return insert;
     */

    @RequestMapping(value = "goods_insert")
    @ResponseBody
    public String insert(Goods goods){
        //调用新增的方法
        String insert=goodsService.insert(goods);
        //返回新增
        return insert;
    }

    /**
     * 查询所有物流信息
     * @param offset
     * @param pageNumber
     * @param tnumbers
     * @return
     */
    @RequestMapping("goods_queryAll")
    @ResponseBody
    public  HashMap<String, Object> queryAllByLimit(Integer offset, Integer pageNumber, String tnumbers){
        return goodsService.queryAllByLimit(offset,pageNumber,tnumbers);

    }

    /**
     * 查询单条物流信息
     * @param taid
     * @return taid
     */
    @RequestMapping("goods_selectOne")
    @ResponseBody
    public Goods selectOne(Integer taid) {
        return this.goodsService.queryById(taid);
    }

}