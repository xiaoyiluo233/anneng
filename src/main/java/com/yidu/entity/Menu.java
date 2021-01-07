package com.yidu.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * (Menu)实体类
 *
 * @author makejava
 * @since 2020-12-30 16:45:27
 */
@Component
public class Menu implements Serializable {
    private static final long serialVersionUID = -84753789098732476L;
    
    private String menuid;
    
    private String title;
    
    private String url;
    
    private String levelid;
    
    private String iconcls;

    private List<Menu> childMenuList=new ArrayList<>();


    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLevelid() {
        return levelid;
    }

    public void setLevelid(String levelid) {
        this.levelid = levelid;
    }

    public String getIconcls() {
        return iconcls;
    }

    public void setIconcls(String iconcls) {
        this.iconcls = iconcls;
    }

    public List<Menu> getChildMenuList() {
        return childMenuList;
    }

    public void setChildMenuList(List<Menu> childList) {
        this.childMenuList = childList;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuid='" + menuid + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", levelid='" + levelid + '\'' +
                ", iconcls='" + iconcls + '\'' +
                ", childList=" + childMenuList +
                '}';
    }
}