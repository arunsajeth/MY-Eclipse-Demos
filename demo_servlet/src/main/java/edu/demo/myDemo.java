package edu.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class myDemo extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		String username = req.getParameter("MyName");
		
		//res.getWriter().println("<h1>Hi Hello Welcome to "+username+" to J2EE World</h1>");
		//System.out.println(username);
		
		PrintWriter out = res.getWriter();
		//out.println("<h1>Hi Hello Welcome to "+username+" to J2EE World</h1>");
		//out.println("Thank you.");
		
		//out.println("<html>");
		//out.println("<body>");
		//out.println("<b><i> "+username+"</i></b>");
		//out.println("<body>");
		//out.println("</html>");

		String choice = req.getParameter("oper");
		
		int n1 = Integer.parseInt(req.getParameter("num1"));
		int n2 = Integer.parseInt(req.getParameter("num2"));
		String result =null;
		switch(choice)
		{
			case "add":
				result="Sum is"+(n1+n2);
				break;
			case "sub":
				result="Difference"+(n1-n2);
				break;
			case "multiply":
				result="Product is"+(n1*n2);
				break;
			case "divide":
				result="Quotient is"+(n1/n2);
				break;	
		}
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"+"<center>"
				+ "<h1>Hi Hello Welcome to J2EE</h1>\r\n"
				+ "<form  action=\"./myName\" method=\"get\">\r\n"
				+ "<!--input type=\"text\" name=\"MyName\" value=\"\" placeholder=\"Enter your name\"-->\r\n"
				+ "<!--input type=\"SUBMIT\" value=\"Click me\"-->\r\n"
				+ "<label>Enter the number 1</label>\r\n"
				+ "<input type=\"text\" name=\"num1\" value=\"\" placeholder=\"Enter number 1\">\r\n"
				+ "<br>\r\n"
				+ "<label>Enter the number 2</label>\r\n"
				+ "<input type=\"text\" name=\"num2\" value=\"\" placeholder=\"Enter number 2\">\r\n"
				+ "<br>\r\n"
				+ "<input type=\"radio\"  value=\"add\" name=\"oper\">addition\r\n"
				+ "<br>\r\n"
				+ "<input type=\"radio\" value=\"sub\" name=\"oper\">subtraction\r\n"
				+ "<br>\r\n"
				+ "<input type=\"radio\" value=\"multiply\" name=\"oper\">multiply\r\n"
				+ "<br>\r\n"
				+ "<input type=\"radio\" value=\"divide\" name=\"oper\">division\r\n"
				+ "<br>\r\n"
				+ "<input type=\"submit\" value=\"Calculate\">\r\n"
				+ "<input type=\"reset\" value=\"Reset\">\r\n"
				+ "<br>\r\n"
				+ "</form>\r\n"+"<br>"+result+"</center>"
				+ "</body>\r\n"
				+ "</html>");
	}

}
