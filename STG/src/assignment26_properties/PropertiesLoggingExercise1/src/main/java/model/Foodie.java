package model;

import java.util.List;

public class Foodie {
	
	private String name;
	private Double walletBalance;
	private List<Pizza> pizzasOrdered;
	
	public Foodie(String name, Double walletBalance, List<Pizza> pizzasOrdered) {
		super();
		this.name = name;
		this.walletBalance = walletBalance;
		this.pizzasOrdered = pizzasOrdered;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getWalletBalance() {
		return walletBalance;
	}
	public void setWalletBalance(Double walletBalance) {
		this.walletBalance = walletBalance;
	}
	public List<Pizza> getPizzasOrdered() {
		return pizzasOrdered;
	}
	public void setPizzasOrdered(List<Pizza> pizzasOrdered) {
		this.pizzasOrdered = pizzasOrdered;
	}
}
