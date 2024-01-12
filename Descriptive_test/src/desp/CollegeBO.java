package desp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CollegeBO 
{
	public void createData(College clg) throws SQLException
	{
		Connection con = JdbcConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into college values(?,?,?,?,?,?,?)");
		ps.setString(1, clg.getName());
		ps.setString(2, clg.getWebsite());
		ps.setString(3, clg.getMobile());
		ps.setString(4, clg.getFounder());
		ps.setInt(5, clg.getNumberOfDept());
		ps.setString(6, clg.getLocation());
		ps.setObject(7,  (Date) clg.getStartingDate());
		ps.executeUpdate();
	}
	public List<College> findCollege(List<String> nameList) throws SQLException
	{
		List<College> search = new ArrayList<>();
		Connection con = JdbcConnection.getConnection();
		for(String s:nameList)
		{
			PreparedStatement ps = con.prepareStatement("select * from college where name = ?");
			ps.setString(1, s);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				search.add(new College(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getDate(7)));
			}
		}
		return search;
	}
	
	public List<College> findCollege(Date startingDate) throws Exception
	{
		List<College> search = new ArrayList<>();
		Connection con  = JdbcConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from college where startingDate = ? ");
		ps.setObject(1, startingDate);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			search.add(new College(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),(Date)rs.getObject(7)));
		}
		return search;
	}
	
	public List<College> findCollege(String location) throws SQLException
	{
		List<College> search = new ArrayList<>();
		Connection con  = JdbcConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from college where location = ? ");
		ps.setString(1, location);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			search.add(new College(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getDate(7)));
		}
		System.out.println(search);
		return search;
	}
	
	public void sortByName(List<College> search)
	{
		Collections.sort(search,(s1, s2) -> (s1.getName().compareTo(s2.getName())));
		System.out.format("%-15s %-20s %-15s %-15s %-20s %-15s %s\n","name","website","mobile","founder","noOfDept","location","startingDate");
		for(College cg:search)
		{
			System.out.format("%-15s %-20s %-15s %-15s %-20s %-15s %s\n",cg.getName(),cg.getWebsite(),cg.getMobile(),cg.getFounder(),cg.getNumberOfDept(),cg.getLocation(),cg.getStartingDate());
		}	
	}
	
	public void sortByLocation(List<College> search)
	{
		Collections.sort(search,(s1, s2) -> (s1.getLocation().compareTo(s2.getLocation())));
		System.out.format("%-15s %-20s %-15s %-15s %-20s %-15s %s\n","name","website","mobile","founder","noOfDept","location","startingDate");
		for(College cg:search)
		{
			System.out.format("%-15s %-20s %-15s %-15s %-20s %-15s %s\n",cg.getName(),cg.getWebsite(),cg.getMobile(),cg.getFounder(),cg.getNumberOfDept(),cg.getLocation(),cg.getStartingDate());
		}
	}
	
	public void sortByDate(List<College> search)
	{
		Collections.sort(search,(s1, s2) -> (s1.getStartingDate().compareTo(s2.getStartingDate())));
		System.out.format("%-15s %-20s %-15s %-15s %-20s %-15s %s\n","name","website","mobile","founder","noOfDept","location","startingDate");
		for(College cg:search)
		{
			System.out.format("%-15s %-20s %-15s %-15s %-20s %-15s %s\n",cg.getName(),cg.getWebsite(),cg.getMobile(),cg.getFounder(),cg.getNumberOfDept(),cg.getLocation(),cg.getStartingDate());
		}
	}
	
	public void sortByNoOfDept() throws SQLException
	{
		List<College> dept = new ArrayList<>();
		Connection con = JdbcConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from college");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			dept.add(new College(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getDate(7)));
		}
		Collections.sort(dept,(s1, s2) -> (s1.getNumberOfDept()<s2.getNumberOfDept())?-1:(s1.getNumberOfDept()>s2.getNumberOfDept())?1:0);
		System.out.format("%-15s %-20s %-15s %-15s %-20s %-15s %s\n","name","website","mobile","founder","noOfDept","location","startingDate");
		for(College cg:dept)
		{
			System.out.format("%-15s %-20s %-15s %-15s %-20s %-15s %s\n",cg.getName(),cg.getWebsite(),cg.getMobile(),cg.getFounder(),cg.getNumberOfDept(),cg.getLocation(),cg.getStartingDate());
		}	}
	
}
