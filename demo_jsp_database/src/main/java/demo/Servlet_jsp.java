package demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet_jsp extends HttpServlet
{
	Connection con =null;
	
	public void init(ServletConfig sc)
	{
		String driverclass = (String)sc.getInitParameter("dClass");
		String URL = (String)sc.getInitParameter("url");
		String userName = (String)sc.getInitParameter("user");
		String pass = (String)sc.getInitParameter("pwd");
		try {
			Class.forName(driverclass);
			con=DriverManager.getConnection(URL,userName,pass);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest res,HttpServletResponse req) throws IOException
	{
		try {
			PreparedStatement ps = con.prepareStatement("insert into employeedata values(?,?,?,?,?)");
			ps.setString(1, res.getParameter("fname"));
			ps.setString(2, res.getParameter("lname"));
			ps.setString(3, res.getParameter("email"));
			ps.setString(4, res.getParameter("phno"));
			ps.setString(5, res.getParameter("pwd"));
			ps.executeUpdate();
			req.getWriter().println("<h1 style=\"background-color:cornsilk;\">Employee Registration successfull</h1>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void destroy()
	{
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
