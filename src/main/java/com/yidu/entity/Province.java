package com.yidu.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Province)实体类
 *
 * @author makejava
 * @since 2021-01-01 14:54:02
 */
@Data
@Component
public class Province implements Serializable {
    private static final long serialVersionUID = -66580543797394311L;
    
    private Integer provinceid;
    
    private String provincename;


    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }

}