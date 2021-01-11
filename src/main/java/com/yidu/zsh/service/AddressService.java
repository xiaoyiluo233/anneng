package com.yidu.zsh.service;

import com.yidu.entity.Address;

import java.util.List;

/**
 * (Address)表服务接口
 *
 * @author makejava
 * @since 2020-12-31 14:21:02
 */
public interface AddressService {

    /**
     * 通过ID查询单条数据
     *
     * @param aid 主键
     * @return 实例对象
     */
    Address queryById(Integer aid);

    /**
     *  查询所有
     * @param address 地址实体类
     * @return
     */
    List<Address> queryAll(Address address);


    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    String insert(Address address);

    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    String update(Address address);

    /**
     * 通过主键删除数据
     *
     * @param aid 主键
     * @return 是否成功
     */
    String deleteById(String aid);

}