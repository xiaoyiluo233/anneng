package com.yidu.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (District)实体类
 *
 * @author makejava
 * @since 2021-01-01 15:05:04
 */
@Data
@Component
public class District implements Serializable {
    private static final long serialVersionUID = -73864004805001601L;
    
    private Integer districtid;
    
    private Integer provinceid;
    
    private Integer cityid;
    
    private String districtname;


}