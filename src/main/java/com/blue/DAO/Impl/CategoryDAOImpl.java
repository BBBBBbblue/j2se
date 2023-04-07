package com.blue.DAO.Impl;

import com.blue.DAO.CategoryDAO;
import com.blue.Util.Connect.ConnectionPool;
import com.blue.pojo.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author blue
 * @date 2023/4/1 16:31
 **/
public class CategoryDAOImpl implements CategoryDAO {
    private ConnectionPool pool = ConnectionPool.getInstance();

    @Override
    public int getTotal() {
        String sql = "select count(*) from category";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        int size = 0;
        try{
            ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                size = rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        pool.addOne(c);
        return size;
    }

    @Override
    public boolean add(Category bean) {
        String sql = "insert into category (name) values (?)";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        boolean flag = false;
        try{
            ps = c.prepareStatement(sql);
            ps.setString(1,bean.getName());
            ps.execute();
            flag = true;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        pool.addOne(c);
        return flag;
    }

    @Override
    public boolean update(Category bean) {
        String sql = "update category set name = ? where id = ?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        boolean flag = false;
        try{
            ps = c.prepareStatement(sql);
            ps.setString(1,bean.getName());
            ps.setInt(2,bean.getId());
            ps.execute();
            flag = true;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        pool.addOne(c);
        return flag;
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "delete  from category where id = ?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        boolean flag = false;
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            flag = true;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        pool.addOne(c);
        return flag;
    }

    @Override
    public Category get(Integer id) {
        String sql = "select * from category where id = ?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        Category category = null;
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        pool.addOne(c);
        return category;
    }

    @Override
    public List<Category> list() {
        String sql = "select * from category";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        List<Category> list = new ArrayList<>();
        try{
           ps = c.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           while (rs.next()){
               Category category = new Category();
               category.setId(rs.getInt("id"));
               category.setName(rs.getString("name"));
               list.add(category);
           }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        pool.addOne(c);
        return list;
    }

    @Override
    public List<Category> list(int start, int count) {
        String sql = "select * from category limit ?,?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        List<Category> list = new ArrayList<>();
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                list.add(category);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        pool.addOne(c);
        return list;
    }

    public static void main(String[] args) {
        CategoryDAOImpl dao = new CategoryDAOImpl();
        dao.delete(86);
    }
}
