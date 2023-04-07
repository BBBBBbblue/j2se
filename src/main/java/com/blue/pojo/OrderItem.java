package com.blue.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author blue
 * @date 2023/3/31 16:37
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    private int number;
    private Product product;
    private Order order;
    private User user;
    private int id;
}
