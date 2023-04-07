package com.blue.DAO.Impl;

import com.blue.DAO.ProductDAO;
import com.blue.Util.Connect.ConnectionPool;
import com.blue.pojo.Category;
import com.blue.pojo.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
/**
 * @author blue
 * @date 2023/4/1 20:09
 **/
public class ProductDAOImpl implements ProductDAO {
    private ConnectionPool pool = ConnectionPool.getInstance();

    @Override
    public int getTotal() {
        String sql = "select count(*) from product";
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
    public boolean add(Product bean) {
        String sql = "insert into product (name,subTitle,originalPrice,promotePrice," +
                "stock,cid,createDate) " +
                "values (?,?,?,?,?,?,?)";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        boolean flag = false;
        try{
            ps = c.prepareStatement(sql);
            ps.setString(1,bean.getName());
            ps.setString(2,bean.getSubTitle());
            ps.setFloat(3,bean.getOriginalPrice());
            ps.setFloat(4,bean.getPromotePrice());
            ps.setInt(5,bean.getStock());
            ps.setInt(6,bean.getCategory().getId());
            Date date = new Date();
            java.sql.Date d = new java.sql.Date(date.getTime());
            ps.setDate(7,d);
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
    public boolean update(Product bean) {
        String sql = "update product set name = ?,subTitle = ?,originalPrice = ?" +
                ",promotePrice = ?,stock = ?,cid = ?,createDate = ? " +
                "where id = ?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        boolean flag = false;
        try{
            ps = c.prepareStatement(sql);
            ps.setString(1,bean.getName());
            ps.setString(2,bean.getSubTitle());
            ps.setFloat(3,bean.getOriginalPrice());
            ps.setFloat(4,bean.getPromotePrice());
            ps.setInt(5,bean.getStock());
            ps.setInt(6,bean.getCategory().getId());
            ps.setDate(7, (java.sql.Date) bean.getCreateDate());
            ps.setInt(8,bean.getId());
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
        String sql = "delete  from product where id = ?";
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
    public Product get(Integer id) {
        String sql = "select * from product where id = ?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        Product product = null;
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                product = new Product();
                product.setId(id);
                product.setName(rs.getString("name"));
                product.setSubTitle(rs.getString("subTitle"));
                product.setOriginalPrice(rs.getFloat("originalPrice"));
                product.setPromotePrice(rs.getFloat("promotePrice"));
                product.setStock(rs.getInt("stock"));
                product.setCategory(new Category(null,rs.getInt("cid"),null));
                product.setCreateDate(rs.getDate("createDate"));
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
        return product;
    }

    @Override
    public List<Product> list(Integer id) {
        String sql = "select * from product where cid = ?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        Product product = null;
        List<Product> list = new ArrayList<>();
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setSubTitle(rs.getString("subTitle"));
                product.setOriginalPrice(rs.getFloat("originalPrice"));
                product.setPromotePrice(rs.getFloat("promotePrice"));
                product.setStock(rs.getInt("stock"));
                product.setCategory(new Category(null,rs.getInt("cid"),null));
                product.setCreateDate(rs.getDate("createDate"));
                list.add(product);
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
    public List<Product> list(int start, int count) {
        String sql = "select * from product limit ?,?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        Product product = null;
        List<Product> list = new ArrayList<>();
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setSubTitle(rs.getString("subTitle"));
                product.setOriginalPrice(rs.getFloat("originalPrice"));
                product.setPromotePrice(rs.getFloat("promotePrice"));
                product.setStock(rs.getInt("stock"));
                product.setCategory(new Category(null,rs.getInt("cid"),null));
                product.setCreateDate(rs.getDate("createDate"));
                list.add(product);
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
