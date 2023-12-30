package com.ABCTravels;

import java.time.LocalDate;

public class Route {

	private String source;
	
	private String destination;
	
	private LocalDate journeyDate;
	
	private double pricePerTicket;
	
	private Integer noOfSeatsavailable;

	
	public Route(String source, String destination, LocalDate journeyDate, double pricePerTicket,
			Integer noOfSeatsavailable) {
		this.source = source;
		this.destination = destination;
		this.journeyDate = journeyDate;
		this.pricePerTicket = pricePerTicket;
		this.noOfSeatsavailable = noOfSeatsavailable;
	}


	public Route() {
		
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	public Integer getNoOfSeatsavailable() {
		return noOfSeatsavailable;
	}

	public void setNoOfSeatsavailable(Integer noOfSeatsavailable) {
		this.noOfSeatsavailable = noOfSeatsavailable;
	}


	public double getPricePerTicket() {
		return pricePerTicket;
	}


	public void setPricePerTicket(double pricePerTicket) {
		this.pricePerTicket = pricePerTicket;
	}


	@Override
	public String toString() {
		return "Route [source=" + source + ", destination=" + destination + ", journeyDate=" + journeyDate
				+ ", pricePerTicket=" + pricePerTicket + ", noOfSeatsavailable=" + noOfSeatsavailable + "]";
	}
	
	
}
