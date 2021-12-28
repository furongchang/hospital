package org.example.log;

import org.example.dao.doctorDao;
import org.example.dao.logDao;
import org.example.domain.doctor;
import org.example.domain.log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/log_show")
public class log_show extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logDao logDao=new logDao();
        doctorDao doctorDao=new doctorDao();
        List<log> logs=logDao.log_show();
        List<doctor> doctors=doctorDao.duty_show();
        req.setAttribute("logs",logs);
        req.setAttribute("doctors",doctors);
        req.getRequestDispatcher("/log_show.jsp").forward(req,resp);
    }
}
