package CRUD;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/search")

public class Search_Operation extends HttpServlet
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
		String temp=req.getParameter("eId");
		int id = Integer.parseInt(temp);
		PreparedStatement ps;
		try 
		{
			ps = con.prepareStatement("select * from employee where eid = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			PrintWriter out = res.getWriter();
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
				int Id = rs.getInt(1);
				String name = rs.getString(2);
				String des = rs.getString(3);
				int salary = rs.getInt(4);
				out.println("<tr>"
						+ "<td>"+Id+"</td>"
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
