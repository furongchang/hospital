package org.example.duty;

import org.example.dao.doctorDao;
import org.example.domain.doctor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/duty_choice")
public class duty_choice extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String[] names = req.getParameterValues("name");
        System.out.println(Arrays.toString(names));
        doctorDao doctorDao = new doctorDao();
        String name = "";
        if (names.length > 0) {
            for (String s : names) {
                System.out.println(s);
                name = s;
                doctorDao.duty(name);
            }
        }
        List<doctor> doctors=doctorDao.duty_show();
        req.setAttribute("doctors",doctors);
        req.getRequestDispatcher("duty_doctor_show.jsp").forward(req,resp);
    }
}
