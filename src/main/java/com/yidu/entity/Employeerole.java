package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Employeerole)实体类
 *
 * @author makejava
 * @since 2020-12-30 16:43:51
 */
@Component
public class Employeerole implements Serializable {
    private static final long serialVersionUID = 771202327594113767L;
    
    private Integer erid;
    
    private Integer eid;
    
    private Integer roleid;


    public Integer getErid() {
        return erid;
    }

    public void setErid(Integer erid) {
        this.erid = erid;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "Employeerole{" +
                "erid=" + erid +
                ", eid=" + eid +
                ", roleid=" + roleid +
                '}';
    }
}