package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Orders)实体类
 *
 * @author makejava
 * @since 2021-01-06 08:35:59
 */
@Component
public class Orders implements Serializable {
    private static final long serialVersionUID = 354443239816182494L;
    
    private Integer oid;
    
    private Integer pid;
    
    private Integer priceid;
    
    private Integer shipping;
    
    private String barcode;
    
    private Integer payment;
    private Integer conditions;

    private Prices prices;
    private Product product;

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getConditions() {
        return conditions;
    }

    public void setConditions(Integer conditions) {
        this.conditions = conditions;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPriceid() {
        return priceid;
    }

    public void setPriceid(Integer priceid) {
        this.priceid = priceid;
    }

    public Integer getShipping() {
        return shipping;
    }

    public void setShipping(Integer shipping) {
        this.shipping = shipping;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

}