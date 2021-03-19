package com.yidu.sj.controller;

import com.yidu.sj.entity.Userinfo;
import com.yidu.sj.service.UserinfoService;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
    @Autowired
    private UserinfoService userinfoService;

    /**
     * 注册
     *
     * @param request
     * @param userinfo
     * @param yzm
     * @return
     */
    @PostMapping("intoUserInfo")
    public String intoUserInfo(HttpServletRequest request, Userinfo userinfo, String yzm) {
        return userinfoService.register(request, userinfo, yzm);
    }

    

    /**
     * 登陆
     *
     * @param request
     * @param userinfo
     * @param yzm
     * @return
     */
    @GetMapping("login")
    public String login(HttpServletRequest request, Userinfo userinfo, String yzm) {
        return userinfoService.login(request, userinfo, yzm);
    }

    ;

    /**
     * 生成验证码
     *
     * @param request
     * @param phone
     * @return
     */
    @PostMapping("createCode")
    public boolean createCode(HttpServletRequest request, String phone) {
        return userinfoService.createCode(request, phone);
    }

    ;

    /**
     * 修改密码
     *
     * @param request
     * @param userinfo
     * @param yzm
     * @return
     */
    @PostMapping("updateByName")
    public String updateByName(HttpServletRequest request, Userinfo userinfo, String yzm) {
        return userinfoService.updateByName(request, userinfo, yzm);
    }



    @RequestMapping("selectAll")
    public List<Userinfo> selectALl() {
         return userinfoService.queryAll(null);
    }
    @RequestMapping("update")
    public boolean update(HttpServletRequest request, MultipartFile file, Userinfo userinfo) {
        Map<String, String> modelMap = new HashMap<>();
        //得到当前项目地址
        String path=request.getServletContext().getRealPath("/");
        File filePath = new File(path + "/myFile");
        //判断指定地址是否存在
        if(!filePath.exists()){
            filePath.mkdir();
            System.out.println("创建文件夹地址:"+filePath.getAbsolutePath());
        }
        //将文件移动到指定的页面
        String name = file.getOriginalFilename();
        System.out.println("filename = " + name);
        File file1 = new File(filePath, name);
        try {
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("上传的地址是:"+file1.getAbsolutePath());
        userinfo.setImageUrl(name);
        userinfoService.update(userinfo);
        return true;
    }


    @RequestMapping("insert")
    public boolean insert(HttpServletRequest request, MultipartFile file, Userinfo userinfo) {
        Map<String, String> modelMap = new HashMap<>();
        //得到当前项目地址
        String path=request.getServletContext().getRealPath("/");
        File filePath = new File(path + "/myFile");
        //判断指定地址是否存在
        if(!filePath.exists()){
            filePath.mkdir();
            System.out.println("创建文件夹地址:"+filePath.getAbsolutePath());
        }
        //将文件移动到指定的页面
        String name = file.getOriginalFilename();
        System.out.println("filename = " + name);
        File file1 = new File(filePath, name);
        try {
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("上传的地址是:"+file1.getAbsolutePath());
        userinfo.setImageUrl(name);
        userinfoService.insert(userinfo);
        return true;
    }

    @RequestMapping("delete")
    public boolean delete(String id){
        userinfoService.deleteById(id);
        return true;
    }

}