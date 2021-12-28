package org.example.control;


import org.example.dao.doctorDao;
import org.example.dao.patientDao;
import org.example.domain.patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/doctor_alter")
public class doctor_alter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sex=req.getParameter("sex");
        String phone=req.getParameter("phone");
        String office=req.getParameter("office");
        doctorDao doctorDao=new doctorDao();
        String name=(String)req.getSession().getAttribute("doctorName");
        System.out.println(name);
        doctorDao.doctor_alter(sex,phone,office,name);
        resp.setCharacterEncoding("utf-8");
        req.getRequestDispatcher("/doctor.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
