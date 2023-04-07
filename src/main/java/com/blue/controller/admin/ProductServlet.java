package com.blue.controller.admin;

import com.blue.pojo.Category;
import com.blue.pojo.Product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author blue
 * @date 2023/4/3 18:40
 **/
@WebServlet(urlPatterns = "/productServlet")
public class ProductServlet extends BaseBackServlet{
    public String list(HttpServletRequest req, HttpServletResponse resp){
       Integer id = Integer.parseInt(req.getParameter("id"));
       List<Product> products = productService.list(id);
       req.setAttribute("products",products);
       return "/page/admin/product/listProduct.jsp";
    }

    public String edit(HttpServletRequest req,HttpServletResponse resp){
        Integer id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.edit(id);
        req.setAttribute("product",product);
        return "/page/admin/product/editProduct.jsp";
    }

    public String update(HttpServletRequest req,HttpServletResponse resp){
        Integer id = Integer.parseInt(req.getParameter("id"));
        Integer cid = Integer.parseInt(req.getParameter("cid"));
        String name = req.getParameter("name");
        String subTitle = req.getParameter("subTitle");
        Float originalPrice = Float.parseFloat(req.getParameter("originalPrice"));
        Float promotePrice = Float.parseFloat(req.getParameter("promotePrice"));
        Integer stock = Integer.parseInt(req.getParameter("stock"));
        Product product = productService.edit(id);
        product.setName(name);
        product.setSubTitle(subTitle);
        product.setStock(stock);
        product.setOriginalPrice(originalPrice);
        product.setPromotePrice(promotePrice);
        productService.update(product);
        return "@/admin_product_list?id="+cid;
    }

    public String add(HttpServletRequest req,HttpServletResponse resp){
        String name = req.getParameter("name");
        String subTitle = req.getParameter("subTitle");
        Float originalPrice = Float.parseFloat(req.getParameter("originalPrice"));
        Float promotePrice = Float.parseFloat(req.getParameter("promotePrice"));
        Integer stock = Integer.parseInt(req.getParameter("productStock"));
        Category category = new Category();
        Integer cid = Integer.parseInt(req.getParameter("categoryId"));
        category.setId(cid);
        Product product = new Product();
        product.setName(name);
        product.setSubTitle(subTitle);
        product.setOriginalPrice(originalPrice);
        product.setPromotePrice(promotePrice);
        product.setStock(stock);
        product.setCategory(category);
        productService.add(product);
        return "@/admin_product_list?id="+cid;
    }

    public String delete(HttpServletRequest req,HttpServletResponse resp){
        Integer id = Integer.parseInt(req.getParameter("id"));
        productService.delete(id);
        return "%success";
    }
}
