package com.blue.Service.Impl;

import com.blue.DAO.Impl.PropertyDAOImpl;
import com.blue.DAO.PropertyDAO;
import com.blue.Service.PropertyService;
import com.blue.pojo.Category;
import com.blue.pojo.Property;

import java.util.List;

/**
 * @author blue
 * @date 2023/4/3 14:40
 **/
public class PropertyServiceImpl implements PropertyService {
    PropertyDAO propertyDAO = new PropertyDAOImpl();
    @Override
    public List<Property> list(Category bean) {
       return propertyDAO.list(bean);
    }

    @Override
    public Property edit(Integer id) {
        return propertyDAO.get(id);
    }

    @Override
    public boolean update(Property bean) {
        return propertyDAO.update(bean);
    }

    @Override
    public boolean delete(Integer id) {
        return propertyDAO.delete(id);
    }

    @Override
    public boolean add(Property bean) {
        return propertyDAO.add(bean);
    }
}
