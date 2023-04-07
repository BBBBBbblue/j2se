package com.blue.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author blue
 * @date 2023/3/31 16:40
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String name;
    private String subTitle;
    private float originalPrice;
    private float promotePrice;
    private int stock;
    private Date createDate;
    private Category category;
    private int id;
    private int reviewCount;
    //评价数量
    private int saleCount;
    // 销量
    private List<ProductImage> images;
}
