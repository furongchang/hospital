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

@WebServlet("/patient_register")
public class patient_register extends HttpServlet {
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
        String name=req.getParameter("name");
        String sex=req.getParameter("sex");
        String phone=req.getParameter("phone");
        String id=req.getParameter("id");
        System.out.println("sql连接池已打开");
        try {
            PreparedStatement p = conn.prepareStatement("insert into patient_log(username,password,name,sex,phone,id) values (?,?,?,?,?,?)");
            p.setString(1, username);
            p.setString(2, password);
            p.setString(3,name);
            p.setString(4,sex);
            p.setString(5,phone);
            p.setString(6,id);
            p.execute();
            System.out.println("注册成功");
            jdbc.closeAll(null, p, conn);
            System.out.println("sql连接池已关闭");
            req.getRequestDispatcher("patient_log.html").forward(req, resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
