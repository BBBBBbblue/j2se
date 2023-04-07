package com.blue.Util.Connect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author blue
 * @date 2023/4/1 10:40
 **/
public class Connect {
    private static String username;
    private static String password;
    private static String url;
    static {
        File config = new File("D:\\d0331_web\\src\\main\\java\\com\\blue\\Util\\config.properties");
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(config);
            properties.load(fis);
            username = properties.getProperty("username");
            url = properties.getProperty("url");
            password = properties.getProperty("password");
            String driver = properties.getProperty("driver");
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("配置文件加载出错");
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

}
