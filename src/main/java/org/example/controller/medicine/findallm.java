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
@WebServlet("/findallm")
public class findallm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        medicineDao medicineDao = new medicineDao();
        List<medicine> medicineList = medicineDao.querym_all();
        req.setAttribute("medicine", medicineList);
        req.getRequestDispatcher("medicine_show.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
