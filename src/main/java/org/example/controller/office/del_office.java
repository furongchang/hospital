package org.example.controller.office;

import org.example.dao.medicineDao;
import org.example.dao.officeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/del_office")
public class del_office extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        officeDao officeDao= new officeDao();
        String id = req.getParameter("id");
        System.out.println("id:"+id);
        officeDao.del_office(id);
        System.out.println("删除成功");
        req.getRequestDispatcher("/office/office.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
