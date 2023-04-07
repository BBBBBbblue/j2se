package com.blue.Util.Connect;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * @author blue
 * @date 2023/4/1 10:40
 **/
public class ConnectionPool {
    private volatile static ConnectionPool pool;
    private LinkedList<Connection> list = new LinkedList<>();
    private ConnectionPool(){
        int size = 10;
        for (int i = 0; i < size; i++) {
            try {
                list.add(Connect.getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized Connection getOne(){
        while (list.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return list.pop();
    }

    public synchronized void addOne(Connection connection){
        list.add(connection);
        this.notifyAll();
    }

    public static ConnectionPool getInstance(){
        if (pool == null){
            synchronized (ConnectionPool.class) {
                if (pool == null) {
                    pool = new ConnectionPool();
                }
            }
        }
        return pool;
    }

}
