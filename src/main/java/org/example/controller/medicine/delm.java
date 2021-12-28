package org.example.controller.medicine;

import org.example.dao.medicineDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/medicine_del")
public class delm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        medicineDao medicineDao = new medicineDao();
        String id = req.getParameter("id");
        System.out.println("id:"+id);
        medicineDao.delm(id);
        System.out.println("删除成功");
        req.getRequestDispatcher("/medicine/medicine.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
