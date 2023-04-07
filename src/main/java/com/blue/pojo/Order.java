package com.blue.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author blue
 * @date 2023/3/31 16:35
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String orderCode;
    private String address;
    private String post;
    private String receiver;
    private String mobile;
    private String userMessage;
    private Date createDate;
    private Date payDate;
    private Date deliveryDate;
    private Date confirmDate;
    private User user;
    private int id;

    //每一个订单所对应的订单详情集合

    private List<OrderItem> orderItems;

    //订单的总计金额

    private float total;

    //订单的商品总数量

    private int totalNumber;

    //订单状态

    private String status;
}
