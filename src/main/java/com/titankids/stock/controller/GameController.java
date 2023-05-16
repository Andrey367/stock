package com.titankids.stock.controller;


import com.titankids.stock.model.Game;
import com.titankids.stock.model.Genre;
import com.titankids.stock.model.Order;
import com.titankids.stock.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping(path = "/list")
    public String getAllGames(Model model) {
        addAttributes(model, gameRepository.findAll());
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
}