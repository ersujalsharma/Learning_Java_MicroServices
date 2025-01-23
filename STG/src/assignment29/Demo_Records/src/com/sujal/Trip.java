package com.sujal;

public record Trip(String packagetype, double fare, Integer noOfDays) {

	public static double discount = 10.0;

	public Trip(Integer noOfDays) {
		this("Standard", 10000.0, noOfDays);
	}

	public static double applyOffer(Integer noOfDays, double fare) {
		double discountAmount;
		if (noOfDays >= 7) {
			discountAmount = (fare * discount) / 100.0;
			return fare - discountAmount;
		} else {
			return fare;
		}
	}
}
