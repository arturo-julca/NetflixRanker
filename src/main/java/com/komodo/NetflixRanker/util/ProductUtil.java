package com.komodo.NetflixRanker.util;

import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.komodo.NetflixRanker.model.Genre;
import com.komodo.NetflixRanker.model.Product;
import com.komodo.NetflixRanker.view.ProductView;

public class ProductUtil {

	public static ProductView convertToView(Product product){
		ProductView productView = new ProductView();
		BeanUtils.copyProperties(product, productView);
		if(product.getGenres()!=null){
			String genreDesc = "";
			for(Genre genre : product.getGenres()){
				genreDesc = genreDesc + ", "+genre.getName();
			}
			productView.setGenresDesc(genreDesc);
		}
		return productView;
	}
	
	public static String getGenresToString(Set<Genre> genres){
		String genresString = "";
		if(genres!=null){
			for(Genre genre : genres){
				genresString = genresString + ", "+genre.getName();
			}
			genresString = genresString.substring(2);
		}
		return genresString;
	}
	
}
