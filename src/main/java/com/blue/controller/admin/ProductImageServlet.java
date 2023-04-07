package com.blue.controller.admin;

import com.blue.pojo.Product;
import com.blue.pojo.ProductImage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author blue
 * @date 2023/4/4 10:00
 **/
@WebServlet("/imageServlet")
public class ProductImageServlet extends BaseBackServlet {
    public String list(HttpServletRequest req, HttpServletResponse resp){
        Integer id = Integer.parseInt(req.getParameter("id"));
        List<ProductImage> list = productImageService.list(id);
        req.setAttribute("images",list);
        return "/page/admin/image/listImage.jsp";
    }

    public String add(HttpServletRequest req,HttpServletResponse resp){
        String url = req.getParameter("url");
        Integer id = Integer.parseInt(req.getParameter("id"));
        Product product = new Product();
        product.setId(id);
        ProductImage image = new ProductImage();
        image.setUrl(url);
        image.setP(product);
        productImageService.add(image);
        return "@/admin_image_list?id="+id;
    }

    public String delete(HttpServletRequest req,HttpServletResponse resp){
        Integer id = Integer.parseInt(req.getParameter("id"));
        productImageService.delete(id);
        return "%success";
    }
}
