package com.blue.controller.admin;

import com.blue.pojo.Category;
import com.blue.pojo.Product;
import com.blue.pojo.Property;
import com.blue.pojo.PropertyValue;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author blue
 * @date 2023/4/3 21:17
 **/
@WebServlet(urlPatterns = "/propertyValueServlet")
public class PropertyValueServlet extends BaseBackServlet {

    public String list(HttpServletRequest req, HttpServletResponse resp){
        Integer id = Integer.parseInt(req.getParameter("id"));
        Integer cid = Integer.parseInt(req.getParameter("cid"));
        Category category = new Category();
        category.setId(cid);
        Product product = new Product();
        product.setId(id);
        product.setCategory(category);
        HashMap<Property, PropertyValue> map = propertyValueService.list(product);
        req.setAttribute("proMap",map);
        return "/page/admin/propertyValue/listPropertyValue.jsp";
    }

    public String update(HttpServletRequest req,HttpServletResponse resp){
        Integer id = Integer.parseInt(req.getParameter("id"));
        String value = req.getParameter("value");
        boolean flag = propertyValueService.update(id,value);
        if (flag){
            return "%success";
        }else {
            return "%fail";
        }
    }
}
