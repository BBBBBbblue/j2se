package com.blue.Service;

import com.blue.pojo.ProductImage;

import java.util.List;

/**
 * @author blue
 * @date 2023/4/4 9:56
 **/
public interface ProductImageService {
    List<ProductImage> list(Integer id);

    boolean add(ProductImage bean);

    boolean delete(Integer id);
}
