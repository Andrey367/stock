package com.titankids.stock.controller;

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


}
