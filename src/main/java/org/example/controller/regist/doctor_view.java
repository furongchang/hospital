package org.example.controller.regist;

import org.example.dao.registrationDao;
import org.example.domain.registration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/doctor_view")
public class doctor_view extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        registrationDao registrationDao =new registrationDao();
        String name=(String)req.getSession().getAttribute("doctorName");
        System.out.println(req.getSession().getAttribute("doctorName"));
        List<registration> registrations =registrationDao.call(name);
        req.setAttribute("registrations",registrations);
        req.getRequestDispatcher("/registration_show.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
