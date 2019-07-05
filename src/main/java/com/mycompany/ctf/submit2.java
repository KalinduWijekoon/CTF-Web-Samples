/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ctf;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Kali
 */
@WebServlet(name = "submit2", urlPatterns = {"/submit2"})
public class submit2 extends HttpServlet {
    
private static String HashPass(String plaintext)throws NoSuchAlgorithmException{
    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(plaintext.getBytes());
    byte[] b = md.digest();
    StringBuffer sb = new StringBuffer();
    for (byte b1:b){
        sb.append(Integer.toHexString(b1 & 0xff).toString());
    }
    return sb.toString().toUpperCase();
}
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
            out.println("<title>Servlet submit2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet submit2 at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String un = request.getParameter("username");
            String pwd = request.getParameter("password");
            try {
                String hshpwd = HashPass(pwd);
                String hshun = HashPass(un);
                if(hshun.equals("99114FABD06D2C83389C6145A0386A59")&&hshpwd.equals("99F8546943B5A5E128EC275018698F2C")){
                    out.println("FLAG : well_hash-cracking_is_awesome-Noh");
                    out.println("USERNAME 4 next level : bismarck_web_2");
                }else{
                    out.println("nope");
                }
            } catch (NoSuchAlgorithmException ex) {
                ex.printStackTrace();
            }

        }finally{out.close();}
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
