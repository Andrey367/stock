package com.titankids.stock.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping(path = "/")
    public String redirect() {
        return "redirect:/catalog";
    }

    @GetMapping(path = "/catalog")
    public String catalog() {
        return "catalog";
    }

    @GetMapping("/report")
    public String reportPage() {
        return "report";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        SecurityContextHolder.clearContext();
        model.addAttribute("logout", true);
        return "login";
    }

}
