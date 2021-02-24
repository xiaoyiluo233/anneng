package com.yidu.zsh.service.impl;

import com.yidu.entity.Product;
import com.yidu.zsh.dao.ProductDao;
import com.yidu.zsh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Product)表服务实现类
 *
 * @author makejava
 * @since 2021-01-05 15:47:47
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    @Override
    public Product queryById(Integer pid) {
        return this.productDao.queryById(pid);
    }

    @Override
    public List<Product> queryAllByLimit(int offset, int limit) {
        return null;
    }

    /**
     * 查询所有数据
     * @return 对象列表
     */
    @Override
    public List<Product> queryAll(Product product) {
        return this.productDao.queryAll(product);
    }

    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(Product product) {
       String result = "新增失败";
       int insert = productDao.insert(product);
       if (insert>0){
           result = "新增成功";
       }
       return result;
    }

    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public String update(Product product) {
        String result = "修改失败";
        int update = productDao.update(product);
       if (update>0){
           result = "修改成功";
       }
        return result;
    }

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 是否成功
     */
    @Override
    public String deleteById(String pid) {
        int result = 0;
        String[] split = pid.split(",");
        for (int i = 0; i < split.length; i++) {
            int deleteById = productDao.deleteById(Integer.parseInt(split[i]));
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