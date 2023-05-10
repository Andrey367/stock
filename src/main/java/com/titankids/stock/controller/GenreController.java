package com.titankids.stock.controller;


import com.titankids.stock.model.Genre;
import com.titankids.stock.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping(path = "/list")
    public String getAllGenres(Model model) {
        addAttributes(model, genreRepository.findAll());
        return "genre-list";
    }

    private void addAttributes(Model model, List<Genre> genres) {
        model.addAttribute("genres", genres);
    }
}