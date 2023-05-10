package com.titankids.stock.controller;


import com.titankids.stock.model.Gameconsole;
import com.titankids.stock.repository.GameconsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/gameconsole")
public class GameconsoleController {

    @Autowired
    private GameconsoleRepository gameconsoleRepository;

    @GetMapping(path = "/list")
    public String getAllGameconsole(Model model) {
        addAttributes(model, gameconsoleRepository.findAll());
        return "gameconsole-list";
    }

    private void addAttributes(Model model, List<Gameconsole> gameconsoles) {model.addAttribute("gameconsole", gameconsoles);
    }
}
