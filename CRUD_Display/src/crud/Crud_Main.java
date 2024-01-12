package crud;

import java.util.Scanner;

public class Crud_Main
{
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		System.out.println("********** EMPLOYEE MANAGEMENT SYSTEM *************");
		userchoice();
		System.out.println("***************** END *****************************");
	}
	
	public static void userchoice()
	{
		int choice;
		do
		{
			System.out.println();
			System.out.println("1. Create");
			System.out.println("2. Update");
			System.out.println("3. Search");
			System.out.println("4. Delete");
			System.out.println("5. Display");
			
			System.out.print("\nEnter the choice: ");
			choice = sc.nextInt();
			
			switchchoice(choice);
			
		}while(choice!=0 && choice<6);
	}
	
	public static  void switchchoice(int choice)
	{
		switch(choice)
		{
			case 1:
				System.out.println("\n****** CREATE EMPLOYEE ******");				
				Create.create_Employee();
				break;
				
			case 2:
				System.out.println("\n****** UPDATE EMPLOYEE ******");
				System.out.print("Enter the Employee Id to be updated: ");
				int up_id=sc.nextInt();
				System.out.println("\n1.Update name \n2.Update destignation \n3.Update salary");
				System.out.print("Enter the update choice: ");
				int up_choice = sc.nextInt();
				Update.update_Employee(up_choice,up_id);
				break;
				
			case 3:
				System.out.println("\n****** SEARCH EMPLOYEE ******");
				System.out.print("Enter Employee Id to be searched : ");
				int search = sc.nextInt();
				Search.search_Employee(search);
				break;
				
			case 4:
				System.out.println("\n****** DELETE EMPLOYEE ******");
				Delete.delete_Employee();
				break;
				
			case 5:
				System.out.println("\n****** DISPLAY EMPLOYEE ******");
				Display.display_Employee();
				break;
				
			default:
				System.out.println();		
		}
		
	}

}
