package com.alexanderbai.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Description TODD
 * @Author AlexanderBai
 * @Date 19-12-6下午6:59
 **/
public class DbUtil {
    Connection connection = null;

    public  Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/test","root", "root");
        return connection;
    }

    public void close() throws SQLException {
        connection.close();
    }

}
