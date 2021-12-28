package org.example.control;


import org.example.dao.patientDao;
import org.example.domain.patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/patient_alter")
public class patient_alter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sex=req.getParameter("sex");
        String phone=req.getParameter("phone");
        String id=req.getParameter("id");
        patientDao patientDao=new patientDao();
        String name=(String)req.getSession().getAttribute("patientName");
        System.out.println(name);
        patientDao.patient_alter(sex,phone,id,name);
        resp.setCharacterEncoding("utf-8");
        req.getRequestDispatcher("/patient.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
