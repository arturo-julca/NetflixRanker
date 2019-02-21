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

//	public List<Product> getAllProducts() {
//		return productRepository.findAll();
//	}
//
//	public Page<Product> getAllProductsPaginated(Pageable pageable) {
//		int pageSize = pageable.getPageSize();
//		int currentPage = pageable.getPageNumber();
//		int startItem = currentPage * pageSize;
//		List<Product> listProductsOnDb = productRepository.findAll();
//		List<Product> list;
//		if (listProductsOnDb.size() < startItem) {
//            list = Collections.emptyList();
//        } else {
//            int toIndex = Math.min(startItem + pageSize, listProductsOnDb.size());
//            list = listProductsOnDb.subList(startItem, toIndex);
//        }
//		Page<Product> productsPage = new PageImpl<Product>(list, PageRequest.of(currentPage, pageSize), listProductsOnDb.size());
//		return productsPage;
//    }
	
	public Page<Product> findAllPageable(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}