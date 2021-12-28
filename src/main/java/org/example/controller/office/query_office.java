package org.example.controller.office;

import org.example.dao.officeDao;
import org.example.domain.office;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/query_office")
public class query_office extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        officeDao officeDao=new officeDao();
        String name = req.getParameter("name");
        System.out.println("name:"+name);
        List<office> offices =officeDao.query_office(name);
        req.setAttribute("offices",offices);
        req.getRequestDispatcher("office_show.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
