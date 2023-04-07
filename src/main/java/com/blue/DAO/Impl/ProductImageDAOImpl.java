package com.blue.DAO.Impl;

import com.blue.DAO.ProductDAO;
import com.blue.DAO.ProductImageDAO;
import com.blue.Util.Connect.ConnectionPool;
import com.blue.pojo.Product;
import com.blue.pojo.ProductImage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author blue
 * @date 2023/4/1 21:03
 **/
public class ProductImageDAOImpl implements ProductImageDAO {
    private ConnectionPool pool = ConnectionPool.getInstance();

    @Override
    public boolean add(ProductImage bean) {
        String sql = "insert into img (url,pid) values (?,?)";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        boolean flag = false;
        try{
            ps = c.prepareStatement(sql);
            ps.setString(1,bean.getUrl());
            ps.setInt(2,bean.getP().getId());
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
    public boolean update(ProductImage bean) {
        String sql = "update img set url = ?, pid = ? where id = ?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        boolean flag = false;
        try{
            ps = c.prepareStatement(sql);
            ps.setString(1,bean.getUrl());
            ps.setInt(2,bean.getP().getId());
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
        String sql = "delete from img where id = ?";
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
    public ProductImage get(Integer id) {
        String sql = "select * from img where id = ?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        ProductImage img = null;
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                img = new ProductImage();
                img.setId(id);
                img.setUrl(rs.getString("url"));
                Product product = new Product();
                product.setId(rs.getInt("pid"));
                img.setP(product);
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
        return img;
    }

    @Override
    public List<ProductImage> list(Product bean) {
        String sql = "select * from img where pid = ?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        ProductImage img = null;
        List<ProductImage> list = new ArrayList<>();
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,bean.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                img = new ProductImage();
                img.setId(rs.getInt("id"));
                img.setUrl(rs.getString("url"));
                img.setP(bean);
                list.add(img);
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
