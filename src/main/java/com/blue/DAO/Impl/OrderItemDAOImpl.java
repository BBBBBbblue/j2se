package com.blue.DAO.Impl;

import com.blue.DAO.OrderItemDAO;
import com.blue.Util.Connect.ConnectionPool;
import com.blue.pojo.Order;
import com.blue.pojo.OrderItem;
import com.blue.pojo.Product;
import com.blue.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author blue
 * @date 2023/4/1 19:35
 **/
public class OrderItemDAOImpl implements OrderItemDAO {
    private ConnectionPool pool = ConnectionPool.getInstance();
    @Override
    public List<OrderItem> getCarts(User bean) {
        String sql = "select * from orderitem where uid = ? and oid = -1";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        OrderItem orderItem = null;
        List<OrderItem> list = new ArrayList<>();
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,bean.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                orderItem = new OrderItem();
                orderItem.setNumber(rs.getInt("number"));

                Product product = new Product();
                product.setId(rs.getInt("pid"));
                orderItem.setProduct(product);
                User user = new User();
                user.setId(rs.getInt("uid"));
                orderItem.setUser(user);
                orderItem.setId(rs.getInt("id"));
                list.add(orderItem);
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
    public boolean add(OrderItem bean) {
        String sql = "insert into orderitem (pid,oid,uid,number) values (?,?,?,?)";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        boolean flag = false;
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,bean.getProduct().getId());
            ps.setInt(2,bean.getOrder().getId());
            ps.setInt(3,bean.getUser().getId());
            ps.setInt(4,bean.getNumber());
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
    public boolean update(OrderItem bean) {
        String sql = "update orderitem set pid = ?,oid = ?,uid = ?,number = ? where id = ?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        boolean flag = false;
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,bean.getProduct().getId());
            ps.setInt(2,bean.getOrder().getId());
            ps.setInt(3,bean.getUser().getId());
            ps.setInt(4,bean.getNumber());
            ps.setInt(5,bean.getId());
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
        String sql = "delete from orderitem where id = ?";
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
    public OrderItem get(Integer id) {
        String sql = "select * from orderitem where id = ?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        OrderItem orderItem = null;
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                orderItem = new OrderItem();
                orderItem.setNumber(rs.getInt("number"));
                Order order = new Order();
                order.setId(rs.getInt("oid"));
                orderItem.setOrder(order);
                Product product = new Product();
                product.setId(rs.getInt("pid"));
                orderItem.setProduct(product);
                User user = new User();
                user.setId(rs.getInt("uid"));
                orderItem.setUser(user);
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
        return orderItem;
    }

    @Override
    public List<OrderItem> list(Order bean) {
        String sql = "select * from orderitem where oid = ?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        OrderItem orderItem = null;
        List<OrderItem> list = new ArrayList<>();
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,bean.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                orderItem = new OrderItem();
                orderItem.setNumber(rs.getInt("number"));

                orderItem.setOrder(bean);

                Product product = new Product();
                product.setId(rs.getInt("pid"));
                orderItem.setProduct(product);
                User user = new User();
                user.setId(rs.getInt("uid"));
                orderItem.setUser(user);
                orderItem.setId(rs.getInt("id"));
                list.add(orderItem);
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
