package com.fabio;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductDetailValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ProductDetail.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProductDetail detail = (ProductDetail) target;
		if(detail.getInventoryId().contains("A")){
			errors.rejectValue("inventoryId", "invetory.id.invalid", "Id de estoque inválido: contém a letra A");
		}
	}
	
}
