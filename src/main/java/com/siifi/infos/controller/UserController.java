package com.siifi.infos.controller;

import com.siifi.infos.entity.User;
import com.siifi.infos.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "infos")
public class UserController {
    @Autowired
    private UserService userService;
    //跳转视图
    @RequestMapping("/ueior")
    public String ueior() {
        return "column_ueior";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/manage.html")
    public String manage() {
        return "manage";
    }
    /**
     * 登录验证接口
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/verify",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(@RequestBody Map<String, Object> reqMap, HttpServletRequest request){
        HttpSession session = request.getSession();
        Map<String,Object> map = new HashMap<String,Object>();
        String userName=reqMap.get("userName").toString();
        String passWord=reqMap.get("passWord").toString();
        User user=userService.getUser(userName);
        if(user == null){
            map.put("message", "用户名不存在");
            map.put("code", 2);
        }
        else {
            String name=user.getUserName();
            String password=user.getPassWord();
            if(password.equals(passWord)){
                session.setAttribute("user",user);  //存入session
                map.put("message", "登录成功");
                map.put("code", 1);
            }
            else {
                map.put("message", "密码错误");
                map.put("code", 0);
            }
        }
        return map;
    }

    /**
     * 退出登录 移除session中的用户信息
     * @param request
     * @return
     */
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "login";
    }

    /**
     * 进入修改密码页面
     * @return
     */
    @RequestMapping(value = "/pass")
    public String pass()    {
        return "updatePass";
    }

    /**
     * 接收处理好的带html标签的文章
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editPass",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editPass(@RequestBody Map<String,Object> reqMap,HttpServletRequest request){
        HttpSession session = request.getSession();
        Map<String,Object> map = new HashMap<String,Object>();
        String oldPass=reqMap.get("oldPass").toString();
        String newPass=reqMap.get("newPass").toString();
        String newPassTwo=reqMap.get("newPassTwo").toString();
        User sessionUser=(User) session.getAttribute("user");
        String userName=sessionUser.getUserName();//取出登录时保存在session中的值
        if(userName !=null && userName.length()>0){
            User user=userService.getUser(userName);
            String userPass=user.getPassWord();
            if(userPass.equals(oldPass)){
                if(newPass.equals(newPassTwo)){
                    User user1=new User();
                    user1.setUserName(userName);
                    user1.setPassWord(newPassTwo);
                    userService.editUser(user1);
                    session.removeAttribute("user");
                    map.put("message", "密码修改成功");
                    map.put("code", 1);
                }
                else {
                    map.put("message", "俩次输入密码不一致");
                    map.put("code", 0);
                }
            }
            else {
                map.put("message", "密码输入错误");
                map.put("code", 0);
            }
        }
        else {
            map.put("message", "登录信息已失效");
            map.put("code", 0);
        }
        return map;
    }
}
