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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Genre")
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_genre")
	private int idGenre;

	@Column(name = "name")
	private String name;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "genres")
	private Set<Product> products = new HashSet<>();

	public int getIdGenre() {
		return idGenre;
	}

	public void setIdGenre(int idGenre) {
		this.idGenre = idGenre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Genre [idGenre=" + idGenre + ", name=" + name + "]";
	}
	

}