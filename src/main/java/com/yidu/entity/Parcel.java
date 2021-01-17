package com.yidu.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * (Parcel)实体类
 *
 * @author makejava
 * @since 2021-01-01 17:39:15
 */
@Data
@Component
public class Parcel implements Serializable {
    private static final long serialVersionUID = -21304950205485714L;
    
    private Integer parcelid;
    
    private String oid;
    
    private Integer nextstation;
    
    private Integer upstation;

    private Integer state;

}