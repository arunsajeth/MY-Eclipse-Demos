package edu.training.fibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Department d = new Department();
    	d.setDname("HR");
    	Employee e = new Employee();
    	e.setEname("BBB");
    	e.setSalary(10000);
    	e.setDep(d);
    	Configuration cgf = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Department.class);
    	SessionFactory sf = cgf.buildSessionFactory();
    	Session s = sf.openSession();
    	Transaction tx = s.beginTransaction();
    	s.save(e);
    	s.save(d);
    	tx.commit();
    	s.close();
    	
    }
}
