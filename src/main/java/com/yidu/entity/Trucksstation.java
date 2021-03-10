package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Trucksstation)实体类
 *
 * @author makejava
 * @since 2021-01-11 09:02:02
 */
@Component
public class Trucksstation implements Serializable {
    private static final long serialVersionUID = -36886481459817879L;
    
    private Integer tsid;
    
    private Integer tid;
    
    private Integer nowstation;
    
    private Integer nextstation;

    public Integer getTsid() {
        return tsid;
    }

    public void setTsid(Integer tsid) {
        this.tsid = tsid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getNowstation() {
        return nowstation;
    }

    public void setNowstation(Integer nowstation) {
        this.nowstation = nowstation;
    }

    public Integer getNextstation() {
        return nextstation;
    }

    public void setNextstation(Integer nextstation) {
        this.nextstation = nextstation;
    }

    @Override
    public String toString() {
        return "Trucksstation{" +
                "tsid=" + tsid +
                ", tid=" + tid +
                ", nowstation=" + nowstation +
                ", nextstation=" + nextstation +
                '}';
    }
}