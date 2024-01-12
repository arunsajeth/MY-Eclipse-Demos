package context;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ems")
public class Servlet_Context extends HttpServlet
{
Connection con =null;
	
	public void init()
	{	ServletContext sc = getServletContext();
		String driverclass = (String)sc.getInitParameter("dClass");
		String URL = (String)sc.getInitParameter("url");
		String userName = (String)sc.getInitParameter("user");
		String pass = (String)sc.getInitParameter("pwd");
		try {
			Class.forName(driverclass);
			con=DriverManager.getConnection(URL,userName,pass);
			System.out.println("Connected!!!!!!!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		try {
			PreparedStatement ps = con.prepareStatement("insert into employeedata values(?,?,?,?,?)");
			ps.setString(1, req.getParameter("fname"));
			ps.setString(2, req.getParameter("lname"));
			ps.setString(3, req.getParameter("email"));
			ps.setString(4, req.getParameter("phno"));
			ps.setString(5, req.getParameter("pwd"));
			int temp = ps.executeUpdate();
			
			if(temp>0)
			{
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.forward(req,res);
			}
			else
			{
				RequestDispatcher rd = req.getRequestDispatcher("index.html");
				rd.include(req, res);
			}
		}
		catch (SQLException e) {
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
