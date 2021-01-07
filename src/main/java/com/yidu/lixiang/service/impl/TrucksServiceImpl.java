package com.yidu.lixiang.service.impl;

import com.yidu.entity.Employee;
import com.yidu.entity.Trucks;
import com.yidu.lf.dao.EmployeeDao;
import com.yidu.lixiang.dao.TrucksDao;
import com.yidu.lixiang.service.TrucksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @description: 车辆表业务接口层
 * @author: lixiang
 * @date: 2020/12/30 15:08
 * @version 1.0
 */
@Service
public class TrucksServiceImpl implements TrucksService {
    @Autowired
    private TrucksDao trucksDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public String[] getEnameByRoleId(int roleid) {
        //根据角色id查出员工信息
        List<Employee> employees = employeeDao.selectEmpByRoleId(roleid);
        //创建姓名数组，长度为员工集合的长度
        String[] enames=new String[employees.size()];
        //循环员工集合
        for (int i = 0; i < employees.size(); i++) {
            //取出员工实体类
            Employee employee = employees.get(i);
            //得到员工姓名
            String ename = employee.getEname();
            //将员工姓名添加进数组
            enames[i]=ename;
        }
        //返回员工姓名数组
        return enames;
    }

    /**
     * 查询所有货车
     * @param trucks 货车实体
     * @return 货车集合
     */
    @Override
    public HashMap<String,Object> queryAll(Trucks trucks) {
        //创建map集合
        HashMap<String,Object> map=new HashMap<>();
        //添加行数据
        map.put("rows",trucksDao.queryAll(trucks));
        //添加总行数
        map.put("total",trucksDao.count(null));
        //返回map集合
        return map;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    @Override
    public Trucks queryById(Integer tid) {
        return this.trucksDao.queryById(tid);
    }

    /**
     * 分页查询多条数据
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public HashMap<String,Object> queryAllByLimit(Integer offset, Integer limit,String tnumbers) {
        //创建map集合
        HashMap<String,Object> map=new HashMap<>();
        //添加行数据
        map.put("rows",trucksDao.getEmployeeName(offset, limit, tnumbers));
        //添加总行数
        map.put("total",trucksDao.count(tnumbers));
        //返回map集合
        return map;
    }

    /**
     * 新增数据
     *
     * @param trucks 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(Trucks trucks) {
        //申明变量用于返回值
        String result="添加失败！";
        //设置车辆状态
        trucks.setState(0);
        //新增车辆
        int insert = this.trucksDao.insert(trucks);
        //判断是否新增成功
        if (insert>0){
            result="添加成功！";
        }
        return result;
    }

    /**
     * 修改数据
     *
     * @param trucks 实例对象
     * @return 实例对象
     */
    @Override
    public String update(Trucks trucks) {
        //申明变量用于返回值
        String result="修改失败！";
        //新增车辆
        int update = this.trucksDao.update(trucks);
        //判断是否新增成功
        if (update>0){
            result="修改成功！";
        }
        return result;
    }

    /**
     * 通过主键删除数据
     * @param tids id
     * @return 是否成功
     */
    @Override
    public String deleteById(String tids) {
        //申明变量用于返回值
        int result=0;
        //根据,截取id
        String[] split = tids.split(",");
        //循环出所有的id
        for (int i = 0; i < split.length; i++) {
            //调用删除的方法
            int deleteById = trucksDao.deleteById(Integer.parseInt(split[i]));
            if (deleteById>0){
                result++;
            }
        }
        //判断是否删除成功
        if (result==split.length){
            return "删除成功！";
        }else {
            return "删除失败！";
        }
    }
}