package com.titankids.stock.controller;


import com.titankids.stock.model.Genre;
import com.titankids.stock.model.Order;
import com.titankids.stock.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping(path = "/list")
    public String getAllGenre(Model model) {
        addAttributes(model, genreRepository.findAll());
        return "genre-list";
    }

    @GetMapping(path = "/{id}")
    public String getById(@PathVariable Long id, Model model) {
        model.addAttribute("genre", genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Genre with id %d not found", id))));
        return "genre";
    }

    @PostMapping()
    public String update(@ModelAttribute Genre genre, Model model) {
        model.addAttribute("genre", genreRepository.save(genre));
        return "redirect:/genre/list";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteById(@PathVariable Long id, Model model) {
        genreRepository.deleteById(id);
        return "redirect:/genre/list";
    }

    @GetMapping(path = "/create")
    public String deleteById(Model model) {
        model.addAttribute("genre", new Genre());
        return "genre";
    }

    private void addAttributes(Model model, List<Genre> genre) {
        model.addAttribute("genre", genre);
    }
}
