/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.myexpoonline.store.backoffice.controller;

import com.myexpoonline.store.core.entity.Author;
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
@WebServlet(name = "AddworkServlet", urlPatterns = {"/add-work"})
public class AddworkServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>oeuvre ajoutée</title>");            
            out.println("</head>");
              out.println("<a href='/home'> Retour à L'accueil </a></br>");
            out.println("<a href='catalogue'> Retour au catalogue </a>");
          
            out.println("<h1>Bravo votre oeuvre a bien été enregistrée</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        

    }
   
  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          // je récupère les valeurs de mes paramètres
        String title = request.getParameter("title");
        int year = Integer.parseInt(request.getParameter("year"));
        String style = request.getParameter("style");
        String authorName = request.getParameter("author");
        String description = request.getParameter("description");
        
        // objectif : créer une nouvelle oeuvre avec ces données
        // et de les ajouter au catalogue
        
        Work myWork = new Work(title);
        myWork.setStyle(style);
        myWork.setDescription(description);
        myWork.setYear(year);
        
        Author author = new Author();
        author.setName(authorName);
        
        myWork.setAuthor(author);
        myWork.setId(Work.lastId);
        
        // ajouter notre oeuvre au catalogue
        Catalogue.listOfWorks.add(myWork);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
