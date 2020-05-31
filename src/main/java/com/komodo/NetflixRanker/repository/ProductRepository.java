package com.komodo.NetflixRanker.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.komodo.NetflixRanker.model.Product;

@Repository("productRepository")
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

	@Query(value = "SELECT * FROM Product p JOIN product_genre AS p_g ON p.id_product = p_g.id_product WHERE p_g.id_genre= ?1 ORDER BY metascore DESC", nativeQuery = true)
	List<Product> findAllByGenre(int idGenre, Pageable pageable);
	
	@Query(value = "SELECT * FROM Product p JOIN product_genre AS p_g ON p.id_product = p_g.id_product WHERE p_g.id_genre= ?1 ORDER BY metascore DESC", nativeQuery = true)
	Page<Product> findAllByGenrePage(int idGenre, Pageable pageable);
}
