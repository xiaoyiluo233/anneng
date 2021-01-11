package com.yidu.sj.service.impl;

import com.yidu.sj.entity.Userinfo;
import com.yidu.sj.dao.UserinfoDao;
import com.yidu.sj.service.UserinfoService;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * (Userinfo)表服务实现类
 *
 * @author makejava
 * @since 2021-01-08 09:12:56
 */
@Service("userinfoService")
public class UserinfoServiceImpl implements UserinfoService {
    @Resource
    private UserinfoDao userinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    @Override
    public Userinfo queryById(Integer uid) {
        return this.userinfoDao.queryById(uid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Userinfo> queryAllByLimit(int offset, int limit) {
        return this.userinfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userinfo 实例对象
     * @return 实例对象
     */
    @Override
    public String insert(HttpServletRequest request,Userinfo userinfo,String yzm) {
        String code = String.valueOf(request.getSession().getAttribute("code"));
        if(code.equals(yzm)){
            int insert = this.userinfoDao.insert(userinfo);
            if (insert>0){
                return "注册成功";
            }
            return "注册失败";
        }
        return "验证码错误";
    }

    /**
     * 修改数据
     *
     * @param userinfo 实例对象
     * @return 实例对象
     */
    @Override
    public Userinfo update(Userinfo userinfo) {
        this.userinfoDao.update(userinfo);
        return this.queryById(userinfo.getUid());
    }

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer uid) {
        return this.userinfoDao.deleteById(uid) > 0;
    }

    @Override
    public boolean createCode(HttpServletRequest request,String phone) {
        Random r = new Random();
        String code = String.format("%04d",new Random().nextInt(9999));
        request.getSession().setAttribute("code",code);
        System.out.println("code = " + code);
        //注: 测试发送短信内容不要使用"你好"或"12132"全数字形式，这种短信内容没有具体的意义，可能会被运营商屏蔽
        ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com", "107784","b5c30305-ce4e-4d47-895f-d03584dc6a52");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("number", phone);
        params.put("templateId", "3173");
        String[] templateParams = new String[2];
        templateParams[0] = code;
        templateParams[1] = "有效时间为5分钟！";
        params.put("templateParams", templateParams);
        try {
            String result1 = client.send(params);
            String result2 = client.balance();
            System.out.println("result1 = " + result1);
            System.out.println("result2 = " + result2);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public String login(HttpServletRequest request,Userinfo userinfo,String yzm) {
        System.out.println("userinfo = " + userinfo);

        if(userinfo.getUpassword()==null){
            String code = String.valueOf(request.getSession().getAttribute("code"));
            if(!code.equals(yzm)){
                return "验证码错误";
            }
        }
        Userinfo login = userinfoDao.login(userinfo);
        System.out.println("login = " + login);
        if(login!=null){
            request.getSession().setAttribute("user",login);
            return "登录成功";
        }
        return "用户名或密码错误";
    }

    @Override
    public String updateByName(HttpServletRequest request,Userinfo userinfo,String yzm) {
        String code = String.valueOf(request.getSession().getAttribute("code"));
        Userinfo userinfo1 = userinfoDao.queryByName(userinfo.getUname());
        if(userinfo1==null){
            return "用户名不存在";
        }
        if(!code.equals(yzm)){
            return "验证码错误";
        }
        userinfoDao.updateByName(userinfo);
        return "修改成功";
    }

    @Override
    public Userinfo queryByName(String uname) {
        return userinfoDao.queryByName(uname);
    }
}