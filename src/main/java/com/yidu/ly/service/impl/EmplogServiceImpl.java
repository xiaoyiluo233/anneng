package com.yidu.ly.service.impl;

import com.yidu.entity.Emplog;
import com.yidu.ly.dao.EmplogDao;
import com.yidu.ly.service.EmplogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * (Emplog) 员工表业务实现层
 *
 * @author makejava
 * @since 2021-01-11 09:54:50
 */
@Service
public class EmplogServiceImpl implements EmplogService {

    @Autowired
    private EmplogDao emplogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param elid 主键
     * @return 实例对象
     */
    @Override
    public Emplog queryById(Integer elid) {
        //返回调用根据id查询的数据
        return emplogDao.queryById(elid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param name 查询值
     * @return 对象列表
     */
    @Override
    public HashMap<String,Object> queryAllByLimit(int offset, int limit, Integer name) {
        //创建map集合
        HashMap<String,Object> map=new HashMap<>();
        //赋值集合调用分页查询
        map.put("rows",emplogDao.queryAllByLimit(offset, limit, name));
        //赋值总行数
        map.put("total",emplogDao.count());
        //返回集合
        return map;
    }

    /**
     * 新增数据
     *
     * @param emplog 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(Emplog emplog) {
        //申明结果集
        String one;
        //判断是否新增成功
        if (emplogDao.insert(emplog)>0){
            //则新增成功
            one="新增成功";
        }else {
            //则新增失败
            one="新增失败";
        }
        //返回结果
        return one;
    }

    /**
     * 删除数据
     *
     * @param eid 员工id
     * @return 是否成功
     */
    @Override
    public String deleteEid(Integer eid){
        //申明结果集
        String one;
        //判断是否删除成功
        if (emplogDao.deleteEid(eid)>0){
            //则删除成功
            one="删除成功";
        }else {
            //则删除失败
            one="删除失败";
        }
        //返回结果
        return one;
    }

    /**
     * 删除数据
     *
     * @param eid 员工id
     * @return 是否成功
     */
    @Override
    public String updateEid(Integer eid){
        //申明结果集
        String one;
        //判断是否修改成功
        if (emplogDao.updateEid(eid)>0){
            //则修改成功
            one="修改成功";
        }else {
            //则修改失败
            one="修改失败";
        }
        //返回结果
        return one;
    }

    /**
     * 修改数据
     *
     * @param type 操作类型
     * @return
     */
    @Override
    public String updateType(Integer type) {
        //申明结果集
        String one;
        //判断是否修改成功
        if (emplogDao.deleteEid(type)>0){
            //则修改成功
            one="修改成功";
        }else {
            //则修改失败
            one="修改失败";
        }
        //返回结果
        return one;
    }

    /**
     * 删除数据
     *
     * @param type 操作类型
     * @return 是否成功
     */
    @Override
    public String deleteType(Integer type){
        //申明结果集
        String one;
        //判断是否删除成功
        if (emplogDao.deleteEid(type)>0){
            //则删除成功
            one="删除成功";
        }else {
            //则删除失败
            one="删除失败";
        }
        //返回结果
        return one;
    }

    /**
     * 删除数据
     *
     * @param message 操作信息
     * @return 是否成功
     */
    @Override
    public String deleteMessage(Integer message){
        //申明结果集
        String one;
        //判断是否删除成功
        if (emplogDao.deleteEid(message)>0){
            //则删除成功
            one="删除成功";
        }else {
            //则删除失败
            one="删除失败";
        }
        //返回结果
        return one;
    }

    /**
     * 删除数据
     *
     * @param times 操作时间
     * @return 是否成功
     */
    @Override
    public String deleteTimes(Integer times){
        //申明结果集
        String one;
        //判断是否删除成功
        if (emplogDao.deleteEid(times)>0){
            //则删除成功
            one="删除成功";
        }else {
            //则删除失败
            one="删除失败";
        }
        //返回结果
        return one;
    }

    /**
     * 修改数据
     *
     * @param emplog 实例对象
     * @return 实例对象
     */
    @Override
    public String update(Emplog emplog) {
        //申明结果集
        String one;
        //判断是否修改成功
        if (emplogDao.update(emplog)>0){
            //则修改成功
            one="修改成功";
        }else {
            //则修改失败
            one="修改失败";
        }
        //返回结果
        return one;
    }

    /**
     * 通过主键删除数据
     *
     * @param elid 主键
     * @return 是否成功
     */
    @Override
    public String deleteById(Integer elid) {
        //申明结果集
        String one;
        //判断是否删除成功
        if (emplogDao.deleteById(elid)>0){
            //则删除成功
            one="删除成功";
        }else {
            //则删除失败
            one="删除成功";
        }
        //返回结果
        return one;
    }

}