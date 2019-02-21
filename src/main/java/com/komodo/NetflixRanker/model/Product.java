package com.komodo.NetflixRanker.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_product")
	private int idProduct;

	@Column(name = "title")
	private String title;

	@Column(name = "year")
	private String year;

	@Column(name = "runtime")
	private String runtime;

	@Column(name = "director")
	private String director;

	@Column(name = "metascore")
	private String metascore;

	@Column(name = "imdb_rating")
	private String imdbRating;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "Product_Genre", 
		joinColumns = { @JoinColumn(name = "id_product") }, 
		inverseJoinColumns = {@JoinColumn(name = "id_genre") })
	private Set<Genre> genres = new HashSet<>();

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getMetascore() {
		return metascore;
	}

	public void setMetascore(String metascore) {
		this.metascore = metascore;
	}

	public String getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", title=" + title + ", year=" + year + ", runtime=" + runtime
				+ ", director=" + director + ", metascore=" + metascore + ", imdbRating=" + imdbRating + ", genres="
				+ genres + "]";
	}
	
}