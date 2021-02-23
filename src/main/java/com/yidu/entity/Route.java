package com.yidu.entity;

import java.io.Serializable;

/**
 * (Route)实体类
 *
 * @author makejava
 * @since 2021-01-11 16:23:49
 */
public class Route implements Serializable {
    private static final long serialVersionUID = 854052405082731097L;
    
    private Integer routeid;
    
    private Integer tid;
    
    private Integer pathid;
    
    private String starttime;
    
    private String arrivetime;


    public Integer getRouteid() {
        return routeid;
    }

    public void setRouteid(Integer routeid) {
        this.routeid = routeid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getPathid() {
        return pathid;
    }

    public void setPathid(Integer pathid) {
        this.pathid = pathid;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getArrivetime() {
        return arrivetime;
    }

    public void setArrivetime(String arrivetime) {
        this.arrivetime = arrivetime;
    }

}