package com.yidu.sj.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Userinfo)实体类
 *
 * @author makejava
 * @since 2021-01-08 09:12:56
 */
@Data
@Component
public class Userinfo implements Serializable {
    private static final long serialVersionUID = -84717993679019871L;
    
    private Integer uid;
    
    private String uname;
    
    private String uemail;
    
    private String upassword;
    
    private String companyname;
    
    private String usex;
    
    private String birthday;
    
    private String uaddress;
    
    private String imageUrl;

}