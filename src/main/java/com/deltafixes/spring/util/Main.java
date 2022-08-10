package com.deltafixes.spring.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import com.deltafixes.spring.business.DemoBean;
import com.deltafixes.spring.dto.Customer;

public class Main {

	
	public static void dbOps(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        @SuppressWarnings("unused")
		DemoBean demo = (DemoBean) context.getBean("db");
		System.out.println("Hi, This is Spring Crud DEmo with JDBC Template.");
		System.out.println("What do you want?");
		System.out.println("Enter 1 to Insert Data");
		System.out.println("Enter 2 to Update Data");
		System.out.println("Enter 3 to Display Data");
		System.out.println("Enter 4 to Display whole TAble");
		System.out.println("Enter 5 to Delete Data from the Table");
		System.out.println("Enter 6 to exit from Program");
	}
	
	public static void main(String[] args) throws SQLException, IOException{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
		DemoBean demo = (DemoBean) context.getBean("db");
		
		dbOps();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		 
	   try{
		   BufferedReader cs = new BufferedReader(new InputStreamReader(System.in));
		String CustomerName;
		String CustomerAddress;
		try{
		int userInput = input.nextInt();
		switch(userInput){
		
		case 1:
		System.out.println("Enter Customer Name: ");
		 CustomerName = cs.readLine();
	   
		System.out.println("Enter Customer City: ");
		CustomerAddress = cs.readLine();
	
		demo.insertCustomer(CustomerName, CustomerAddress);
        System.out.println("Customer Inserted Successfully.");
        main(args);
        break;
        
		case 2:
			System.out.println("Enter the ID of Record You Want to Update..");
			int idn = input.nextInt();
			@SuppressWarnings("unused") Customer gharak = demo.selectCustomer(idn);
			System.out.println("What do you want to update ?");
			System.out.println("enter 1 to Update whole Record: ");
			System.out.println("enter 2 to Update Customer Name:");
			System.out.println("enter 3 to Update City where Customer Live:");
			int var = input.nextInt();
		
			switch(var){
			case 1:
				System.out.println("Enter Upadated Customer Name: ");
			    String cName = cs.readLine();
			    System.out.println("Enter Updated City for Customer: ");
			    String cCity = cs.readLine();
				demo.updateCustomer(cName,cCity,idn);
				System.out.println("Record Updated Successfully");
				main(args);
				break;
			case 2:
				System.out.println("Enter Upadated Customer Name:");
				cName = cs.readLine();
				demo.updateCustomerName(cName, idn);
				System.out.println("Customer Name Updated Successfully");
				main(args);
				break;
			case 3:
				System.out.println("Enter Updated City for Customer:");
				cCity = cs.readLine();
				demo.updateCustomerCity(cCity, idn);
				System.out.println("Customer Updated Successfully..");
				main(args);
				break;
			default:
				System.out.println("Customer do not exist for entered ID, "
						+ "Please look at the table and then give customerID");
				main(args);
				break;
				
			}
		case 3:
			System.out.println("Enter the ID of Record You Want to Display..");
			int disid = input.nextInt();
			Customer customer = demo.selectCustomer(disid);
			System.out.println(customer);
			main(args);
			break;
			
		
		case 4:
			List<Customer>list = demo.getAllCustomers();
			for(Customer c:list)
				System.out.println(c);
			main(args);

		break;
		case 5:
			System.out.println("Enter the ID you want to Delete...");
			int id = input.nextInt();
			int count = demo.deleteCustomer(id);
			System.out.println(count >0?"Deleted Successfully":"No Records Found");
			main(args);
			break;
			
		case 6: 
			System.out.println("You Are out of Program.Run the program again inorder to access CRUD operations..");
			System.exit(0);
			break;
		default:
			System.out.println("There is some error in input, Please ENter Valid input.. ");
		   main(args);
		   break;
		}
		}
		catch(InputMismatchException e){
		System.out.println("Entered Input is Incorrect. Please ENter Valid Input...");
		}
		catch(EmptyResultDataAccessException ex){
			System.out.println(" Please Enter Valid Input..");
		}
	   }catch(NullPointerException npe){
			System.out.println("Wrong Input! Please Enter Valid Input..");
		}
		main(args);
		
	}
}

