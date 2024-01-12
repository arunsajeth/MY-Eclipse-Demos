package desp;

import java.util.*;
import java.text.*;

public class Main 
{
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) throws Exception 
	{
		CollegeBO cb= new CollegeBO();
		System.out.print("\nNumber of intial college list to be entered:");
		int intial = s.nextInt(); 
		for(int j=0;j<intial;j++)
		{
			System.out.println("Enter the string:");
			String college = s.next();
			College clg1 = createCollege(college);
			cb.createData(clg1);
		}
		userChoice();
	}
	
	public static void userChoice() throws Exception
	{
		int choice;
		do
		{
			System.out.println("\n1. Search college based on name "
					+ "\n2. Search colege based on starting Date "
					+ "\n3. Search College based on Location "
					+ "\n4. Sort based on No. of department");
			System.out.print("\nEnter the choice: ");
			choice = s.nextInt();
			CollegeBO cbo = new CollegeBO();
			switch(choice)
			{
				case 1:
					System.out.print("\nNumberof names to be entered: ");
					int temp=s.nextInt();
					List<String> names = new ArrayList<>();
					System.out.print("\n Enter the list of names: ");
					for(int i=0;i<temp;i++)
						names.add(s.next());
					cbo.sortByName(cbo.findCollege(names));
					break;
				case 2:
					System.out.print("\nEnter the starting date to search:");
					String search_Date = s.next();
			        DateFormat df = new SimpleDateFormat("dd:MM:yy");
			        Date startingDate = df.parse(search_Date);
					cbo.sortByDate(cbo.findCollege(startingDate));
					break;
				case 3:
					System.out.println("\n Enter the location to search: ");
					String location = s.next();
					cbo.sortByLocation(cbo.findCollege(location));
					break;
				case 4: 
					cbo.sortByNoOfDept();
					break;
				default: 
					System.out.println("EXIT");
			}
		}while(choice<5 && choice>0);
	}
	
	public static College createCollege(String college) throws ParseException
	{
		String[] ch = college.split(",");
		System.out.println(ch[6]);
		String starting_Date = ch[6];
        DateFormat df = new SimpleDateFormat("dd:mm:yy");
        Date startingDate = df.parse(starting_Date);
		return new College(ch[0],ch[1],ch[2],ch[3],Integer.parseInt(ch[4]),ch[5],startingDate);
	}

}
