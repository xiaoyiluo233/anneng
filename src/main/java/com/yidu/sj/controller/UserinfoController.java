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
 * 用户表控制层
 *
 * @author sj
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

    /**
     * 注册
     * @param request
     * @param userinfo
     * @param yzm
     * @return
     */
    @PostMapping("intoUserInfo")
    public String intoUserInfo(HttpServletRequest request,Userinfo userinfo,String yzm){
        return userinfoService.insert(request,userinfo,yzm);
    };

    /**
     * 登陆
     * @param request
     * @param userinfo
     * @param yzm
     * @return
     */
    @GetMapping("login")
    public String login(HttpServletRequest request,Userinfo userinfo,String yzm){
        return userinfoService.login(request,userinfo,yzm);
    };

    /**
     * 生成验证码
     * @param request
     * @param phone
     * @return
     */
    @PostMapping("createCode")
    public boolean createCode(HttpServletRequest request,String phone){
        return userinfoService.createCode(request,phone);
    };

    /**
     * 修改密码
     * @param request
     * @param userinfo
     * @param yzm
     * @return
     */
    @PostMapping("updateByName")
    public String updateByName(HttpServletRequest request,Userinfo userinfo,String yzm){
        return userinfoService.updateByName(request,userinfo,yzm);
    };
}