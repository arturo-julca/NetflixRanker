package com.komodo.NetflixRanker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.komodo.NetflixRanker.model.Genre;
import com.komodo.NetflixRanker.model.Product;
import com.komodo.NetflixRanker.service.GenreService;
import com.komodo.NetflixRanker.service.ProductService;
import com.komodo.NetflixRanker.util.Pager;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private GenreService genreService;
    
    private static final int BUTTONS_TO_SHOW = 5;
    private static final int PAGE_SIZE = 20;
    
    @RequestMapping(value = "/ranker", method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam("page") Optional<Integer> page,
                                        @RequestParam("idGenre") Optional<Integer> idGenre) {
        ModelAndView modelAndView = new ModelAndView("ranker");

        int idGenreSelected = idGenre.orElse(1);
        int pageSelected = page.orElse(1);

        Pageable pageable = PageRequest.of(pageSelected-1, PAGE_SIZE);
        Page<Product> productPage = productService.getProductByGenre(pageable, idGenreSelected);
        Pager pager = new Pager(productPage.getTotalPages(), productPage.getNumber(), BUTTONS_TO_SHOW);
        List<Genre> genres = genreService.findAllGenres();
        
        modelAndView.addObject("products", productPage);
        modelAndView.addObject("genres", genres);
        modelAndView.addObject("idGenre", idGenreSelected);
        modelAndView.addObject("pager", pager);
        modelAndView.addObject("page", pageSelected);
        return modelAndView;
    }
}