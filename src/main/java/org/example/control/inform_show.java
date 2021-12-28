package org.example.control;

import org.example.dao.prescriptionDao;
import org.example.dao.registrationDao;
import org.example.domain.prescription;
import org.example.domain.registration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/inform_show")
public class inform_show extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        registrationDao registrationDao =new registrationDao();
        List<registration> registrations =registrationDao.call_all();
        req.setAttribute("registrations",registrations);

        prescriptionDao prescriptionDao=new prescriptionDao();
        List<prescription> prescriptions=prescriptionDao.view_all_prescription();
        req.setAttribute("prescriptions",prescriptions);

        req.getRequestDispatcher("/inform_show.jsp").forward(req,resp);

    }
}
