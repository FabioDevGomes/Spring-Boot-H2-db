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
		detail.setProductId("AAA");
		detail.setProductName("O livro de Dan sobre escrita");
		detail.setShortDescription("Um livro sobre escrever livros");
		detail.setLongDescription("Primerio - Neste livro Dan apresenta ao leitor...");
		detail.setInventoryId("12345");
		ProductDetailRepository repository = ctx.getBean(ProductDetailRepository.class);
		repository.save(detail);
		
		ProductDetail detail2 = new ProductDetail();
		detail2.setProductId("BBB");
		detail2.setProductName("O livro de Dan sobre escrita");
		detail2.setShortDescription("Um livro sobre escrever livros");
		detail2.setLongDescription("Segundo - Neste livro Dan apresenta ao leitor...");
		detail2.setInventoryId("12345");
		repository.save(detail2);
		
		ProductDetail detail3 = new ProductDetail();
		detail3.setProductId("CCC");
		detail3.setProductName("O livro de Dan sobre escrita");
		detail3.setShortDescription("Um livro sobre escrever livros");
		detail3.setLongDescription("Terceiro - Neste livro Dan apresenta ao leitor...");
		detail3.setInventoryId("12345");
		repository.save(detail3);

		ProductDetail detail4 = new ProductDetail();
		detail4.setProductId("DDD");
		detail4.setProductName("O livro de Dan sobre escrita");
		detail4.setShortDescription("Um livro sobre escrever livros");
		detail4.setLongDescription("Quarto - Neste livro Dan apresenta ao leitor...");
		detail4.setInventoryId("12345");
		repository.save(detail4);
		
		for (ProductDetail detail0 : repository.findAll()){
			System.out.println(detail0.getProductId());
		}
	}
}
  