package org.example.controller.prescription;

import org.example.dao.prescriptionDao;
import org.example.domain.prescription;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/view_prescription")
public class view_prescription extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=(String)req.getSession().getAttribute("patientName");
        prescriptionDao prescriptionDao=new prescriptionDao();
        List<prescription> prescriptions=prescriptionDao.view_prescription(name);
        req.setAttribute("prescriptions",prescriptions);
        req.getRequestDispatcher("/view_prescription.jsp").forward(req,resp);
    }
}
