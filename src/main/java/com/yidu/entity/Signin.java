package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Signin)实体类
 *
 * @author makejava
 * @since 2020-12-30 14:21:30
 */
@Component
public class Signin implements Serializable {
    private static final long serialVersionUID = 896965088216587238L;
    /**
    * 快递签收表id
    */
    private Integer signid;
    /**
    * 签收时间
    */
    private String times;
    /**
    * 员工id
    */
    private String eid;
    /**
    * 签收方式
    */
    private String type;
    /**
    * 签收人
    */
    private String person;
    /**
    * 订单id
    */
    private String oid;
    /**
    * 签收情况
    */
    private String condition;

    @Override
    public String toString() {
        return "Signin{" +
                "signid=" + signid +
                ", times='" + times + '\'' +
                ", eid='" + eid + '\'' +
                ", type='" + type + '\'' +
                ", person='" + person + '\'' +
                ", oid='" + oid + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }

    public Integer getSignid() {
        return signid;
    }

    public void setSignid(Integer signid) {
        this.signid = signid;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

}