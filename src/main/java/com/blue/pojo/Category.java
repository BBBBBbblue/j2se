package com.blue.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author blue
 * @date 2023/3/31 16:48
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private String name;
    private int id;
    //每一个分类所对应的商品集合

    List<Product> products;
}
