package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @description: 货车表实体类
 * @author: lixiang
 * @date: 2020-12-29 10:32:31
 * @version 1.0
 */
@Component
public class Trucks implements Serializable {
    private static final long serialVersionUID = 197312676171499692L;
    
    private Integer tid;
    
    private String tnumber;
    
    private Integer eid;
    
    private Integer parcelid;
    
    private Integer state;

    private Employee employee;

    @Override
    public String toString() {
        return "Trucks{" +
                "tid=" + tid +
                ", tnumber='" + tnumber + '\'' +
                ", eid=" + eid +
                ", parcelid=" + parcelid +
                ", state=" + state +
                '}';
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTnumber() {
        return tnumber;
    }

    public void setTnumber(String tnumber) {
        this.tnumber = tnumber;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getParcelid() {
        return parcelid;
    }

    public void setParcelid(Integer parcelid) {
        this.parcelid = parcelid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

}