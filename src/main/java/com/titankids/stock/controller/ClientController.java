package com.titankids.stock.controller;


import com.titankids.stock.model.Client;
import com.titankids.stock.model.Order;
import com.titankids.stock.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(path = "/list")
    public String getAllClient(Model model) {
        addAttributes(model, clientRepository.findAll());
        return "client-list";
    }

    @GetMapping(path = "/{id}")
    public String getById(@PathVariable Long id, Model model) {
        model.addAttribute("client", clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Client with id %d not found", id))));
        return "client";
    }

    @PostMapping()
    public String update(@ModelAttribute Client client, Model model) {
        model.addAttribute("client", clientRepository.save(client));
        return "redirect:/client/list";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteById(@PathVariable Long id, Model model) {
        clientRepository.deleteById(id);
        return "redirect:/client/list";
    }
    @GetMapping(path = "/create")
    public String create(Model model) {
        model.addAttribute("client", new Client());
        return "client";
    }

    private void addAttributes(Model model, List<Client> client) {
        model.addAttribute("client", client);
    }
}
