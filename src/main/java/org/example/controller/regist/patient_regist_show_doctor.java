package org.example.controller.regist;

import org.example.dao.doctorDao;
import org.example.dao.registrationDao;
import org.example.domain.doctor;
import org.example.domain.patient;
import org.example.utils.jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/patient_regist_show_doctor")
public class patient_regist_show_doctor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doctorDao doctorDao=new doctorDao();
        List<doctor> doctors=doctorDao.doctor_massage();
        System.out.println("挂号成功");
        req.setAttribute("doctors",doctors);
        req.getRequestDispatcher("patient_regist.jsp").forward(req, resp);
    }
}
