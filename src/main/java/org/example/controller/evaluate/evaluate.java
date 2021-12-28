package org.example.controller.evaluate;

import org.example.dao.evaluateDao;
import org.example.dao.registrationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/evaluate")
public class evaluate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        registrationDao registrationDao= new registrationDao();
        registrationDao.cure(Integer.parseInt(id));
        System.out.println("evaluate.java:"+id);
        req.getSession().setAttribute("id",id);
        req.getRequestDispatcher("evaluate.html").forward(req,resp);
    }
}
