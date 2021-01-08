package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Rolemenu)实体类
 *
 * @author makejava
 * @since 2020-12-30 16:44:45
 */
@Component
public class Rolemenu implements Serializable {
    private static final long serialVersionUID = -10144581766041663L;
    
    private Integer rmid;
    
    private Integer roleid;
    
    private String menuid;


    public Integer getRmid() {
        return rmid;
    }

    public void setRmid(Integer rmid) {
        this.rmid = rmid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    @Override
    public String toString() {
        return "Rolemenu{" +
                "rmid=" + rmid +
                ", roleid=" + roleid +
                ", menuid='" + menuid + '\'' +
                '}';
    }
}