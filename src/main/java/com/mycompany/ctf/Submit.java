package com.mycompany.ctf;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kali
 */
@WebServlet(name = "Submit", urlPatterns = {"/submit"})
public class Submit extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
   
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
            String accname = request.getParameter("accname");
            String amount = request.getParameter("amount");
            
            if(accname.equals("bismarck")&&amount.equals("117300")){
                out.println("FLAG : okay_money_transferis_compleated@baby&lesgooo");
                out.println("USERNAME 4 next level : bismarck_web_4");
            }else{
                out.println("This is not the flag, try again");
            }
        }finally{out.close();}
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
