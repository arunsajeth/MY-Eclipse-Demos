package context;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/log")

public class Login_Context extends HttpServlet
{
Connection con = null;
	
	public void init()
	{	
		ServletContext sq = getServletContext();
		String driverclass = (String)sq.getInitParameter("dClass");
		String URL = (String)sq.getInitParameter("url");
		String userName = (String)sq.getInitParameter("user");
		String pass = (String)sq.getInitParameter("pwd");
		try {
			Class.forName(driverclass);
			con=DriverManager.getConnection(URL,userName,pass);
			System.out.println("connected successfull");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		try {
			PreparedStatement ps = con.prepareStatement("select Password from employeedata where Last_name=?;");
			String un = req.getParameter("username");
			ps.setString(1, un);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				String pass=req.getParameter("password");
				System.out.println(pass);
				String hh = rs.getString(1);
				System.out.println(hh);
				if(pass.equals(hh))
				{
					res.getWriter().println("<h1>Welcome "+req.getParameter("username")+"</h1>"
							+"<img src=\"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRZXMXyQYloH5ppYTaUy1JhRLgHApYQuO7Dow&usqp=CAU\">");
				}
				else
				{
					res.getWriter().println("<!DOCTYPE html>\r\n"
							+ "<html>\r\n"
							+ "<head>\r\n"
							+ "<meta charset=\"ISO-8859-1\">\r\n"
							+ "<title>Login for EMS</title>\r\n"
							+ "</head>\r\n"
							+ "<body style=\"background-color: lightcyan;\">\r\n"
							+ "<center>\r\n"
							+ "	<h1 style=\"background-color: ivory; border: 5px solid white;\">LOGIN EMS</h1>\r\n"
							+ "Invalid Password"
							+ "	<form action=\"./log\">\r\n"
							+ "		<table style=\"background-color: ivory; border: 5px solid black;\">\r\n"
							+ "			<tr>\r\n"
							+ "				<td><td><label>USER NAME</label></td>\r\n"
							+ "				<td><input type=\"text\" name=\"username\" value=\"\" placeholder=\"Enter the user name\"></td>\r\n"
							+ "			</tr>\r\n"
							+ "			<tr>\r\n"
							+ "				<td><td><label>PASSWORD</label></td>\r\n"
							+ "				<td><input type=\"text\" name=\"password\" value=\"\" placeholder=\"Enter the password\"></td>\r\n"
							+ "			</tr>\r\n"
							+ "		</table>\r\n"
							+ "		<br>\r\n"
							+ "		<input type=\"Submit\" value=\"SUBMIT\">\r\n"
							+ "		<input type=\"reset\" values=\"RESET\">\r\n"
							+ "		<br>\r\n"
							+ "		<a href=\"Example.html\">New User</a>\r\n"
							+ "	</form>\r\n"
							+ "</center>\r\n"
							+ "</body>\r\n"
							+ "</html>");
				}
			}
			else
			{
				res.getWriter().println("<!DOCTYPE html>\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"ISO-8859-1\">\r\n"
						+ "<title>Login for EMS</title>\r\n"
						+ "</head>\r\n"
						+ "<body style=\"background-color: lightcyan;\">\r\n"
						+ "<center>\r\n"
						+ "	<h1 style=\"background-color: ivory; border: 5px solid white;\">LOGIN EMS</h1>\r\n"
						+ "Invalid Username"
						+ "	<form action=\"./log\">\r\n"
						+ "		<table style=\"background-color: ivory; border: 5px solid black;\">\r\n"
						+ "			<tr>\r\n"
						+ "				<td><td><label>USER NAME</label></td>\r\n"
						+ "				<td><input type=\"text\" name=\"username\" value=\"\" placeholder=\"Enter the user name\"></td>\r\n"
						+ "			</tr>\r\n"
						+ "			<tr>\r\n"
						+ "				<td><td><label>PASSWORD</label></td>\r\n"
						+ "				<td><input type=\"text\" name=\"password\" value=\"\" placeholder=\"Enter the password\"></td>\r\n"
						+ "			</tr>\r\n"
						+ "		</table>\r\n"
						+ "		<br>\r\n"
						+ "		<input type=\"Submit\" value=\"SUBMIT\">\r\n"
						+ "		<input type=\"reset\" values=\"RESET\">\r\n"
						+ "		<br>\r\n"
						+ "		<a href=\"Example.html\">New User</a>\r\n"
						+ "	</form>\r\n"
						+ "</center>\r\n"
						+ "</body>\r\n"
						+ "</html>");
			}
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
