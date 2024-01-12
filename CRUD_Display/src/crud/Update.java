package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update 
{
	static Scanner S = new Scanner (System.in);
	
	public static  void update_Employee(int up_choice, int up_id)
	{
		try
		{
			Connection con = JdbcConnection.getConnection();
			Employee ep = Search.idChecking(con,up_id);
			if(ep != null)
			{
				Employee emp = new Employee();
				emp.setId(up_id);
				switch(up_choice)
				{
					case 1:
						System.out.print("updated name: ");
						emp.setName(S.next());
						PreparedStatement ps4 = con.prepareStatement("update employee set eName=? where eid=?");
						ps4.setString(1, emp.getName());
						ps4.setInt(2, emp.getId());
						ps4.executeUpdate();
						break;
						
					case 2: 
						System.out.print("update destignation: ");
						emp.setDest(S.next());
						PreparedStatement ps5 = con.prepareStatement("update employee set eDest=? where eid=?");
						ps5.setString(1, emp.getDest());
						ps5.setInt(2,emp.getId());
						ps5.executeUpdate();
						break;
						
					case 3: 
						System.out.print("update salary: ");
						emp.setSalary(S.nextInt());
						PreparedStatement ps6 = con.prepareStatement("update employee set eSal=? where eid=?");
						ps6.setInt(1, emp.getSalary());
						ps6.setInt(2,emp.getId());
						ps6.executeUpdate();
						break;
				}
			}
			else
			{
				System.out.println("Employee Id not Found!!!");
			}
			con.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}
}
