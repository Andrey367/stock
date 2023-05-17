package com.titankids.stock.controller;


import com.titankids.stock.model.OrderStatus;
import com.titankids.stock.model.OrderType;
import com.titankids.stock.repository.OrderStatusRepository;
import com.titankids.stock.repository.OrderTypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order/status")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderStatusController {

    OrderStatusRepository orderStatusRepository;

    @GetMapping(path = "/list")
    public String getAll(Model model) {
        addAttributes(model, orderStatusRepository.findAll());
        return "order-status-list";
    }

    @GetMapping(path = "/{id}")
    public String getById(@PathVariable Long id, Model model) {
        model.addAttribute("status", orderStatusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Order status with id %d not found", id))));
        return "order-status";
    }

    @PostMapping
    public String update(@ModelAttribute OrderStatus status, Model model) {
        model.addAttribute("status", orderStatusRepository.save(status));
        return "redirect:/order/status/list";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteById(@PathVariable Long id, Model model) {
        orderStatusRepository.deleteById(id);
        return "redirect:/order/status/list";
    }
    @GetMapping(path = "/create")
    public String create(Model model) {
        model.addAttribute("status", new OrderStatus());
        return "order-status";
    }

    private void addAttributes(Model model, List<OrderStatus> statuses) {
        model.addAttribute("statuses", statuses);
    }
}
