package com.yidu.zsh.controller;

import com.yidu.entity.Address;
import com.yidu.zsh.service.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * (Address)表控制层
 *
 * @author makejava
 * @since 2020-12-31 14:21:03
 */
@Controller
public class AddressController {

    /**
     * 服务对象
     */
    @Autowired
    private AddressServiceImpl addressService;

    /**
     *  查询
     * @return
     */
    @ResponseBody
    @RequestMapping("address_queryAll")
    public List<Address> queryAllByLimit(Address address){
        return addressService.queryAll(address);
    }

    /**
     *
     * @param aid
     * @return
     */
    @ResponseBody
    @RequestMapping("address_selectOne")
    public Address selectOne(Integer aid){
        return addressService.queryById(aid);
    }

    /**
     * 新增数据
     * @param address
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "address_insert",produces = {("application/json;charset=utf-8")})
    public String insert(Address address){
        address.setUid(1);
        String insert = addressService.insert(address);
        return insert;
    }

    /**
     * 修改数据
     * @param address
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "address_update",produces = {("application/json;charset=utf-8")})
    public String update(Address address){
        String update = addressService.update(address);
        return update;
    }

    /**
     *  删除数据
     * @param aid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "address_delete",produces = {("application/json;charset=utf-8")})
    public String deleteById(String aid){
        String deleteById = addressService.deleteById(aid);
        return deleteById;
    }

}