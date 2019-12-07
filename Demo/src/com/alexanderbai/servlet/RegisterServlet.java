package com.alexanderbai.servlet;

import com.alexanderbai.dao.RegisterDao;
import com.alexanderbai.pojo.User;
import com.alexanderbai.utils.DbUtil;

import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.SQLException;

@javax.servlet.annotation.WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        User user=new User();

        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");

        System.out.println(name);
        System.out.println(pwd);

        user.setName(name);
        user.setPassword(pwd);


        try {

            if (name != null && name != "" && pwd != null && pwd != "") {
                User user1 = RegisterDao.getByName(name);
                if (user1.getName() != null && user1.getPassword() != null) {
                    response.sendRedirect("failure.html");
                } else {
                    boolean b = RegisterDao.insert(user);
                    if (!b) {
                        /*System.out.println("success");*/
                        request.getRequestDispatcher("success.html").forward(request, response);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
