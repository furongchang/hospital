package org.example.controller.prescription;

import org.example.dao.medicineDao;
import org.example.dao.prescriptionDao;
import org.example.dao.registrationDao;
import org.example.domain.medicine;
import org.example.domain.registration;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/patient_regist_show_massage")
public class patient_regist_show_massage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        registrationDao registrationDao=new registrationDao();
        List<registration> registrations =registrationDao.call((String)req.getSession().getAttribute("doctorName"));
        medicineDao medicineDao=new medicineDao();
        List<medicine> medicines=medicineDao.querym_all();
        prescriptionDao prescriptionDao=new prescriptionDao();
        String[] autu_medicines=prescriptionDao.random();
        System.out.println(Arrays.toString(autu_medicines));
        req.setAttribute("registrations",registrations);
        req.setAttribute("medicines",medicines);
        req.setAttribute("autu_medicines",autu_medicines);
        req.getRequestDispatcher("doctor_prescription.jsp").forward(req, resp);
    }
}
