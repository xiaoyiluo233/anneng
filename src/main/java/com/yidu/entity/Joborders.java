package com.yidu.entity;

import java.io.Serializable;

/**
 * (Joborders)实体类
 *
 * @author makejava
 * @since 2020-12-30 14:21:14
 */
public class Joborders implements Serializable {
    private static final long serialVersionUID = 713240459834938011L;
    /**
    * 工单表id
    */
    private Integer jid;
    /**
    * 订单表id
    */
    private Integer oid;
    /**
    * 员工id（上一个负责的人）
    */
    private Integer upeid;
    /**
    * 员工id（现在负责的人）
    */
    private Integer noweid;
    /**
    * 接收工单的时间
    */
    private String times;
    /**
    * 状态 1-已完成   2-未完成
    */
    private Integer state;
    /**
    *  备注   未完成的原因
    */
    private String remark;

    @Override
    public String toString() {
        return "Joborders{" +
                "jid=" + jid +
                ", oid=" + oid +
                ", upeid=" + upeid +
                ", noweid=" + noweid +
                ", times='" + times + '\'' +
                ", state=" + state +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Integer getJid() {
        return jid;
    }

    public void setJid(Integer jid) {
        this.jid = jid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUpeid() {
        return upeid;
    }

    public void setUpeid(Integer upeid) {
        this.upeid = upeid;
    }

    public Integer getNoweid() {
        return noweid;
    }

    public void setNoweid(Integer noweid) {
        this.noweid = noweid;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}