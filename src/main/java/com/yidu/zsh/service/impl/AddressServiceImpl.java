package com.yidu.zsh.service.impl;

import com.yidu.entity.Address;
import com.yidu.zsh.dao.AddressDao;
import com.yidu.zsh.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Address)表服务实现类
 *
 * @author makejava
 * @since 2020-12-31 14:21:02
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    /**
     * 通过ID查询单条数据
     *
     * @param aid 主键
     * @return 实例对象
     */
    @Override
    public Address queryById(Integer aid) {
        return this.addressDao.queryById(aid);
    }

    @Override
    public List<Address> queryAll(Address address) {
        return addressDao.queryAll(address);
    }



    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(Address address){
        String result = "新增失败";
        int insert = addressDao.insert(address);
        if (insert>0){
            result = "新增成功";
        }
        return result;
    }

    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    @Override
    public String update(Address address) {
        String result = "修改失败";
        int update = this.addressDao.update(address);
        if (update>0){
            result = "修改成功";
        }
        return result;
    }

    /**
     * 通过主键删除数据
     *
     * @param aid 主键
     * @return 是否成功
     */
    @Override
    public String  deleteById(String aid) {
        int result = 0;
        String[] split = aid.split(",");
        for (int i = 0; i < split.length; i++) {
            int deleteById = addressDao.deleteById(Integer.parseInt(split[i]));
            if (deleteById>0){
                result++;
            }
        }
        if (result==split.length){
            return "删除成功";
        } else {
            return "删除失败";
        }
    }
}