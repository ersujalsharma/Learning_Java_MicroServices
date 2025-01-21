package validator;

import java.util.List;

import org.apache.commons.logging.LogFactory;

import com.sujal.exception.AcademyException;

import model.Foodie;
import model.Pizza;

public class PizzaValidator {
	public void validate(Foodie foodie) throws AcademyException {
		String errorStatus =  null	;
		
		if(!isValidWalletBalance(foodie.getWalletBalance()))
		{
			errorStatus="Validator.INVALID_WALLET_BALANCE";
		}
		else if(!isValidPizzasOrdered(foodie.getPizzasOrdered()))
		{
			errorStatus="Validator.INVALID_PIZZAS_ORDERED";
		}
		if (errorStatus != null) {
			AcademyException exception = new AcademyException(errorStatus);
			LogFactory.getLog(this.getClass()).error(exception.getMessage(), exception);
			throw exception;
		}
		
	}

	public Boolean isValidWalletBalance(Double walletBalance) {
		return walletBalance >= 0;
	}

	public Boolean isValidPizzasOrdered(List<Pizza> pizzasOrdered) {
		return !(pizzasOrdered == null || pizzasOrdered.isEmpty());
	}
}
