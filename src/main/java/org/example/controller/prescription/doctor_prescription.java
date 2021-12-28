package org.example.controller.prescription;

import org.example.dao.prescriptionDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/doctor_prescription")
public class doctor_prescription extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        prescriptionDao prescriptionDao=new prescriptionDao();
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String dname=(String)req.getSession().getAttribute("doctorName");
        String pname=req.getParameter("pname");
        String prescription=req.getParameter("prescription");
        prescriptionDao.prescription(dname,pname,prescription);
        req.getRequestDispatcher("doctor.html").forward(req, resp);
    }
}
