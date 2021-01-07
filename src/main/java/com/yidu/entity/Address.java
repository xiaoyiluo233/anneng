package com.yidu.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

/**
 * (Address)实体类
 *
 * @author makejava
 * @since 2021-01-01 15:07:21
 */
@Data
@Component
public class Address implements Serializable {
    private static final long serialVersionUID = -93134504017466077L;
    
    private Integer aid;
    
    private Integer districtid;
    
    private String avalue;
    
    private String phone;
    
    private Integer uid;
    
    private Integer atype;

}