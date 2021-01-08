package com.yidu.sj.controller;

import com.yidu.sj.entity.Userinfo;
import com.yidu.sj.service.UserinfoService;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * (Userinfo)表控制层
 *
 * @author makejava
 * @since 2021-01-08 09:12:56
 */
@RestController
@RequestMapping("userinfo")
public class UserinfoController {
    /**
     * 服务对象
     */
    @Resource
    private UserinfoService userinfoService;

    @PostMapping("intoUserInfo")
    public String intoUserInfo(HttpServletRequest request,Userinfo userinfo,String yzm){
        System.out.println("userinfo = " + userinfo + ", yzm = " + yzm);
        return userinfoService.insert(request,userinfo,yzm);
    };

    @GetMapping("login")
    public String login(HttpServletRequest request,Userinfo userinfo,String yzm){
        return userinfoService.login(request,userinfo,yzm);
    };

    @PostMapping("createCode")
    public boolean createCode(HttpServletRequest request,String phone){
        return userinfoService.createCode(request,phone);
    };

    @PostMapping("updateByName")
    public String updateByName(HttpServletRequest request,Userinfo userinfo,String yzm){
        return userinfoService.updateByName(request,userinfo,yzm);
    };

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(Math.round((Math.random()+1) * 1000));
            System.out.println(new Random().nextInt(9999));
            System.out.println(String.format("%04d",new Random().nextInt(9999)));
        }

    }

}