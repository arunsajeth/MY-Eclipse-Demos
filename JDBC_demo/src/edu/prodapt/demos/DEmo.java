package edu.prodapt.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DEmo {

	public static void main(String[] args) throws SQLException {
		
		Scanner s = new Scanner(System.in);
		
		// for assigning id, name , mark 
//		System.out.print("Enter the id:");
//		int id = s.nextInt();
//		
//		System.out.print("Enter the name:");
//		String name = s.next();
//		
//		System.out.print("Enter the mark:");
//		int Mark = s.nextInt();
		
		System.out.println("Enter the mark to search");
		int search = s.nextInt();
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//System.out.println("Loaded Successful");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prodapt","root","root");
		//System.out.println("Connection successful");
		
		// one way to create table in columns
		//String sql="INSERT INTO prodapt.student VALUES("+id+",'"+name+"',"+Mark+")";
		//Statement statement = con.createStatement();
		//statement.executeUpdate(sql);
		//ResultSet rs = statement.executeQuery("select * from student");
		//System.out.println("\nStudent details ");
//		while(rs.next())
//		{
//			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
//		}
//		statement.close();
//		con.close();
		
		// for creation of 1 row in table 
//		PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?)");
//		ps.setInt(1, id);
//		ps.setString(2, name);
//		ps.setInt(3, Mark);
//		int temp = ps.executeUpdate();
		
		PreparedStatement ps1 = con.prepareStatement("select * from student where marks > ?");
		ps1.setInt(1, search);
		ResultSet rs = ps1.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
		
		
		}
		catch(ClassNotFoundException| SQLException  e)
		{
			System.out.println(e);
		}
		
	}

}
