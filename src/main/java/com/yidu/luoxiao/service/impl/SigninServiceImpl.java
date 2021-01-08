package com.yidu.luoxiao.service.impl;

import com.yidu.entity.Signin;
import com.yidu.luoxiao.dao.SigninDao;
import com.yidu.luoxiao.service.SigninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Signin)表服务实现类
 *
 * @author makejava
 * @since 2021-01-06 11:00:33
 */
@Service
public class SigninServiceImpl implements SigninService {
    @Autowired
    private SigninDao signinDao;

    @Override
    public List<Signin> queryAll() {
        List<Signin> signins = signinDao.queryAll(null);
        return signins;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param signid 主键
     * @return 实例对象
     */
    @Override
    public Signin queryById(Integer signid) {
        return this.signinDao.queryById(signid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Signin> queryAllByLimit(int offset, int limit) {
        return this.signinDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param signin 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean insert(Signin signin) {
        int insert = this.signinDao.insert(signin);
        if(insert>0){
            return true;
        }
        return false;
    }

    /**
     * 修改数据
     *
     * @param signin 实例对象
     * @return 实例对象
     */
    @Override
    public Boolean update(Signin signin) {
        System.out.println("signin = " + signin);
        int update = this.signinDao.update(signin);
        if(update>0){
            return true;
        }
        return false;
    }

    /**
     * 通过主键删除数据
     *
     * @param signid 主键
     * @return 是否成功
     */
    @Override
    public Boolean deleteById(Integer signid) {
        return this.signinDao.deleteById(signid) > 0;
    }
}