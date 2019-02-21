package com.komodo.NetflixRanker.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 20;
    private static final int[] PAGE_SIZES = {5, 10, 20};

    
    @RequestMapping(value = "/ranker", method = RequestMethod.GET)
    public ModelAndView showPersonsPage(@RequestParam("pageSize") Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page,
                                        @RequestParam("type") Optional<String> type,
                                        @RequestParam("idGenre") Optional<Integer> idGenre) {
        ModelAndView modelAndView = new ModelAndView("ranker");

        int idGenreSent = idGenre.orElse(0);
        String getType = type.orElse("");
        
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

        Page<Product> products = productService.findAllPageable(PageRequest.of(evalPage, evalPageSize));
        Pager pager = new Pager(products.getTotalPages(), products.getNumber(), BUTTONS_TO_SHOW);

        List<Genre> genres = genreService.findAllGenres();
        modelAndView.addObject("products", products);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        modelAndView.addObject("genres", genres);
        modelAndView.addObject("type", new String());
        modelAndView.addObject("idGenre", idGenreSent);
        return modelAndView;
    }
    
//    @RequestMapping(value = "/ranker", method = RequestMethod.POST)
//    public ModelAndView rankerSearch(
//    		HttpServletRequest request) {
//    	String nameGenre = request.getParameter("nameGenre");
//    	ModelAndView modelAndView = new ModelAndView("ranker");
////
////        int idGenreSent = idGenre.orElse(0);
////        String getType = type.orElse("");
////        
////        int evalPageSize = INITIAL_PAGE_SIZE;
////        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
////
////        Page<Product> products = productService.findAllPageable(PageRequest.of(evalPage, evalPageSize));
////        Pager pager = new Pager(products.getTotalPages(), products.getNumber(), BUTTONS_TO_SHOW);
////
////        List<Genre> genres = genreService.findAllGenres();
////        modelAndView.addObject("products", products);
////        modelAndView.addObject("selectedPageSize", evalPageSize);
////        modelAndView.addObject("pageSizes", PAGE_SIZES);
////        modelAndView.addObject("pager", pager);
////        modelAndView.addObject("genres", genres);
////        modelAndView.addObject("type", new String());
////        modelAndView.addObject("idGenre", idGenreSent);
//        return modelAndView;
//    }
}