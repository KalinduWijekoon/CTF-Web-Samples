<%-- 
    Document   : level2
    Created on : May 28, 2019, 12:26:45 PM
    Author     : Kali
--%>

<%@page import="java.io.* , java.util.* , java.awt.*" contentType="text/html" pageEncoding="UTF-8"%>
<%
   // Get session creation time.
   Date createTime = new Date(session.getCreationTime());
   
   // Get last access time of this Webpage.
   Date lastAccessTime = new Date(session.getLastAccessedTime());


   Integer visitCount = new Integer(0);
   String visitCountKey = new String("visitCount");

   // Check if this is new comer on your Webpage.
   if (session.getAttribute(visitCountKey) == null ){
      session.setAttribute(visitCountKey,  visitCount);
   }
   visitCount = (Integer)session.getAttribute(visitCountKey);
   visitCount = visitCount + 1;
   session.setAttribute(visitCountKey,  visitCount);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bismarck 02</title>
    </head>
    <%
    if(session.getAttribute("username4")==null){
        response.sendRedirect("level4.jsp");
    }
    %>
    <body background="imgz/giphy (1).gif">         
         <% 
         Integer hitsCount = visitCount;
         if( hitsCount ==null){
            /* First visit */
            out.println("<font color = white><b><h1>Welcome to my website!</h1></b></font>");
            hitsCount = 1;
         }
         else if (hitsCount == 1){
             out.println("<font color = white><b><h1>RUN RABBIT RUN!</h1></b></font>");
             hitsCount = 2;
         }
         else if(hitsCount%10000==0){
            /* return visit */
            out.println("<font color = white><b><p id=\"flag\">FLAG:rabbit-ran-for-soo-long_menna_kodiyaa_hoyagaththaaa</p></b></font>");
            hitsCount += 1;
         } else if(hitsCount>1) {
             out.println("<font color = white><h1><b>RUN RABBIT RUN!</h1></b></font>");
            hitsCount += 1;
         }
      %>
      <center>
          <font color = white><p><h1><b>Total number of visits: <%= hitsCount%></h1></b></p></font>
      </center>
      <!-- 
      MAGIC HAPPENS HERE
        if(hitsCount%10000==0){
            out.println("<font color = white><b><p id=\"flag\">FLAG:some value will be your flag</p></b></font>");
            hitsCount += 1;
         }
      You need to consider <p id> (just in case)
      -->
    </body>
</html> 