package com.yidu.zsh.dao;

import com.yidu.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Address)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-31 14:21:01
 */
@Mapper
@Repository
public interface AddressDao {
    /**
     * 根据条件查询总行数
     * @return 总行数
     */
    int count(String address);

    /**
     * 通过ID查询单条数据
     *
     * @param aid 主键
     * @return 实例对象
     */
    Address queryById(Integer aid);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param address 实例对象
     * @return 对象列表
     */
    List<Address> queryAll(Address address);

    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 影响行数
     */
    int insert(Address address);

    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 影响行数
     */
    int update(Address address);

    /**
     * 通过主键删除数据
     *
     * @param aid 主键
     * @return 影响行数
     */
    int deleteById(Integer aid);

}