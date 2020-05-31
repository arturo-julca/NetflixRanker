package com.komodo.NetflixRanker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.komodo.NetflixRanker.model.Product;
import com.komodo.NetflixRanker.repository.ProductRepository;

@Service("productService")
public class ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public Page<Product> findAllPageable(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
	
	public Page<Product> findAllPageable(Pageable pageable, int idGenreSelected) {
        return productRepository.findAll(pageable);
    }
	
	public Page<Product> getProductByGenre(Pageable pageable, int idGenre) {
		Page<Product> productPage = productRepository.findAllByGenrePage(idGenre, pageable);
		return productPage;
    }
}