package com.blue.Service;

import com.blue.pojo.Category;

import java.util.List;

/**
 * @author blue
 * @date 2023/4/3 10:28
 **/
public interface CategoryService {
    List<Category> list();

    boolean add(Category bean);

    Category edit(Integer id);

    boolean update(Category category);

    boolean delete(Integer id);
}
