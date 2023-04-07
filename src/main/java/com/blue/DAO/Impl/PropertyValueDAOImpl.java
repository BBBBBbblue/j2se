package com.blue.DAO.Impl;

import com.blue.DAO.PropertyValueDAO;
import com.blue.Util.Connect.ConnectionPool;
import com.blue.pojo.Product;
import com.blue.pojo.Property;
import com.blue.pojo.PropertyValue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author blue
 * @date 2023/4/1 21:34
 **/
public class PropertyValueDAOImpl implements PropertyValueDAO {

    private ConnectionPool pool = ConnectionPool.getInstance();

    @Override
    public boolean add(PropertyValue bean) {
        String sql = "insert into propertyValue (pid,ptid,value) values (?,?,?)";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        boolean flag = false;
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,bean.getProduct().getId());
            ps.setInt(2,bean.getProperty().getId());
            ps.setString(3,bean.getValue());
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
    public boolean update(PropertyValue bean) {
        String sql = "update propertyvalue set value=? where id = ?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        boolean flag = false;
        try{
            ps = c.prepareStatement(sql);
            ps.setString(1,bean.getValue());
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
        String sql = "delete from propertyvalue where id = ?";
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
    public PropertyValue get(Integer pid, Integer id) {
        String sql = "select * from propertyvalue where pid = ? and ptid = ?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        PropertyValue pv = null;
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,pid);
            ps.setInt(2,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                pv = new PropertyValue();
                pv.setId(rs.getInt("id"));
                Product product = new Product();
                product.setId(pid);
                pv.setProduct(product);
                Property property = new Property();
                property.setId(id);
                pv.setProperty(property);
                pv.setValue(rs.getString("value"));
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
        return pv;
    }

}
