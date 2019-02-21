package com.komodo.NetflixRanker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.komodo.NetflixRanker.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{
	List<Genre> findAll();
}
