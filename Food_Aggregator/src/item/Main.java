package item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main 
{
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception 
	{
		userChoice();
	}
	
	public static void userChoice() throws Exception
	{
		int choice;
		ItemDAO dao = new ItemDAO();
		do
		{
			System.out.println("\n1. Add item \n2. To Add many item \n3.Find item based on type \n4.Find item based on price");
			System.out.print("Enter the choice: ");
			choice = s.nextInt();
			switch(choice)
			{
				case 1:
					System.out.print("Enter the String: ");
					String food_item = s.next();
					String[] ch = food_item.split(",");
					Double cost = new Double(ch[1]);
					Item items = new Item(ch[0],cost,ch[2]);
					dao.addItem(items);
					break;
					
				case 2:
					System.out.print("\nNumber of list to added: ");
					int bulk = Integer.parseInt(s.next());
					List<Item> itemList = new ArrayList<Item>();
					for(int i=0;i<bulk;i++)
					{
						System.out.print("Enter the String"+i+" : ");
						food_item = s.next();
						String[] ch1 = food_item.split(",");
						cost = new Double(ch1[1]);
						itemList.add(new Item(ch1[0],cost,ch1[2]));
						
					}
					dao.bulkCopy(itemList);
					break;
					
				case 3:
					System.out.print("\nEnter the type to search:  ");
					String search_type = s.next();
					List<Item> disp1 = dao.findItem(search_type);
					if(disp1.isEmpty())
					{
						System.out.println("Type not found!!!");
					}
					else
					{
						System.out.format("%-20s %-5s %s\n","Name","Price","Type");
						for(Item li:disp1)
						{
							System.out.format("%-20s %-5s %s\n",li.getname(),li.getprice(),li.gettype());
						}
					}
					break;
					
				case 4:
					System.out.print("Enter the price to search: ");
					double search_price = s.nextDouble();
					List<Item> disp = dao.findItem(search_price);
					if(disp.isEmpty())
					{
						System.out.println("Price not Found!!!");
					}
					else
					{
						System.out.format("%-20s %-5s %s\n","Name","Price","Type");
						for(Item li:disp)
						{
							System.out.format("%-20s %-5s %s\n",li.getname(),li.getprice(),li.gettype());
						}
					}
					break;
					
				default:
					System.out.println("EXIT");
			}
		}while(choice>0 && choice<5);
	}
	

}
