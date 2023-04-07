package com.blue.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author blue
 * @date 2023/3/31 16:43
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review{
    private String content;
    private Date createDate;
    private User user;
    private Product product;
    private int id;
}
