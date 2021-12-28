package org.example.controller.regist;

import org.example.dao.registrationDao;
import org.example.domain.patient;
import org.example.utils.jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/patient_regist")
public class patient_regist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        registrationDao registrationDao=new registrationDao();
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String dname=req.getParameter("dname");
        String pname=(String)req.getSession().getAttribute("patientName");
        System.out.println(req.getSession().getAttribute("patientName"));
        String massage=req.getParameter("massage");
        System.out.println(dname+pname+massage);
        registrationDao.regist(dname,pname,massage);
        System.out.println("挂号成功");
        req.getRequestDispatcher("patient.html").forward(req, resp);
    }
}
