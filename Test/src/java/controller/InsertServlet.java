/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ClassAreaDBContext;
import dal.CustomerDBContext;
import entity.Account;
import entity.Area;
import entity.Customer;
import entity.MyClass;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author HUY
 */
public class InsertServlet extends BaseAuthen {

   

    protected void doGet(HttpServletRequest request, HttpServletResponse response,Account account)
            throws ServletException, IOException {
        ClassAreaDBContext cadbc = new ClassAreaDBContext();
        ArrayList<MyClass> classes = cadbc.getAllClass();
        ArrayList<Area> areas = cadbc.getAlArea();

        request.setAttribute("classes", classes);
        request.setAttribute("areas", areas);
        request.getRequestDispatcher("View/insert.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response,Account account)
            throws ServletException, IOException {
        Customer c = new Customer();
        c.setId(Integer.parseInt(request.getParameter("id")));
        c.setName(request.getParameter("name"));
        c.setGender(request.getParameterValues("gender").equals("male"));
        c.setDob(Date.valueOf(request.getParameter("dob")));

        MyClass mc = new MyClass();
        mc.setId(Integer.parseInt(request.getParameter("cid")));
        c.setClas(mc);
//ádsadsad
        Area a = new Area();
        a.setId(Integer.parseInt(request.getParameter("aid")));
        c.setArea(a);
        System.out.println(c.getName());
        CustomerDBContext cdb = new CustomerDBContext();
        cdb.InsertCus(c);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
