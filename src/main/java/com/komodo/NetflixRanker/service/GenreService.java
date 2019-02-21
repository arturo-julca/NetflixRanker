package com.komodo.NetflixRanker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.komodo.NetflixRanker.model.Genre;
import com.komodo.NetflixRanker.repository.GenreRepository;

@Service("genreService")
public class GenreService {

	private GenreRepository genreRepository;

	@Autowired
	public GenreService(GenreRepository genreRepository) {
		this.genreRepository = genreRepository;
	}
	
	public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }
}