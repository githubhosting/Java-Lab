import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class VoterSrv extends HttpServlet

{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		if (age >= 18) {
			pw.println("<font color='green' size='4'>Welcome " + name + " to this site</font>");
		} else
			pw.println(
					"<font color='red' size='4'>Hello " + name + ", you are not authorized to visit the site</font>");
		pw.println("<br><br><a href= 'index.html'>back</a>");
		pw.close();
	}
}