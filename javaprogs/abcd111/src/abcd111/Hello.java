package abcd111;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Hello extends HttpServlet
{
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException
 {
 response.setContentType("text/html");
 PrintWriter out = response.getWriter();
 try
 {

 String user = request.getParameter("user");
 out.println("<h2> Welcome "+user+"</h2>");
 }
 finally
 {
 out.close();
 }
 }
}
