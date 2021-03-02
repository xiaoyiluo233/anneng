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
 * 用户表服务实现类
 *
 * @author sj
 * @since 2021-01-08 09:12:56
 */
@Service("userinfoService")
public class UserinfoServiceImpl implements UserinfoService {
    /**
     * 用户表接口
     */
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
        //调用修改方法
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

    /**
     * 生成验证码
     * @param request
     * @param phone
     * @return
     */
    @Override
    public boolean createCode(HttpServletRequest request,String phone) {
        //随机数对象
        Random r = new Random();
        //生成验证码
        String code = String.format("%04d",new Random().nextInt(9999));
        //保存到session
        request.getSession().setAttribute("code",code);
        //注: 测试发送短信内容不要使用"你好"或"12132"全数字形式，这种短信内容没有具体的意义，可能会被运营商屏蔽
        //验证码api地址和id密钥
        ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com", "107784","b5c30305-ce4e-4d47-895f-d03584dc6a52");
        //创建map集合
        Map<String, Object> params = new HashMap<String, Object>();
        //保存电话号码到map
        params.put("number", phone);
        //保存平台应用id到map
        params.put("templateId", "3173");
        //创建短信信息数组
        String[] templateParams = new String[2];
        //验证码信息
        templateParams[0] = code;
        //保存提示信息到map
        templateParams[1] = "有效时间为5分钟！";
        //保存信息数组到map
        params.put("templateParams", templateParams);
        try {
            //发送短信
            String result1 = client.send(params);
            //查询短信剩余次数
            String result2 = client.balance();
        } catch (Exception e) {
            //发送失败时返回false
            return false;
        }
        //发送成功时返回true
        return true;
    }

    /**
     * 登录
     * @param request
     * @param userinfo
     * @param yzm
     * @return
     */
    @Override
    public String login(HttpServletRequest request,Userinfo userinfo,String yzm) {
        //判断是否有密码
        if(userinfo.getUpassword()==null){
            //从session中取出验证码
            String code = String.valueOf(request.getSession().getAttribute("code"));
            //验证码错误
            if(!code.equals(yzm)){
                //返回错误信息
                return "验证码错误";
            }
        }
        //调用登录方法
        Userinfo login = userinfoDao.login(userinfo);
        //判断用户信息是否空
        if(login!=null){
            //用户信息存入session
            request.getSession().setAttribute("user",login);
            //返回登录成功信息
            return "登录成功";
        }
        //返回登录错误信息
        return "用户名或密码错误";
    }

    /**
     * 根据用户名修改密码
     * @param request
     * @param userinfo
     * @param yzm
     * @return
     */
    @Override
    public String updateByName(HttpServletRequest request,Userinfo userinfo,String yzm) {
        //从session中取出验证码
        String code = String.valueOf(request.getSession().getAttribute("code"));
        //调用根据名字查询方法
        Userinfo userinfo1 = userinfoDao.queryByName(userinfo.getUname());
        //判断用户信息是否存在
        if(userinfo1==null){
            //返回不存在信息
            return "用户名不存在";
        }
        //判断验证码是否正确
        if(!code.equals(yzm)){
            //返回错误信息
            return "验证码错误";
        }
        //调用根据名字修改方法
        userinfoDao.updateByName(userinfo);
        //返回成功信息
        return "修改成功";
    }

    /**
     * 根据名字查询
     * @param uname
     * @return
     */
    @Override
    public Userinfo queryByName(String uname) {
        return userinfoDao.queryByName(uname);
    }
}