package com.alexanderbai.dao;

import com.alexanderbai.pojo.User;
import com.alexanderbai.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description TODD
 * @Author AlexanderBai
 * @Date 19-12-6下午6:49
 **/
public class RegisterDao {

    public static User getByName(String name) throws SQLException, ClassNotFoundException {
        User user=new User();
        DbUtil dbUtil = new DbUtil();
        String sql = "select * from user where name=?";
        Connection connection = dbUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getNString("pwd"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("pwd"));
        }
        System.out.println(user);
        return user;
    }

    public static boolean insert(User user) throws SQLException, ClassNotFoundException {
        String name = user.getName();
        String pwd = user.getPassword();
        DbUtil dbUtil = new DbUtil();
        String sql="insert into user(name,pwd)values(?,?)";

        Connection connection = dbUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,pwd);
        return preparedStatement.execute();

    }

}
