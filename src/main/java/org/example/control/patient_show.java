package org.example.control;


import org.example.dao.patientDao;
import org.example.domain.patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/patient_show")
public class patient_show extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        patientDao patientDao=new patientDao();
        String name=(String)req.getSession().getAttribute("patientName");
        System.out.println(name);
        List<patient> patientList = patientDao.patient_show(name);
        req.setAttribute("patient",patientList);
        resp.setCharacterEncoding("utf-8");
        req.getRequestDispatcher("/patient_show.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
