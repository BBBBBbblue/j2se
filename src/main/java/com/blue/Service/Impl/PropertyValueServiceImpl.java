package com.blue.Service.Impl;

import com.blue.DAO.Impl.PropertyDAOImpl;
import com.blue.DAO.Impl.PropertyValueDAOImpl;
import com.blue.DAO.PropertyValueDAO;
import com.blue.Service.PropertyValueService;
import com.blue.pojo.Product;
import com.blue.pojo.Property;
import com.blue.pojo.PropertyValue;

import java.util.HashMap;
import java.util.List;


/**
 * @author blue
 * @date 2023/4/3 21:05
 **/
public class PropertyValueServiceImpl implements PropertyValueService {
    PropertyValueDAO propertyValueDAO = new PropertyValueDAOImpl();

    @Override
    public HashMap<Property, PropertyValue> list(Product bean) {
        HashMap<Property,PropertyValue> propertyMap = new HashMap<>(16);
        List<Property> list = new PropertyDAOImpl().list(bean.getCategory());
        for (Property property : list) {
            PropertyValue value = propertyValueDAO.get(bean.getId(),property.getId());
            propertyMap.put(property,value);
        }
        return propertyMap;
    }

    @Override
    public boolean update(Integer id, String value) {
        PropertyValue propertyValue = new PropertyValue();
        propertyValue.setValue(value);
        propertyValue.setId(id);
        return propertyValueDAO.update(propertyValue);
    }
}
