package com.titankids.stock.controller;


import com.titankids.stock.model.Games;
import com.titankids.stock.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/games")
public class GamesController {

    @Autowired
    private GamesRepository gamesRepository;

    @GetMapping(path = "/list")
    public String getAllGames(Model model) {
        addAttributes(model, gamesRepository.findAll());
        return "games-list";
    }

    private void addAttributes(Model model, List<Games> games) {
        model.addAttribute("games", games);
    }
}