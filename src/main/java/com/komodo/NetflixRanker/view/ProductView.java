package com.komodo.NetflixRanker.view;

public class ProductView {

	private int idProduct;

	private String title;

	private String year;

	private String runtime;

	private String director;

	private String metascore;

	private String imdbRating;
	
	private String genresDesc;

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

	public String getGenresDesc() {
		return genresDesc;
	}

	public void setGenresDesc(String genresDesc) {
		this.genresDesc = genresDesc;
	}

	@Override
	public String toString() {
		return "ProductView [idProduct=" + idProduct + ", title=" + title + ", year=" + year + ", runtime=" + runtime
				+ ", director=" + director + ", metascore=" + metascore + ", imdbRating=" + imdbRating + ", genresDesc="
				+ genresDesc + "]";
	}
	
	
}
