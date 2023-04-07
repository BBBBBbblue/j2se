package com.blue.controller.admin;

import com.blue.DAO.Impl.PropertyDAOImpl;
import com.blue.pojo.Category;
import com.blue.pojo.Property;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author blue
 * @date 2023/4/3 14:43
 **/
@WebServlet(urlPatterns = "/propertyServlet")
public class PropertyServlet extends BaseBackServlet {

    public String list(HttpServletRequest req, HttpServletResponse resp){
        Integer id = Integer.parseInt(req.getParameter("id"));
        Category bean = new Category();
        bean.setId(id);
        List<Property> properties = propertyService.list(bean);
        System.out.println(properties);
        req.setAttribute("pro",properties);
        return "/page/admin/property/listProperty.jsp";
    }

    public String edit(HttpServletRequest req,HttpServletResponse resp){
        //获取超链接传递过来的参数
        Integer id = Integer.parseInt(req.getParameter("id"));
        //获取对应的分类对象
        Property property = propertyService.edit(id);
        //数据存入请求
        req.setAttribute("p",property);
        //转发页面
        return "/page/admin/property/editProperty.jsp";
    }

    public String update(HttpServletRequest req,HttpServletResponse resp){
        //获取表单参数
        Property property = new PropertyDAOImpl().get(Integer.parseInt(req.getParameter("id")));
        //调用service处理
        System.out.println(property);
        String name = req.getParameter("name");
        property.setName(name);
        propertyService.update(property);
        //重新发送请求 获取最新的listCategory.jsp页面
        return "@/admin_property_list?id="+property.getCategory().getId();
    }

    public String delete(HttpServletRequest req,HttpServletResponse resp){
        Integer id = Integer.parseInt(req.getParameter("id"));
        //调用service实现删除
        propertyService.delete(id);
        return "%success";
    }

    public String add(HttpServletRequest req,HttpServletResponse resp){
        //获取表单参数
        String name = req.getParameter("name");
        System.out.println(name);
        //参数封装到对象中
        Property property = new Property();
        Integer id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        Category category = new Category();
        category.setId(id);
        property.setCategory(category);
        property.setName(name);
        //调用service
        propertyService.add(property);
        //重新发送/admin_category_list的请求
        return "@/admin_property_list?id="+id;
    }
}
