package com.blue.DAO.Impl;

import com.blue.DAO.OrderDAO;
import com.blue.Util.Connect.ConnectionPool;
import com.blue.pojo.Category;
import com.blue.pojo.Order;
import com.blue.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author blue
 * @date 2023/4/1 17:13
 **/
public class OrderDAOImpl implements OrderDAO {
    public  static final String waitPay = "waitPay";
    public  static final String waitDelivery = "waitDelivery";
    public  static final String waitConfirm = "waitConfirm";
    public  static final String waitReview = "WaitReview";
    public  static final String finish = "finish";
    public  static final String delete = "delete";
    ConnectionPool pool = ConnectionPool.getInstance();
    @Override
    public int getTotal(User bean) {
        String sql = "select count(*) from order_ where uid = ?";
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
    public boolean add(Order bean) {
        String sql = "insert into order_(orderCode,address,post,receiver,mobile," +
                "userMessage,createDate,payDate,deliveryDate,confirmDate,uid,status) " +
                "values (?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        boolean flag = false;
        try{
            ps = c.prepareStatement(sql);
            ps.setString(1,bean.getOrderCode());
            ps.setString(2,bean.getAddress());
            ps.setString(3,bean.getPost());
            ps.setString(4,bean.getReceiver());
            ps.setString(5,bean.getMobile());
            ps.setString(6,bean.getUserMessage());
            ps.setTimestamp(7, (Timestamp) bean.getCreateDate());
            ps.setTimestamp(8, (Timestamp) bean.getPayDate());
            ps.setTimestamp(9, (Timestamp) bean.getDeliveryDate());
            ps.setTimestamp(10, (Timestamp) bean.getConfirmDate());
            ps.setInt(11,bean.getUser().getId());
            ps.setString(12,bean.getStatus());
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
    public boolean update(Order bean) {
        String sql = "update order_ set orderCode=?,address=?,post=?,receiver=?,mobile=?," +
                "userMessage=?,createDate=?,payDate=?,deliveryDate=?,confirmDate=?" +
                ",uid=?,status=? where id = ?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        boolean flag = false;
        try{
            ps = c.prepareStatement(sql);
            ps.setString(1,bean.getOrderCode());
            ps.setString(2,bean.getAddress());
            ps.setString(3,bean.getPost());
            ps.setString(4,bean.getReceiver());
            ps.setString(5,bean.getMobile());
            ps.setString(6,bean.getUserMessage());
            ps.setTimestamp(7, (Timestamp) bean.getCreateDate());
            ps.setTimestamp(8, (Timestamp) bean.getPayDate());
            ps.setTimestamp(9, (Timestamp) bean.getDeliveryDate());
            ps.setTimestamp(10, (Timestamp) bean.getConfirmDate());
            ps.setInt(11,bean.getUser().getId());
            ps.setString(12,bean.getStatus());
            ps.setInt(13,bean.getId());
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
        String sql = "delete  from order_ where id = ?";
        PreparedStatement ps = null;
        boolean flag = false;
        Connection c = pool.getOne();
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
    public Order get(Integer id) {
        String sql = "select * from order_ where id = ?";
        PreparedStatement ps = null;
        Order order = null;
        Connection c = pool.getOne();
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                order = new Order();
                order.setId(rs.getInt("id"));
                order.setOrderCode(rs.getString("orderCode"));
                order.setAddress(rs.getString("address"));
                order.setPost(rs.getString("post"));
                order.setReceiver(rs.getString("receiver"));
                order.setMobile(rs.getString("mobile"));
                order.setUserMessage(rs.getString("userMessage"));
                order.setCreateDate(rs.getDate("createDate"));
                order.setPayDate(rs.getDate("payDate"));
                order.setDeliveryDate(rs.getDate("deliveryDate"));
                order.setConfirmDate(rs.getDate("confirmDate"));
                order.setUser(new User(rs.getInt("uid"),null,null));
                order.setStatus(rs.getString("status"));
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
        return order;
    }

    @Override
    public List<Order> list(User bean) {
        String sql = "select * from order_ where uid = ?";
        PreparedStatement ps = null;
        List<Order> list = new ArrayList<>();
        Order order = null;
        Connection c = pool.getOne();
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,bean.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                order = new Order();
                order.setId(rs.getInt("id"));
                order.setOrderCode(rs.getString("orderCode"));
                order.setAddress(rs.getString("address"));
                order.setPost(rs.getString("post"));
                order.setReceiver(rs.getString("receiver"));
                order.setMobile(rs.getString("mobile"));
                order.setUserMessage(rs.getString("userMessage"));
                order.setCreateDate(rs.getDate("createDate"));
                order.setPayDate(rs.getDate("payDate"));
                order.setDeliveryDate(rs.getDate("deliveryDate"));
                order.setConfirmDate(rs.getDate("confirmDate"));
                order.setUser(bean);
                order.setStatus(rs.getString("status"));
                list.add(order);
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
    public List<Order> list(User bean, int start, int count) {
        String sql = "select * from order_ where uid = ? limit ?,?";
        PreparedStatement ps = null;
        List<Order> list = new ArrayList<>();
        Order order = null;
        Connection c = pool.getOne();
        try{
            ps = c.prepareStatement(sql);
            ps.setInt(1,bean.getId());
            ps.setInt(2,start);
            ps.setInt(3,count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                order = new Order();
                order.setId(rs.getInt("id"));
                order.setOrderCode(rs.getString("orderCode"));
                order.setAddress(rs.getString("address"));
                order.setPost(rs.getString("post"));
                order.setReceiver(rs.getString("receiver"));
                order.setMobile(rs.getString("mobile"));
                order.setUserMessage(rs.getString("userMessage"));
                order.setCreateDate(rs.getDate("createDate"));
                order.setPayDate(rs.getDate("payDate"));
                order.setDeliveryDate(rs.getDate("deliveryDate"));
                order.setConfirmDate(rs.getDate("confirmDate"));
                order.setUser(bean);
                order.setStatus(rs.getString("status"));
                list.add(order);
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
