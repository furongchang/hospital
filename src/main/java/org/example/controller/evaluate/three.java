package org.example.controller.evaluate;

import org.example.dao.evaluateDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/three")
public class three extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        evaluateDao evaluateDao=new evaluateDao();
        String name=(String)req.getSession().getAttribute("patientName");
        System.out.println(name);
        String id=(String)req.getSession().getAttribute("id");
        System.out.println(id);
        evaluateDao.evaluate(3,id);
        req.getRequestDispatcher("patient.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
