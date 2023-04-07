package com.blue.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author blue
 * @date 2023/3/31 16:41
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {
    private int id;
    private String url;
    private Product p;
}
