package com.fabio;		
 		
 import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;		
 import org.springframework.web.bind.annotation.RequestMapping;		
 import org.springframework.web.bind.annotation.RequestMethod;		
 import org.springframework.web.bind.annotation.RestController;		
 		
 @RestController		
 @RequestMapping("/products")		
 public class ProductDetailController {		
 		
 	private final ProductDetailRepository repository;		
 	private final ProductDetailValidator validator;		
 			
 	@Autowired		
 	public ProductDetailController(ProductDetailRepository repository, ProductDetailValidator validator){		
 		this.repository = repository;		
 		this.validator = validator;
 	}		
 	
 	@InitBinder
 	protected void initBinder(WebDataBinder binder){
 		binder.addValidators(validator);
 	}
 	
 	@RequestMapping(method = RequestMethod.GET)		
 	public Iterable findAll(){		
 		System.out.println("=== findAll() ===");		
 		return repository.findAll();		
 	}		
 			
 	/**		
 	 * @RequestBody: para fazer o biding pelo spring		
 	 * e preencher automaticamente o objeto através de dados no formato JSON		
 	 */		
 	@RequestMapping(method = RequestMethod.POST)		
 	public ProductDetail create(@RequestBody @Valid ProductDetail detail){		
 		System.out.println("=== Save() ===");		
 		return repository.save(detail);		
 	}		
 			
 }