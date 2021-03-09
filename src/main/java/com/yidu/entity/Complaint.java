package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Complaint)实体类
 *
 * @author makejava
 * @since 2021-03-03 13:58:48
 */
@Component
public class Complaint implements Serializable {
    private static final long serialVersionUID = 334144165412279573L;
    
    private Integer complaintid;
    
    private Integer questiontype;
    
    private Integer customertype;
    
    private Integer complaint;
    
    private String customername;
    
    private String phone;
    
    private String email;
    
    private String ordersid;
    
    private String content;

    private Integer state;


    public Integer getComplaintid() {
        return complaintid;
    }

    public void setComplaintid(Integer complaintid) {
        this.complaintid = complaintid;
    }

    public Integer getQuestiontype() {
        return questiontype;
    }

    public void setQuestiontype(Integer questiontype) {
        this.questiontype = questiontype;
    }

    public Integer getCustomertype() {
        return customertype;
    }

    public void setCustomertype(Integer customertype) {
        this.customertype = customertype;
    }

    public Integer getComplaint() {
        return complaint;
    }

    public void setComplaint(Integer complaint) {
        this.complaint = complaint;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrdersid() {
        return ordersid;
    }

    public void setOrdersid(String ordersid) {
        this.ordersid = ordersid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}