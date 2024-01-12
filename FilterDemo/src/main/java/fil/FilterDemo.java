package fil;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterDemo extends HttpFilter
{
	protected void doFilter(HttpServletRequest req,HttpServletResponse res,FilterChain chain) throws IOException, ServletException
	{
		if(req.getParameter("user").length()>=3)
		{
			chain.doFilter(req,res);
		}
		else
		{
			res.getWriter().println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Insert title here</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<center>\r\n"
					+ "	<h1>LOGIN PAGE</h1>\r\n"
					+ "	<form action=\"./filterdemo\">\r\n"
					+ "		<input type=\"text\" name=\"user\" value=\"\" placeholder=\"Enter the username\">\r\n"
					+"<br>"
					+ "Username should be length more than three"
					+ "		<br><br>\r\n"
					+ "		<input type=\"submit\" value=\"SUBMIT\">\r\n"
					+ "	</form>\r\n"
					+ "	</center>\r\n"
					+ "</body>\r\n"
					+ "</html>");
		}
	}
}
