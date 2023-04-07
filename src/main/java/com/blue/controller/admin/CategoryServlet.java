package com.blue.controller.admin;

import com.blue.Service.CategoryService;
import com.blue.pojo.Category;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author blue
 * @date 2023/4/3 10:28
 **/
@WebServlet(urlPatterns = "/categoryServlet")
public class CategoryServlet extends BaseBackServlet {
     public String list(HttpServletRequest req, HttpServletResponse resp){
         //调用service获取集合
         List<Category> categories = categoryService.list();
         //将获取到的集合存入到请求中
         req.setAttribute("cs",categories);
         return "/page/admin/category/listCategory.jsp";
     }

     public String add(HttpServletRequest req,HttpServletResponse resp){
         //获取表单参数
         String name = req.getParameter("name");
         //参数封装到对象中
         Category category = new Category();
         category.setName(name);
         //调用service
         categoryService.add(category);
         //重新发送/admin_category_list的请求
         return "@/admin_category_list";
     }

     public String edit(HttpServletRequest req,HttpServletResponse resp){
         //获取超链接传递过来的参数
         Integer id = Integer.parseInt(req.getParameter("id"));
         //获取对应的分类对象
         Category category = categoryService.edit(id);
         //数据存入请求
         req.setAttribute("c",category);
         //转发页面
         return "/page/admin/category/editCategory.jsp";
     }

     public String update(HttpServletRequest req,HttpServletResponse resp){
         //获取表单参数
         Category category = new Category();
         category.setId(Integer.parseInt(req.getParameter("id")));
         category.setName(req.getParameter("name"));
         //调用service处理
         categoryService.update(category);
         //重新发送请求 获取最新的listCategory.jsp页面
         return "@/admin_category_list";
     }

     public String delete(HttpServletRequest req,HttpServletResponse resp){
         //获取参数id
         Integer id = Integer.parseInt(req.getParameter("id"));
         //调用service实现删除
         categoryService.delete(id);
         return "%success";
     }
}
