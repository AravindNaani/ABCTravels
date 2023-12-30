package com.ABCTravels;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserUtil {

	static Scanner scn = new  Scanner(System.in);
	static List<User> users = new ArrayList<>();
	static Map<String,Integer> invalidLoginAttempts = new HashMap<>();
	
	public static void registerNewUser() {
		
		System.out.print("Enter firstName ::");
		String firstName = scn.next();
		
		System.out.print("Enter lastName ::");
		String lastName = scn.next();
		
		System.out.print("Enter Mobile Number ::");
		long mobileNumber = scn.nextLong();
		
		System.out.print("Enter Gender ::");
		char gender = scn.next().charAt(0);
		
		System.out.print("Enter EmailId ::");
		String email = scn.next();
		
		System.out.print("Enter Password ::");
		String password = scn.next();
		
		int failedCount =0;
		String accoutStatus = "Active";
		
		User user = new User(firstName,lastName,mobileNumber,gender,email,password,failedCount,accoutStatus);
		users.add(user);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~  User Registered Successfully  ~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	public static List<Route> loginUser()
	{
		System.out.println("---------LOGIN USER---------");
		System.out.print("Enter Emil :: ");
		String username = scn.next();
		
		System.out.print("Enter Password :: ");
	    String password =scn.next();
	    
	    for(User user : users) {
	    	Integer Existinglogincount = invalidLoginAttempts.get(user.getEmailId());
	    	int count = Existinglogincount != null ? Existinglogincount : 0;
	    	
	    	if (count>=5) {
	    		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    		System.out.println("~~  User "+username+" is Locked Plese contact Admin  ~~");
	    		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    		return null;
	    	}
	    	if(user.getEmailId().equalsIgnoreCase(username)) {
	    		if(user.getPassword().equals(password)) {
	    			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    			System.out.println("~~  Admin User Login Successful ~~");
	    			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    			System.out.println("Please choose from below Options");
	    			System.out.println("1.Add Routes");
	    			System.out.print("Enter Your Choice ::");
	    			int input = scn.nextInt();
	    			switch(input) {
	    			case 1:{
	    				List<Route> routesList = addRoutes();
	    				return routesList;
	    			}
	    			}
	    		}
	    		else {
	    			invalidLoginAttempts.put(username, ++count);
	    			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    			System.out.println("~~  Invalid Password for UserName :: "+username+" ::Login Attempt :: "+count+"    ~~");
	    			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				}
	    	}
	    	else {
	    		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("~~  Invalid Username :: "+username+"  ~~");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
	    }
	    return null;
	}
	
	public static List<Route> addRoutes(){
		
		List<Route> busRoutes = new ArrayList<>();
		int i=0;
		do{
		System.out.print("Enter Source ::");
		String source = scn.next();
		
		System.out.print("Enter Destination ::");
		String destination=	scn.next();
		
		
		System.out.print("Enter journey Date ::");
		String Date = scn.next();
		LocalDate plannedDate=LocalDate.parse(Date,DateTimeFormatter.ISO_LOCAL_DATE);
		
		System.out.print("Enter Price per Passenger ::");
		double price = scn.nextDouble();
		
		System.out.print("Enter Number of Seats Available in Bus ::");
		Integer  noOfSeatsAvailable= scn.nextInt();
		
		Route route = new Route(source,destination,plannedDate,price,noOfSeatsAvailable);
		busRoutes.add(route);
		System.out.println("Please choose from below Options");
		System.out.println("Enter 0 for another Route");
		System.out.println("Enter 1 for Exit");
		System.out.print("Enter your Choise :: ");
		i = scn.nextInt();
		}while(i==0);
		return busRoutes;
	}
}
