package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete 
{
	static Scanner S = new Scanner (System.in);
	
	public static void delete_Employee()
	{
		try
		{
			Connection con = JdbcConnection.getConnection();
			System.out.println("Enter the Employee id to be deleted");
			int id = S.nextInt();
			Employee ep = Search.idChecking(con,id);
			if(ep != null)
			{
				PreparedStatement ps3 = con.prepareStatement("delete from employee where eid = ?");
				ps3.setInt(1,ep.getId());
				ps3.executeUpdate();
				System.out.println("Employee Id deleted sucesfully");
			}
			else
			{
				System.out.println("Employee id not Found!!!");
			}
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
