package com.yidu.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Path)实体类
 *
 * @author makejava
 * @since 2021-01-01 14:54:48
 */
@Data
@Component
public class Path implements Serializable {
    private static final long serialVersionUID = 190657077210404864L;
    
    private Integer pathid;
    
    private String start;
    
    private String halfway;
    
    private String destination;
}