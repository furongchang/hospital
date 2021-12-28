package org.example.controller.office;

import org.example.dao.officeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/add_office")
public class add_office extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        officeDao officeDao =new officeDao();
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String introduce = req.getParameter("introduce");
        officeDao.add_office(id,name,introduce);
        req.getRequestDispatcher("office/office.html").forward(req, resp);
    }
}
