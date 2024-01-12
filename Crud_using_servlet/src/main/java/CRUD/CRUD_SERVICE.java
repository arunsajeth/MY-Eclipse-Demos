package CRUD;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/demo")

public class CRUD_SERVICE extends HttpServlet
{
	
	static Connection con = null;
	
	public void init()
	{	
		ServletContext sq = getServletContext();
		String driverclass = (String)sq.getInitParameter("dclass");
		String URL = (String)sq.getInitParameter("url");
		String userName = (String)sq.getInitParameter("user");
		String pass = (String)sq.getInitParameter("pwd");
		try 
		{
			Class.forName(driverclass);
			con=DriverManager.getConnection(URL,userName,pass);
			System.out.println("Connected successfull");
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		String choice = req.getParameter("oper");
		PrintWriter out = res.getWriter();
		switch(choice)
		{
			case "CREATE":
				out.println("Create");
				break;
			case "UPDATE":
				out.println("Update");
				break;
			case "SEARCH":
				RequestDispatcher rd = req.getRequestDispatcher("search.html");
				rd.forward(req,res);
				break;
				
			case "DELETE":
				out.println("Delete");
				break;
			
			case "DISPLAY":
				dispemployee(out);
				break;
		}
	}
	
	public static void dispemployee(PrintWriter out)
	{
		try 
		{
			PreparedStatement ps = con.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			out.println("<body style=\"background-color: lightcyan;\">"
					+ "<center>"
					+ "<table style=\"background-color: ivory; border: 5px solid black;\">"
					+ "<tr>"
					+ "<th>EMPLOYEE ID</th>"
					+ "<th>EMPLOYEE NAME</th>"
					+ "<th>EMPLOYEE DESTIGNATION</th>"
					+ "<th>EMPLOYEE SALARY</th>"
					+ "</tr>");
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String des = rs.getString(3);
				int salary = rs.getInt(4);
				out.println("<tr style=\\\"border: 5px solid black;\\\">"
						+ "<td>"+id+"</td>"
						+ "<td>"+name+"</td>"
						+ "<td>"+des+"</td>"
						+ "<td>"+salary+"</td>"
						+ "</tr>");
			}
		}
		catch (SQLException e) 
		{
		e.printStackTrace();
		}
	}
}
