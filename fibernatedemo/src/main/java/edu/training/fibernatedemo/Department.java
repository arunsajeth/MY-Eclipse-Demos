package edu.training.fibernatedemo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int dep_id;
	String dname;
	 
	
	public int getDep_id() {
		return dep_id;
	}
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "Department [dep_id=" + dep_id + ", dname=" + dname + "]";
	}
	
}
