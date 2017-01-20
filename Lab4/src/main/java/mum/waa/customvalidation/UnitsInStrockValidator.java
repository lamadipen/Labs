package mum.waa.customvalidation;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import mum.waa.model.Product;

@Component
public class UnitsInStrockValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		
		if(product.getUnitPrice() !=null && new BigDecimal(1000).compareTo(product.getUnitPrice())<=0 && product.getUnitsInStock() >99)
		{
			errors.rejectValue("unitsInStock", "validator.UnitsInStockValidator.message");
		}
	}

}
