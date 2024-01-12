package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Display 
{
	public static void display_Employee()
	{
		try
		{
			Connection con = JdbcConnection.getConnection();
			
			PreparedStatement ps2 = con.prepareStatement("select * from employee");
			ResultSet rs = ps2.executeQuery();
			System.out.format("%-20s %-10s %-12s %-12s\n","ID","NAME","DEST","SALARY");
			while(rs.next())
			{				
				System.out.format("%-20s %-10s %-12s %-12s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
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
