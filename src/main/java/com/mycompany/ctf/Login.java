package com.mycompany.ctf;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {
    String jsession;
    
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
        PrintWriter out = response.getWriter();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            String username = HashPass(request.getParameter("username"));
            String password = HashPass(request.getParameter("password"));
            
            if(username.equals("EFD2E68712D69117F70381C53A3CB2")&&password.equals("DF8D74725C5F6B3F8BA7F6F52151892D")){ 
                Cookie[] cookies = request.getCookies();
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                if(cookies != null){
                    for(Cookie cookie : cookies){
                        if(cookie.getName().equals("JSESSIONID")){
                            jsession = cookie.getValue();
                        }else{
                            out.println("no JSESSIONID cookies!");
                        }
                    }
                }else{
                    out.println("null cookies!");
                }
                response.sendRedirect("form3.jsp");
                
            }else{
                response.sendRedirect("level1.jsp");
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
