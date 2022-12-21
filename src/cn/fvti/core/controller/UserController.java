package cn.fvti.core.controller;

import cn.fvti.core.pojo.User;
import cn.fvti.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/login.action",method = RequestMethod.POST)
    public String login(String usercode, String password, Model model, HttpSession session){
        User user = userService.findUser(usercode,password);
        if (user!=null){
            session.setAttribute("USER_SESSION",user);
            return "customer";
        }
        model.addAttribute("msg","账号或密码错误,请重新输入！");
        return "login";
    }


    @RequestMapping(value = "/toCustomer.action")
    public String toCustomer(){
        return "redirect:customer/list.action";
    }
    @RequestMapping(value = "/logout.action")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:login.action";
    }
    @RequestMapping(value = "/login.action",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }


    @RequestMapping(value="/login_null")                               /*用户登入*/
    public String login_null(){
        return "User_sign";
    }


    @RequestMapping(value="/Administrator/sign")                               /*跳转用户添加*/
    public String login_sign(){
        return "Administrator_sign";
    }

    @RequestMapping(value = "/Adminstrator_sign")                       /*用户添加*/
    public String Adminstrator_sign(User user,Model model,String user_code,String user_name,String user_password){
        user.setUser_code(user_code);
        user.setUser_password(user_password);
        user.setUser_name(user_name);
        int users=this.userService.user_sign(user);
        System.out.println(user);
        if (users>0){
            model.addAttribute("msg","您已经成功注册管理员，现在登入吧");
            return "login";
        }
        else {
            model.addAttribute("sign_msg","出错了，请重新注册");
            return "Administrator_sign";
        }
    }


}
