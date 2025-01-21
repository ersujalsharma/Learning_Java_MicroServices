package userinterface;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import model.Foodie;
import model.Pizza;
import model.PizzaSize;
import service.PizzaService;

public class PizzaShoppie {
	private static final Log LOGGER = LogFactory.getLog(PizzaShoppie.class);
	public static void main(String[] args) {
		try {
			List<Pizza> pizzasOrdered = new ArrayList<>();
			pizzasOrdered.add(new Pizza(PizzaSize.REGULAR));
			pizzasOrdered.add(new Pizza(PizzaSize.MEDIUM));
			pizzasOrdered.add(new Pizza(PizzaSize.LARGE));
			Foodie foodie = new Foodie("Jacob", 1000d, pizzasOrdered);
			PizzaService pizzaService = new PizzaService();
			Double totalCost = pizzaService.purchasePizza(foodie);
			
			LOGGER.info("Your order is placed and the total cost is "+totalCost);
		} catch(Exception e) {
			LOGGER.info(e.getMessage());
		}
	}
}
