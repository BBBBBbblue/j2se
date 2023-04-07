package com.blue.Service;

import com.blue.pojo.Category;
import com.blue.pojo.Property;

import java.util.List;

/**
 * @author blue
 * @date 2023/4/3 14:39
 **/
public interface PropertyService {
    List<Property> list(Category bean);

    Property edit(Integer id);

    boolean update(Property bean);

    boolean delete(Integer id);

    boolean add(Property bean);

}
