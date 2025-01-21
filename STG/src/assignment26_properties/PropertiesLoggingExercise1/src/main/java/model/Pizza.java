package model;

public class Pizza {
	private PizzaSize pizzaSize;
	private Double cost;
	
	public Pizza(PizzaSize pizzaSize) {
		this.pizzaSize = pizzaSize;
		switch(pizzaSize) {
		case REGULAR: cost = 100d;
		break;
		case MEDIUM: cost = 250d;
		break;
		case LARGE: cost = 390d;
		break;
		}
	}
	
	public PizzaSize getPizzaSize() {
		return pizzaSize;
	}
	public void setPizzaSize(PizzaSize pizzaSize) {
		this.pizzaSize = pizzaSize;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}	
}
