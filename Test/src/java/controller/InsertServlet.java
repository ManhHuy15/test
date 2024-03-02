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
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author HUY
 */
public class InsertServlet extends BaseAuthen {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response,Account account)
            throws ServletException, IOException {
        ClassAreaDBContext cadbc = new ClassAreaDBContext();
        ArrayList<MyClass> classes = cadbc.getAllClass();
        ArrayList<Area> areas = cadbc.getAlArea();

        request.setAttribute("classes", classes);
        request.setAttribute("areas", areas);
        request.getRequestDispatcher("View/insert.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
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