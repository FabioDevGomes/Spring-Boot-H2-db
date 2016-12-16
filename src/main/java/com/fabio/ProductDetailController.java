package com.fabio;		
 		
 import org.springframework.beans.factory.annotation.Autowired;		
 import org.springframework.web.bind.annotation.RequestBody;		
 import org.springframework.web.bind.annotation.RequestMapping;		
 import org.springframework.web.bind.annotation.RequestMethod;		
 import org.springframework.web.bind.annotation.RestController;		
 		
 @RestController		
 @RequestMapping("/products")		
 public class ProductDetailController {		
 		
 	private final ProductDetailRepository repository;		
 	//https://github.com/jeanbrazcosta/SPRINGBOOT/blob/master/src/main/java/br/com/poc/service/ProductDetailValidator.java		
 			
 	@Autowired		
 	public ProductDetailController(ProductDetailRepository repository){		
 		this.repository = repository;		
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
 	public ProductDetail create(@RequestBody ProductDetail detail){		
 		System.out.println("=== Save() ===");		
 		return repository.save(detail);		
 	}		
 			
 }