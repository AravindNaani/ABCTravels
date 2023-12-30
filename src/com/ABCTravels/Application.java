package com.ABCTravels;

public class Application {

	public static void main(String[] args) {
		
		if(Resource.readLogo()) {
			Resource.showMenu();
		}
		else {
			System.out.println("Logo is not loaded please refresh the Application...!");
		}		
	}

}
