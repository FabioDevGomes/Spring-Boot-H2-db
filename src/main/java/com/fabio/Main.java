package com.fabio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(Main.class);
		ProductDetail detail = new ProductDetail();
		detail.setProductId("ABC");
		detail.setProductName("O livro de Dan sobre escrita");
		detail.setShortDescription("Um livro sobre escrever livros");
		detail.setLongDescription("Neste livro Dan apresenta ao leitor...");
		detail.setInventoryId("12345");
		ProductDetailRepository repository = ctx.getBean(ProductDetailRepository.class);
		repository.save(detail);
		for (ProductDetail detail2 : repository.findAll()){
			System.out.println(detail2.getProductId());
		}
	}
}
  