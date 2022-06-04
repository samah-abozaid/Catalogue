/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.myexpoonline.store.frontoffice.controller;

import com.myexpoonline.store.core.entity.Catalogue;
import com.myexpoonline.store.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrateur
 */
@WebServlet(name = "workinfoServlet", urlPatterns = {"/workinfo"})
public class workinfoServlet extends HttpServlet {

    
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
            out.println("<title>Servlet workinfoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
         
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
       protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // je récupère la valeur du paramètre id en url depuis mon catalogue
        int id = Integer.parseInt(request.getParameter("id"));
        // Dans la méthode filter
        // on a une expression lambda qui définit le comportement de la méthode filter
        // lorsque l'on définit le comportement d'une méthode dans une interface
        // sans créer de clase qui implémente l'interface
        // -> expression lambda
        Work myWork = Catalogue.listOfWorks.stream().filter(work -> work.getId() == id).findFirst().get();
        // Work myWork;
        // for(Work work : Catalogue.listOfWorks) {
            // if(work.getId() == id) {
                // myWork = work;
            // }
        // }
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> " + myWork.getTitle() + " </title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<p> Title : " + myWork.getTitle() + " </p>");
            out.println("<p> Year : " + myWork.getYear() + " </p>");
            out.println("<p> Style : " + myWork.getStyle() + " </p>");
            out.println("<p> Autheur : " + myWork.getAuthor().getName() + " </p>");
            out.println("<p> Description : " + myWork.getDescription() + " </p>");
            out.println("</body>");
            out.println("</html>");
    }
        // Dépannage avant l'API Stream
        /*for(Work work: Catalogue.listOfWorks){
            if(work.getId() == id){
                myWork = work;
            }
        }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            
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
