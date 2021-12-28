package org.example.duty;

import org.example.dao.doctorDao;
import org.example.domain.doctor;
import org.w3c.dom.ls.LSException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/duty_show")
public class duty_show extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doctorDao doctorDao = new doctorDao();
        List<doctor> doctorslist = doctorDao.show_unduty();
        List<doctor> doctors =doctorDao.show_duty();
        req.setAttribute("doctors",doctorslist);
        req.setAttribute("duty_doctors",doctors);
        resp.setCharacterEncoding("utf-8");
        req.getRequestDispatcher("/duty_show.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
