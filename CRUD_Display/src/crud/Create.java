package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class Create 
{
	static Scanner S = new Scanner(System.in);
	
	public static void create_Employee()
	{
		try
		{
			Connection con = JdbcConnection.getConnection();
			System.out.print("Employee Id: ");
			int id = S.nextInt();
			Employee e =Search.idChecking(con,id);
			if(e == null)
			{
				PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?)");
				Employee emp = new Employee();
				emp.setId(id);
				System.out.print(" Emloyee Name: ");
				emp.setName(S.next());				
				System.out.print(" Employee Designation: ");
				emp.setDest(S.next());				
				System.out.print("Employee salary: ");
				emp.setSalary(S.nextInt());
				
				ps.setInt(1, emp.getId());
				ps.setString(2, emp.getName());
				ps.setString(3, emp.getDest());
				ps.setInt(4, emp.getSalary());
				ps.executeUpdate();
				
				System.out.println("Employee id created sucessfully");
			}
			else
			{
				System.out.println("Employee is already Exist!!!");
			}
			
			con.close();
		}
		catch(SQLException  e1)
		{
			System.out.println(e1);
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}
}
