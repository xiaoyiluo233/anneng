package com.yidu.sj.service;

import com.yidu.sj.entity.Userinfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户表服务接口
 *
 * @author makejava
 * @since 2021-01-08 09:12:56
 */
public interface UserinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    Userinfo queryById(Integer uid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Userinfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userinfo 实例对象
     * @return 实例对象
     */
    String insert(HttpServletRequest request,Userinfo userinfo,String yzm);

    /**
     * 修改数据
     *
     * @param userinfo 实例对象
     * @return 实例对象
     */
    Userinfo update(Userinfo userinfo);

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer uid);

    /**
     * 创建验证码
     * @param request
     * @param phone
     * @return
     */
    boolean createCode(HttpServletRequest request, String phone);

    /**
     * 根据用户名密码查询
     * @param userinfo
     * @return boolean
     */
    String login(HttpServletRequest request,Userinfo userinfo,String yzm);

    /**
     * 根据用户名修改密码
     * @param userinfo
     * @return 影响行数
     */
    String updateByName(HttpServletRequest request,Userinfo userinfo,String yzm);

    /**
     * 根据用户名查询
     * @param uname
     * @return 对象
     */
    Userinfo queryByName(String uname);

    /**
     * 通过实体作为筛选条件查询
     * @param userinfo
     * @return
     */
    List<Userinfo> queryAll(Userinfo userinfo);
}