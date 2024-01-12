package item;

public class Item 
{
	private String name;
	private Double price;
	private String type;
	
	// default constructor
	Item()
	{
		
	}
	
	// parameterized constructor
	Item(String name, Double price, String type)
	{
		this.name = name;
		this.price = price;
		this.type = type;
	}
	
	// Setter methods
	public void setname(String name)
	{
		this.name = name;
	}
	public void setprice(Double price)
	{
		this.price = price;
	}
	public void settype(String type)
	{
		this.type = type;
	}
	
	// Getter methods
	public String getname()
	{
		return name;
	}
	public Double getprice()
	{
		return price;
	}
	public String gettype()
	{
		return type;
	}
	
	
	public String toString()
	{
		return name+" "+price+" "+type;
	}
}
