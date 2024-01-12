package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Search 
{
	public static  Employee idChecking(Connection con, int id) throws SQLException
	{
		Employee emp = null;
		PreparedStatement ps = con.prepareStatement("select * from employee where eid = ?");
		ps.setInt(1, id);
		ResultSet r = ps.executeQuery();
		while(r.next())
		{
			emp = new Employee(r.getInt(1),r.getString(2),r.getString(3),r.getInt(4));
		}
		return emp;
	}
	
	// For searching Employee details with Employee Id
	public static void search_Employee(int search)
	{
		try
		{
			Connection con = JdbcConnection.getConnection();
			Employee ep = idChecking(con,search);
			if(ep != null)
			{
				System.out.format("%-20s %-10s %-12s %-12s\n","ID","NAME","DEST","SALARY");
				System.out.format("%-20s %-10s %-12s %-12s\n",ep.getId(),ep.getName(),ep.getDest(),ep.getSalary());
			}
			else
				System.out.println("Empoloyee not Found !!!");
			con.close();
		}
		catch(SQLException  e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
