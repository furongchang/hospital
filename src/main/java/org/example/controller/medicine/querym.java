package org.example.controller.medicine;

import org.example.dao.medicineDao;
import org.example.domain.medicine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/medicine_show")
public class querym extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        medicineDao medicineDao = new medicineDao();
        String name = req.getParameter("name");
        System.out.println("name:"+name);
        List<medicine> medicineList = medicineDao.querym(name);
        req.setAttribute("medicine", medicineList);
        req.getRequestDispatcher("medicine_show.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
