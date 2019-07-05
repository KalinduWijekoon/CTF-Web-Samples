/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ctf;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kali
 */
@WebServlet(name = "LoginLevel4", urlPatterns = {"/LoginLevel4"})
public class LoginLevel4 extends HttpServlet {
String jsession4;


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
            out.println("<title>Servlet LoginLevel4</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginLevel4 at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException  {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String username = HashPass(request.getParameter("username"));
            String password = HashPass(request.getParameter("password"));
            if(username.equals("E6E55396B8D827AB60FAC351C6AF7")&&password.equals("C0E27DF1E2A4E9C1BA919F7192EDF41")){
                Cookie[] cookies = request.getCookies();
                HttpSession session = request.getSession();
                session.setAttribute("username4", username);
                if(cookies != null){
                    for(Cookie cookie : cookies){
                        if(cookie.getName().equals("JSESSIONID")){
                            jsession4 = cookie.getValue();
                        }else{
                            out.println("no JSESSIONID cookies!");
                        }
                    }
                }else{
                    out.println("null cookies!");
                }
                response.sendRedirect("form2.jsp");
            }else{
                response.sendRedirect("level4.jsp");
            }
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        finally{
            out.close();
        }

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
