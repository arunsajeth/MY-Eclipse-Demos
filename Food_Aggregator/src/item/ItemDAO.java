package item;

import java.sql.*;
import java.util.*;

public class ItemDAO 
{
	public void addItem(Item items) throws SQLException
	{
		Connection con = JdbcConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into food values (?,?,?)");
		ps.setString(1, items.getname());
		ps.setDouble(2, items.getprice());
		ps.setString(3, items.gettype());
		ps.executeUpdate();
	}
	
	public void bulkCopy(List<Item> itemList) throws SQLException
	{
		ItemDAO d = new ItemDAO();
		for(Item i:itemList)
		{
			d.addItem(i);
		}
	}
	
	public List<Item> findItem(String search_type) throws SQLException
	{
		List<Item> search = new ArrayList<>();
		Connection con  = JdbcConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from food where type = ? ");
		ps.setString(1, search_type);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			search.add(new Item(rs.getString(1),rs.getDouble(2),rs.getString(3)));
		}
		return search;
	}
	
	public List<Item> findItem(Double search_price) throws SQLException
	{
		
		List<Item> search = new ArrayList<>();
		Connection con  = JdbcConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from food where price = ? ");
		ps.setDouble(1, search_price);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			search.add(new Item(rs.getString(1),rs.getDouble(2),rs.getString(3)));
		}
		return search;	
	}
	
}
