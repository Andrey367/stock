package com.titankids.stock.controller;


import com.titankids.stock.model.Client;
import com.titankids.stock.model.OrderType;
import com.titankids.stock.repository.ClientRepository;
import com.titankids.stock.repository.OrderTypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order/type")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderTypeController {

    OrderTypeRepository orderTypeRepository;

    @GetMapping(path = "/list")
    public String getAllTypes(Model model) {
        addAttributes(model, orderTypeRepository.findAll());
        return "order-type-list";
    }

    @GetMapping(path = "/{id}")
    public String getById(@PathVariable Long id, Model model) {
        model.addAttribute("type", orderTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Order type with id %d not found", id))));
        return "order-type";
    }

    @PostMapping
    public String update(@ModelAttribute OrderType type, Model model) {
        model.addAttribute("type", orderTypeRepository.save(type));
        return "redirect:/order/type/list";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteById(@PathVariable Long id, Model model) {
        orderTypeRepository.deleteById(id);
        return "redirect:/order/type/list";
    }
    @GetMapping(path = "/create")
    public String create(Model model) {
        model.addAttribute("type", new OrderType());
        return "order-type";
    }

    private void addAttributes(Model model, List<OrderType> types) {
        model.addAttribute("types", types);
    }
}
