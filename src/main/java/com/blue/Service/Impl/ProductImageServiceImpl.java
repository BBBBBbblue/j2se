package com.blue.Service.Impl;

import com.blue.DAO.Impl.ProductImageDAOImpl;
import com.blue.DAO.ProductImageDAO;
import com.blue.Service.ProductImageService;
import com.blue.pojo.Product;
import com.blue.pojo.ProductImage;

import java.util.List;

/**
 * @author blue
 * @date 2023/4/4 9:56
 **/
public class ProductImageServiceImpl implements ProductImageService {
    ProductImageDAO productImageDAO = new ProductImageDAOImpl();
    @Override
    public List<ProductImage> list(Integer id) {
        Product product = new Product();
        product.setId(id);
        return productImageDAO.list(product);
    }

    @Override
    public boolean add(ProductImage bean) {
        return productImageDAO.add(bean);
    }

    @Override
    public boolean delete(Integer id) {
        return productImageDAO.delete(id);
    }
}
