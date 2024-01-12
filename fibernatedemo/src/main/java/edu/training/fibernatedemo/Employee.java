package edu.training.fibernatedemo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int eid;
	String ename;
	int salary;
	@OneToOne
	Department dep;
	
	public Employee()
	{
		super();
	}
	
	

	public Department getDep() {
		return dep;
	}



	public void setDep(Department dep) {
		this.dep = dep;
	}



	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", dep=" + dep + "]";
	}

	
	
	
	
	
	
	
}
