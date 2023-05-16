package com.titankids.stock.controller;


import com.titankids.stock.model.Console;
import com.titankids.stock.model.Order;
import com.titankids.stock.repository.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/console")
public class   ConsoleController {

    @Autowired
    private ConsoleRepository consoleRepository;

    @GetMapping(path = "/list")
    public String getAllConsole(Model model) {
        addAttributes(model, consoleRepository.findAll());
        return "console-list";
    }

    @GetMapping(path = "/{id}")
    public String getById(@PathVariable Long id, Model model) {
        model.addAttribute("console", consoleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Console with id %d not found", id))));
        return "console";
    }

    @PostMapping()
    public String update(@ModelAttribute Console console, Model model) {
        model.addAttribute("console", consoleRepository.save(console));
        return "redirect:/console/list";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteById(@PathVariable Long id, Model model) {
        consoleRepository.deleteById(id);
        return "redirect:/console/list";
    }
    @GetMapping(path = "/create")
    public String create(Model model) {
        model.addAttribute("console", new Console());
        return "console";
    }
    private void addAttributes(Model model, List<Console> console) {
        model.addAttribute("console", console);
    }
}
