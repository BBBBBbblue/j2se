package com.blue.controller.admin;

import com.blue.Service.*;
import com.blue.Service.Impl.*;
import com.blue.pojo.PropertyValue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author blue
 * @date 2023/4/3 8:57
 **/

public abstract class BaseBackServlet extends HttpServlet {
    public UserService userService = new UserServiceImpl();
    public CategoryService categoryService = new CategoryServiceImpl();
    public PropertyService propertyService = new PropertyServiceImpl();
    public ProductService productService = new ProductServiceImpl();
    public PropertyValueService propertyValueService = new PropertyValueServiceImpl();
    public ProductImageService productImageService = new ProductImageServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String method = (String)req.getAttribute("method");

            Method m = this.getClass().getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
            String redirect = m.invoke(this,req,resp).toString();

            if (redirect.startsWith("@")){
                resp.sendRedirect(redirect.substring(1));
            }else  if (redirect.startsWith("%")){
                resp.setContentType("html/text;charset=utf-8");
                resp.getWriter().print(redirect.substring(1));
            }else {
                req.getRequestDispatcher(redirect).forward(req,resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
