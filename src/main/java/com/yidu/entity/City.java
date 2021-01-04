package com.yidu.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
/**
 * @description: 市级表实体类
 * @author:lixiang
 * @date: 2020-12-30 14:00:15
 * @vesion:1.0
 */
@Data
@Component
public class City implements Serializable {
    private static final long serialVersionUID = 101549652111610251L;
    
    private Integer cityid;
    
    private Integer provinceid;
    
    private String cityname;

    private Province province;
}