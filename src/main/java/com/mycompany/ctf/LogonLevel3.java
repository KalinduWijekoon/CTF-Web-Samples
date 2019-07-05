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
@WebServlet(name = "LogonLevel3", urlPatterns = {"/LogonLevel3"})
public class LogonLevel3 extends HttpServlet {
String jsession3;
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LogonLevel3</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LogonLevel3 at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String username = HashPass(request.getParameter("username"));
            String password = HashPass(request.getParameter("password"));
            if(username.equals("2F1FBFAD5764BCE2A12EA4CDA535CC25")&&password.equals("6C5CDBE919142AD0FDE07F766CFCDB5")){
                Cookie[] cookies = request.getCookies();
                HttpSession session = request.getSession();
                session.setAttribute("username3", username);
                if(cookies != null){
                    for(Cookie cookie : cookies){
                        if(cookie.getName().equals("JSESSIONID")){
                            jsession3 = cookie.getValue();
                        }else{
                            out.println("no JSESSIONID cookies!");
                        }
                    }
                }else{
                    out.println("null cookies!");
                }
                response.sendRedirect("form.jsp");
            }else{
                response.sendRedirect("level3.jsp");
            }
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }finally{
            out.close();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
