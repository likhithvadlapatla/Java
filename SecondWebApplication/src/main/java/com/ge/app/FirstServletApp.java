package com.ge.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/firstServlet")
public class FirstServletApp extends HttpServlet {

    public FirstServletApp(){
        System.out.println("Servlet object is created internally by container.");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("uname");
        String city = request.getParameter("ucity");

        PrintWriter writer = response.getWriter();
        writer.println("Hello "+name);
        writer.println(" I know you're from "+city);

        writer.close();
    }
}