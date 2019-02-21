package com.komodo.NetflixRanker.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.komodo.NetflixRanker.model.Product;

//@Repository("productRepository")
//public interface ProductRepository extends JpaRepository<Product, Integer>{
//
//	List<Product> findAll();
//}

@Repository("productRepository")
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
