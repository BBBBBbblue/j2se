package com.blue.Service.Impl;

import com.blue.DAO.CategoryDAO;
import com.blue.DAO.Impl.CategoryDAOImpl;
import com.blue.Service.CategoryService;
import com.blue.pojo.Category;

import java.util.List;

/**
 * @author blue
 * @date 2023/4/3 10:29
 **/
public class CategoryServiceImpl implements CategoryService {
    private CategoryDAO categoryDAO = new CategoryDAOImpl();
    @Override
    public List<Category> list() {
        return categoryDAO.list();
    }

    @Override
    public boolean add(Category bean) {
        return categoryDAO.add(bean);
    }

    @Override
    public Category edit(Integer id) {
        return categoryDAO.get(id);
    }

    @Override
    public boolean update(Category category) {
        return categoryDAO.update(category);
    }

    @Override
    public boolean delete(Integer id) {
        return categoryDAO.delete(id);
    }
}
