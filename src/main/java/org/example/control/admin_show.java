package org.example.control;

import org.example.dao.doctorDao;
import org.example.dao.patientDao;
import org.example.domain.doctor;
import org.example.domain.patient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/admin_show")
public class admin_show extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doctorDao doctorDao = new doctorDao();
        List<doctor> doctorslist = doctorDao.doctor_showall();
        req.setAttribute("doctors",doctorslist);
        resp.setCharacterEncoding("utf-8");


        patientDao patientDao=new patientDao();
        List<patient> patientList = patientDao.patient_showall();
        req.setAttribute("patient",patientList);
        resp.setCharacterEncoding("utf-8");
        req.getRequestDispatcher("/admin_show.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
