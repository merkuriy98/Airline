package com.merkulov.airline.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test")
public class TestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hello = "Hello, World!";
        req.setAttribute("hello", hello);
        req.getRequestDispatcher("WEB-INF/jsp/test.jsp").forward(req,resp);
    }
}
