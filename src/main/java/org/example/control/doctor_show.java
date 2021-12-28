package org.example.control;

import org.example.dao.doctorDao;
import org.example.domain.doctor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/doctor_show")
public class doctor_show extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        doctorDao doctorDao = new doctorDao();
        //String name=req.getParameter("name");
        String name=(String)req.getSession().getAttribute("doctorName");
        System.out.println(name);
        System.out.println(req.getSession());
        List<doctor> doctorlist = doctorDao.doctor_show(name);
        req.setAttribute("doctor",doctorlist);
        req.getRequestDispatcher("/doctor_show.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
