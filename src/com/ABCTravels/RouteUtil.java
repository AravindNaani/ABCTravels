package com.ABCTravels;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.CheckedOutputStream;

public class RouteUtil {
	static Scanner scn = new Scanner(System.in);
	static List<Route> searchedRoutes = new ArrayList<>();

	public static Object planJourney(List<Route> routes) {

		System.out.print("Enter Source ::");
		String source = scn.next();

		if (source.equals(null) || source.isEmpty()) {
			System.out.println("----- Source Must not be Empty -----");
			return null;
		}

		System.out.print("Enter Destination ::");
		String destination = scn.next();
		if (destination.equals(null) || destination.isEmpty()) {
			System.out.println("----- Destination Must not be Empty -----");
			return null;
		}

		LocalDate plannedDate = null;
		System.out.print("Enter journey Date ::");
		String journeyDate = scn.next();
		if (journeyDate.equals(null) || journeyDate.isEmpty()) {
			System.out.println("----- JourneyDate Must not be Empty -----");
			return null;
		} else {
			plannedDate = LocalDate.parse(journeyDate, DateTimeFormatter.ISO_LOCAL_DATE);
		}

		System.out.print("Enter Number of Passengers ::");
		int passengers = scn.nextInt();

		for (Route route : routes) {
			if (route.getSource().equalsIgnoreCase(source)) {
				if (route.getDestination().equalsIgnoreCase(destination)) {
					if (route.getJourneyDate().equals(plannedDate)) {
						if (!(route.getNoOfSeatsavailable() > 0)) {
							System.out.println("------------ Seats are not available for this route -----------");
						} else {
							searchedRoutes.add(route);
						}
					}
					/*
					 * else { System.out.
					 * println("------- Buses are not Available on selected Date on selected Route --------"
					 * ); }
					 */
				}
				/*
				 * else {
				 * System.out.println("------- Searched Destination is not Available --------");
				 * }
				 */
			}
			/*
			 * else {
			 * System.out.println("------- Searched Source is not Available --------"); }
			 */
		}
		showRoutes(searchedRoutes, passengers);
		return null;
	}

	public static void showRoutes(List<Route> searchedRoutes, int noOfPassengers) {
		if (searchedRoutes.isEmpty()) {
			System.out.println("------------ Searched Routes are not Available -------------");
		} else {
			for (Route route : searchedRoutes) {

				if (route.getJourneyDate().getDayOfWeek().equals(DayOfWeek.SATURDAY)
						|| route.getJourneyDate().equals(DayOfWeek.SUNDAY)) {
					System.out.println("-----------------------------------------------------------------------------");
					System.out.println("|  " + route.getSource() + "   --->   " + route.getDestination() + " | Date :: "
							+ route.getJourneyDate() + " |   Price per Seat: " + route.getPricePerTicket() + "  |");
					System.out.println("-----------------------------------------------------------------------------");
					double cost = noOfPassengers * route.getPricePerTicket() + 200;
					cost = (cost + cost * 18 / 100);
					System.out.println("-------------------------------------------------");
					System.out.println("                  FARE DETAILS                   ");
					System.out.println("-------------------------------------------------");
					System.out.println("|          " + noOfPassengers + "  *  " + route.getPricePerTicket() + "   =   "
							+ cost + "                   |");
					System.out.println("|    *Inclusive of Surge Charges and GST*       |");
					System.out.println("-------------------------------------------------");
				} else {
					System.out.println("-----------------------------------------------------------------------------");
					System.out.println("|  " + route.getSource() + "   --->   " + route.getDestination() + " | Date :: "
							+ route.getJourneyDate() + " |   Price per Seat: " + route.getPricePerTicket() + "  |");
					System.out.println("-----------------------------------------------------------------------------");
					double cost = noOfPassengers * route.getPricePerTicket();
					System.out.println("-------------------------------------------------");
					System.out.println("                  FARE DETAILS                   ");
					System.out.println("-------------------------------------------------");
					System.out.println("|          " + noOfPassengers + "  *  " + route.getPricePerTicket() + "   =   "
							+ cost + "                   |");
					System.out.println("-------------------------------------------------");
				}
			}
		}
	}
}
