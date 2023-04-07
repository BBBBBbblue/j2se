package com.blue.DAO.Impl;

import com.blue.DAO.UserDAO;
import com.blue.Util.Connect.ConnectionPool;
import com.blue.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author blue
 * @date 2023/4/3 9:45
 **/
public class UserDAOImpl implements UserDAO {
   private ConnectionPool pool = ConnectionPool.getInstance();
    @Override
    public User get(User user) {
        String sql = "select * from User where name = ?";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        User bean = null;
        try{
            ps = c.prepareStatement(sql);
            ps.setString(1,user.getName());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                bean = new User();
                bean.setName(user.getName());
                bean.setPassword(rs.getString("password"));
                bean.setId(rs.getInt("id"));
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
        if (bean == null || !bean.getPassword().equals(user.getPassword())){
            return null;
        }else {
            return bean;
        }
    }
    @Override
    public boolean register(User bean){
        String sql = "select * from User where name = ?";
        String sq = "insert into User(name,password) values (?,?)";
        Connection c = pool.getOne();
        PreparedStatement ps = null;
        boolean flag = false;
        try{
            ps = c.prepareStatement(sql);
            ps.setString(1,bean.getName());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return false;
            }else {
                ps.close();
                ps = c.prepareStatement(sq);
                ps.setString(1,bean.getName());
                ps.setString(2,bean.getPassword());
                ps.execute();
                flag = true;
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
        return flag;
    }

}

