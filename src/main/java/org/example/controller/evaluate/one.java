package org.example.controller.evaluate;

import org.example.dao.evaluateDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/one")
public class one extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=(String)req.getSession().getAttribute("patientName");
        String  id=(String) req.getSession().getAttribute("id");
        evaluateDao evaluateDao=new evaluateDao();
        evaluateDao.evaluate(1,id);
        req.getRequestDispatcher("patient.html").forward(req,resp);
    }
}
