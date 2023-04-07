package com.blue.Service;

import com.blue.pojo.Category;
import com.blue.pojo.Product;

import java.util.List;

/**
 * @author blue
 * @date 2023/4/3 18:48
 **/
public interface ProductService {

    List<Product> list(Integer id);

    Product edit(Integer id);

    boolean update(Product bean);

    boolean add(Product bean);

    boolean delete(Integer id);

}
