package crud;

public class Employee 
{
	private int eid;
	private String eName;
	private String eDest;
	private int eSal;
	
	// Default Constructor
	Employee()
	{
		
	}
	// Parameterized Constructor
	Employee(int eid, String eName, String eDest, int eSal)
	{
		this.eid = eid;
		this.eName = eName;
		this.eDest = eDest;
		this.eSal = eSal;
	}
	
	// Setter methods
	public void setId(int eid)
	{
		this.eid = eid;
	}
	public void setName(String eName)
	{
		this.eName = eName;
	}
	public void setDest(String eDest)
	{
		this.eDest=eDest;
	}
	public void setSalary(int eSal)
	{
		this.eSal = eSal;
	}
	
	// Getter methods
	public int getId()
	{
		return eid;
	}
	public String getName()
	{
		return eName;
	}
	public String getDest()
	{
		return eDest;
	}
	public int getSalary()
	{
		return eSal;
	}
	
	public String toString()
	{
		return eid+" "+eName+" "+eDest+" "+eSal;
	}
}
