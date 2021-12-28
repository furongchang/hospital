package org.example.controller.login;

import org.example.dao.logDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet("/patient_signout")
public class patient_signout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InetAddress address = InetAddress.getLocalHost();
        String ip = address.getHostAddress();
        Long end = new Date().getTime();
        Long begin = (Long) req.getSession().getAttribute("patient_begin");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String user = (String) req.getSession().getAttribute("patientName");
        Long t = end-begin;
        SimpleDateFormat s = new SimpleDateFormat("mm:ss");
        String time = s.format(t);
        String visit = sdf.format(begin);
        logDao logDao = new logDao();
        logDao.log(user, time, ip, visit, "success");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
