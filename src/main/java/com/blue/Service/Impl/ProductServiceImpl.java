package com.blue.Service.Impl;

import com.blue.DAO.Impl.ProductDAOImpl;
import com.blue.DAO.Impl.ProductImageDAOImpl;
import com.blue.DAO.ProductDAO;
import com.blue.DAO.ProductImageDAO;
import com.blue.Service.ProductService;
import com.blue.pojo.Product;

import java.util.List;

/**
 * @author blue
 * @date 2023/4/3 18:48
 **/
public class ProductServiceImpl implements ProductService {
    ProductDAO productDAO = new ProductDAOImpl();
    ProductImageDAO productImageDAO = new ProductImageDAOImpl();
    @Override
    public List<Product> list(Integer id) {
        List<Product> list =  productDAO.list(id);
        for (Product product : list) {
            product.setImages(productImageDAO.list(product));
        }
        return list;
    }

    @Override
    public Product edit(Integer id) {
        return productDAO.get(id);
    }

    @Override
    public boolean update(Product bean) {
        return productDAO.update(bean);
    }

    @Override
    public boolean add(Product bean) {
        return productDAO.add(bean);
    }

    @Override
    public boolean delete(Integer id) {
        return productDAO.delete(id);
    }
}
