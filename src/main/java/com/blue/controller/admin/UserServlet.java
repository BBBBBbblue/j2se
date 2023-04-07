package com.blue.controller.admin;

import com.blue.pojo.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author blue
 * @date 2023/4/3 9:46
 **/
@WebServlet(urlPatterns = "/userServlet")
public class UserServlet extends BaseBackServlet {
    public String login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //接收参数并封装
        User user = new User();
        user.setName(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        boolean flag = userService.login(user);
        //如果登录成功，应该将用户信息存入session 用于后续校验
        if(flag){
            req.getSession().setAttribute("user",user);
            return "@/admin_category_list";
        }else {
            return "@/page/admin/login/login.jsp";
        }
    }

    public String exitLogin(HttpServletRequest req,HttpServletResponse resp){
        //获取session 并且清除session中的注册信息
        req.getSession().removeAttribute("user");
        return "@/page/admin/login/login.jsp";
    }
}
