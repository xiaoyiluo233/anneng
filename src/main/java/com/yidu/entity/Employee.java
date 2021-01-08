package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Employee)实体类
 *
 * @author LvFang
 * @since 2020-12-30 08:54:30
 */
@Component
public class Employee implements Serializable {
    private static final long serialVersionUID = -18267939623190209L;
    
    private Integer eid;
    
    private String ename;
    
    private String epassword;
    
    private Integer eage;
    
    private String esex;
    
    private String ephone;
    
    private Integer districtid;
    
    private Integer state;


    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEpassword() {
        return epassword;
    }

    public void setEpassword(String epassword) {
        this.epassword = epassword;
    }

    public Integer getEage() {
        return eage;
    }

    public void setEage(Integer eage) {
        this.eage = eage;
    }

    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    public String getEphone() {
        return ephone;
    }

    public void setEphone(String ephone) {
        this.ephone = ephone;
    }

    public Integer getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Integer districtid) {
        this.districtid = districtid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", epassword='" + epassword + '\'' +
                ", eage=" + eage +
                ", esex='" + esex + '\'' +
                ", ephone='" + ephone + '\'' +
                ", districtid=" + districtid +
                ", state=" + state +
                '}';
    }
}