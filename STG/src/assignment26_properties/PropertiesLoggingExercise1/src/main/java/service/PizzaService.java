package service;

import java.util.List;

import com.sujal.exception.AcademyException;

import model.Foodie;
import model.Pizza;
import validator.PizzaValidator;

public class PizzaService {
	public Double purchasePizza(Foodie foodie) throws AcademyException {
		PizzaValidator pizzaValidator = new PizzaValidator();
		pizzaValidator.validate(foodie);
		Double totalCost = this.calculateCost(foodie.getPizzasOrdered());
		if(totalCost>foodie.getWalletBalance())
			throw new AcademyException("Service.INSUFFICIENT_WALLET_BALANCE");
		return totalCost;
	}
	
	//return the total cost of all the Pizza objects in the List
	public Double calculateCost(List<Pizza> pizzasOrdered) {
		return pizzasOrdered.stream().mapToDouble(pizza -> pizza.getCost()).sum();
	}
}
