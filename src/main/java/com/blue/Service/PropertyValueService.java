package com.blue.Service;

import com.blue.pojo.Product;
import com.blue.pojo.Property;
import com.blue.pojo.PropertyValue;

import java.util.HashMap;
import java.util.List;

/**
 * @author blue
 * @date 2023/4/3 21:04
 **/
public interface PropertyValueService {
    HashMap<Property,PropertyValue> list(Product bean);

    boolean update(Integer id,String value);
}
