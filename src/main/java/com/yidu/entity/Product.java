package com.yidu.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Product)实体类
 *
 * @author makejava
 * @since 2021-01-01 16:52:46
 */
@Data
@Component
public class Product implements Serializable {
    private static final long serialVersionUID = 250365025763754887L;
    
    private Integer pid;
    
    private String pvalue;
    
    private Integer uid;
    
    private Integer ptid;
    
    private Integer pwid;
    
    private Integer myaid;
    
    private Integer youaid;
    
    private String times;
    
    private double weight;
    
    private Integer state;
}