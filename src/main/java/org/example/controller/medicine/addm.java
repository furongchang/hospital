package org.example.controller.medicine;

import org.example.dao.medicineDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/addm")
public class addm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        medicineDao medicineDao=new medicineDao();
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String introduce = req.getParameter("introduce");
        medicineDao.addm(id,name,introduce);
        req.getRequestDispatcher("medicine/medicine.html").forward(req, resp);
    }
}
