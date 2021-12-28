package org.example.controller.login;

import org.example.utils.jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/admin_register")
public class admin_register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jdbc jdbc =new jdbc();
        Connection conn = null;
        conn = jdbc.getConn();
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("sql连接池已打开");
        try {
            PreparedStatement p = conn.prepareStatement("insert into admin_log(username,password) values (?,?)");
            p.setString(1, username);
            p.setString(2, password);
            p.execute();
            System.out.println("注册成功");
            jdbc.closeAll(null, p, conn);
            System.out.println("sql连接池已关闭");
            req.getRequestDispatcher("admin_log.html").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
