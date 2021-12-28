package org.example.controller.login;

import org.example.dao.logDao;
import org.example.utils.jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/admin_login")
public class admin_login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("=========login==========");
        System.out.println(username);
        System.out.println(password);
        System.out.println("===================");
        System.out.println(req.getContextPath());
        org.example.utils.jdbc jdbc=new jdbc();
        Connection conn = null;
        conn = jdbc.getConn();
        System.out.println("sql连接池已打开");
        try {
            PreparedStatement p = conn.prepareStatement("select username,password from admin_log where username=? and password=?");
            p.setString(1, username);
            p.setString(2, password);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                System.out.println("登录成功！");
                Long begin = new Date().getTime();
                req.getSession().setAttribute("adminName",rs.getString("username"));
                req.getSession().setAttribute("admin_begin",begin);
                req.getRequestDispatcher("admin.html").forward(req, resp);
            } else {
                Long begin=new Date().getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time=sdf.format(begin);
                InetAddress address = InetAddress.getLocalHost();
                String ip = address.getHostAddress();
                logDao logDao=new logDao();
                logDao.log(req.getParameter("username"),"无",ip,time,"failed");
                req.getRequestDispatcher("failed.jsp").forward(req, resp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
