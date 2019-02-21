package com.komodo.NetflixRanker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.komodo.NetflixRanker.model.Product;
import com.komodo.NetflixRanker.repository.GenreRepository;
import com.komodo.NetflixRanker.repository.ProductRepository;

//@SpringBootApplication
public class JpaManyToManyDemoApplication implements CommandLineRunner {

	@Autowired
	private GenreRepository genreRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaManyToManyDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Page<Product> pageProduct = productRepository.findAll(PageRequest.of(1, 10));
		for(Product prod : pageProduct){
			System.out.println(prod);
		}
	}
}
