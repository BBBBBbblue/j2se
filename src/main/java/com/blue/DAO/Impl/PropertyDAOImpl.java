package com.blue.DAO.Impl;

import com.blue.DAO.PropertyDAO;
import com.blue.Util.Connect.ConnectionPool;
import com.blue.pojo.Category;
import com.blue.pojo.Property;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author blue
 * @date 2023/4/1 21:18
 **/
public class PropertyDAOImpl implements PropertyDAO {

    private ConnectionPool pool = ConnectionPool.getInstance();

    @Override
    public int getTotal(Category bean) {
        String sql = "select count(*) from property where cid = ?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        int size = 0;
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,bean.getId());
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
    public boolean add(Property bean) {
        String sql = "insert into property (cid,name) values (?,?)";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        boolean flag = false;
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,bean.getCategory().getId());
            ps.setString(2,bean.getName());
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
    public boolean update(Property bean) {
        String sql = "update property set cid = ? ,name = ? where id = ?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        boolean flag = false;
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,bean.getCategory().getId());
            ps.setString(2,bean.getName());
            ps.setInt(3,bean.getId());
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
        String sql = "delete from property where id = ?";
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
    public Property get(Integer id) {
        String sql = "select * from property where id = ?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        Property property = null;
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                property = new Property();
                property.setId(rs.getInt("id"));
                property.setName(rs.getString("name"));
                Category category = new Category();
                category.setId(rs.getInt("cid"));
                property.setCategory(category);
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
        return property;
    }

    @Override
    public List<Property> list(Category bean) {
        String sql = "select * from property where cid = ?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        Property property = null;
        List<Property> list = new ArrayList<>();
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,bean.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                property = new Property();
                property.setId(rs.getInt("id"));
                property.setName(rs.getString("name"));
                property.setCategory(bean);
                list.add(property);
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
    public List<Property> list(Integer id, int start, int count) {
        String sql = "select * from property where cid = ? limit ?,?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        Property property = null;
        List<Property> list = new ArrayList<>();
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setInt(2,start);
            ps.setInt(3,count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                property = new Property();
                property.setId(rs.getInt("id"));
                property.setName(rs.getString("name"));
                Category bean = new Category();
                bean.setId(rs.getInt("cid"));
                property.setCategory(bean);
                list.add(property);
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

}
