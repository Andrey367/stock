package com.titankids.stock.controller;


import com.titankids.stock.model.Publisher;
import com.titankids.stock.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @GetMapping(path = "/list")
    public String getAllPublisher(Model model) {
        addAttributes(model, publisherRepository.findAll());
        return "publisher-list";
    }

    @GetMapping(path = "/{id}")
    public String getById(@PathVariable Long id, Model model) {
        model.addAttribute("publisher", publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Publisher with id %d not found", id))));
        return "publisher";
    }

    @PostMapping()
    public String update(@ModelAttribute Publisher publisher, Model model) {
        model.addAttribute("publisher", publisherRepository.save(publisher));
        return "redirect:/publisher/list";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteById(@PathVariable Long id, Model model) {
        publisherRepository.deleteById(id);
        return "redirect:/publisher/list";
    }

    private void addAttributes(Model model, List<Publisher> publisher) {
        model.addAttribute("publisher", publisher);
    }
}
