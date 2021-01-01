package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Producttype)实体类
 *
 * @author makejava
 * @since 2020-12-29 15:19:19
 */
@Component
public class Producttype implements Serializable {
    private static final long serialVersionUID = 229097021266108573L;
    
    private Integer ptid;
    
    private String ptype;


    public Integer getPtid() {
        return ptid;
    }

    public void setPtid(Integer ptid) {
        this.ptid = ptid;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    @Override
    public String toString() {
        return "Producttype{" +
                "ptid=" + ptid +
                ", ptype='" + ptype + '\'' +
                '}';
    }
}