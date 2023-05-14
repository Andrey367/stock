package com.titankids.stock.controller;


import com.titankids.stock.model.Order;
import com.titankids.stock.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping(path = "/list")
    public String getAllOrder(Model model) {
        addAttributes(model, orderRepository.findAll());
        return "order-list";
    }

    @GetMapping(path = "/{id}")
    public String getById(@PathVariable Long id, Model model) {
        model.addAttribute("order", orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Order with id %d not found", id))));
        return "order";
    }

    @PostMapping()
    public String update(@ModelAttribute Order order, Model model) {
        model.addAttribute("order", orderRepository.save(order));
        return "redirect:/order/list";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteById(@PathVariable Long id, Model model) {
        orderRepository.deleteById(id);
        return "redirect:/order/list";
    }

    private void addAttributes(Model model, List<Order> order) {
        model.addAttribute("order", order);
    }
}

