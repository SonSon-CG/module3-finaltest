package com.example.module3finaltest.controller;

import com.example.module3finaltest.model.MatBang;
import com.example.module3finaltest.service.IMatBangService;
import com.example.module3finaltest.service.MatBangServiceDB;
import com.example.module3finaltest.service.MatBangServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "matbang" , value = "/matbang")
public class MatBangServlet extends HttpServlet {
    private static final IMatBangService service = new MatBangServiceDB();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            showMatBang (req,resp);
        }else{
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/create.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    private void showMatBang(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  IMatBangService service = new MatBangServiceDB();
        List<MatBang> matBangs = service.findAll();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/list.jsp");
        req.setAttribute("matBangs", matBangs);
        requestDispatcher.forward(req,resp);
    }
}
