package org.example.controller.medicine;

import org.example.dao.prescriptionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/autu")
public class autu_medicines extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        prescriptionDao prescriptionDao=new prescriptionDao();
        String[] autu_medicines=prescriptionDao.random();
        req.setAttribute("autu_medicines",autu_medicines);
        req.getRequestDispatcher("/medicine/autu_medicines.jsp").forward(req, resp);
    }
}
