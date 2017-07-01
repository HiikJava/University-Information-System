/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sibsutis.is.university.cloud.server.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vaganovdv_2
 */
public class LoginServlet extends HttpServlet
{
     
    
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
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        try 
        {
            
            String userName = request.getParameter("txtUserName");
            String password = request.getParameter("txtPassword");
            out.println("Before Login" + "<br><br>");
            out.println("IsUserInRole?.."
                    + request.isUserInRole("javaee7user") + "<br>");
            out.println("getRemoteUser?.." + request.getRemoteUser() + "<br>");
            out.println("getUserPrincipal?.."
                    + request.getUserPrincipal() + "<br>");
            out.println("getAuthType?.." + request.getAuthType() + "<br><br>");
            try
            {
                request.login(userName, password);
            }
            catch (ServletException ex)
            {
                out.println("Login Failed with a ServletException.."
                        + ex.getMessage());
                return;
            }
            out.println("After Login..." + "<br><br>");
            out.println("IsUserInRole?.."
                    + request.isUserInRole("javaee7user") + "<br>");
            out.println("getRemoteUser?.." + request.getRemoteUser() + "<br>");
            out.println("getUserPrincipal?.."
                    + request.getUserPrincipal() + "<br>");
            out.println("getAuthType?.." + request.getAuthType() + "<br><br>");
            request.logout();
            out.println("After Logout..." + "<br><br>");
            out.println("IsUserInRole?.."
                    + request.isUserInRole("javaee7user") + "<br>");
            out.println("getRemoteUser?.." + request.getRemoteUser() + "<br>");
            out.println("getUserPrincipal?.."
                    + request.getUserPrincipal() + "<br>");
            out.println("getAuthType?.." + request.getAuthType() + "<br>");
        }
        finally
        {
            out.close();

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
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>
}




