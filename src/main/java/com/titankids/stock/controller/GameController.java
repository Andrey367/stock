package com.titankids.stock.controller;


import com.titankids.stock.model.Game;
import com.titankids.stock.model.Genre;
import com.titankids.stock.repository.GameRepository;
import com.titankids.stock.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {

    private final GameRepository gameRepository;
    private final GenreRepository genreRepository;

    @GetMapping(path = "/list")
    public String getAllGames(Model model, @Param("keyword") String keyword) {
        if (Objects.nonNull(keyword) && !keyword.isEmpty()) {
            addAttributes(model, "games", gameRepository.filterBy(keyword.toLowerCase()));
            addAttributes(model, "keyword", keyword);
        } else {
            addAttributes(model, gameRepository.findAll());
        }
        return "game-list";
    }

    @GetMapping(path = "/{id}")
    public String getById(@PathVariable Long id, Model model) {
        model.addAttribute("game", gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Game with id %d not found", id))));
        return "game";
    }

    @PostMapping()
    public String update(@ModelAttribute Game game, Model model) {
        model.addAttribute("game", gameRepository.save(game));
        return "redirect:/game/list";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteById(@PathVariable Long id, Model model) {
        gameRepository.deleteById(id);
        return "redirect:/game/list";
    }

    @GetMapping(path = "/create")
    public String create(Model model) {
        model.addAttribute("game", new Game());
        return "game";
    }

    private void addAttributes(Model model, List<Game> games) {
        model.addAttribute("games", games);
    }

    private void addAttributes(Model model, String attributeName, Object attribute) {
        model.addAttribute(attributeName, attribute);
    }

    @ModelAttribute("genres")
    public List<Genre> initializeGenres() {
        return genreRepository.findAll();
    }
}