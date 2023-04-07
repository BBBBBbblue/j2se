package com.blue.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author blue
 * @date 2023/3/31 16:47
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyValue {
    private String value;
    private Product product;
    private Property property;
    private int id;
}
