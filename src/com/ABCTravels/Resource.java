package com.ABCTravels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Resource {
	static List<Route> busRoutes = new ArrayList<>();
	public static boolean readLogo() {
		try {
			FileReader fileReader = new FileReader("C:\\Users\\SANDEEP KUMAR\\OneDrive\\Desktop\\logo.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String logoString = bufferedReader.readLine();
			while (logoString != null) {
				System.out.println(logoString);
				logoString = bufferedReader.readLine();
			}
			bufferedReader.close();
			return true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public static void showMenu() {
		while (true) {
			System.out.println("Please Select from below Menu ....!");
			System.out.println("1.Register New Admin User");
			System.out.println("2.Login User");
			System.out.println("3.Search Busses");
			System.out.println("4.Exit");
			System.out.print("Enter your Option :: ");
			Scanner scn = new Scanner(System.in);
			int input = scn.nextInt();
			switch (input) {
			case 1: {
				UserUtil.registerNewUser();
				break;
			}
			case 2: {
				busRoutes = UserUtil.loginUser();
				break;
			}
			case 3:{
				RouteUtil.planJourney(busRoutes);
				break;
			}
			case 4: {
				System.out.println("----------------------------------------------------");
				System.out.println("--           Exiting from Application             --");
				System.out.println("----------------------------------------------------");
				System.exit(0);
			}
			default:
			}
		}
	}
}
