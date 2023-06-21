package com.titankids.stock.controller;


import com.titankids.stock.model.*;
import com.titankids.stock.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderRepository orderRepository;
    private final GameRepository gameRepository;
    private final ClientRepository clientRepository;
    private final OrderTypeRepository orderTypeRepository;
    private final OrderStatusRepository orderStatusRepository;

    @GetMapping(path = "/list")
    public String getAllOrder(Model model, @Param("keyword") String keyword) {
        addAttributes(model, orderRepository.findAllOrderByCreatedAt());
        if (Objects.nonNull(keyword) && !keyword.isEmpty()) {
            addAttributes(model, "order", orderRepository.filterBy(keyword));
            addAttributes(model, "keyword", keyword);
        } else {
            addAttributes(model, orderRepository.findAll());
            addAttributes(model, "keyword", keyword);
        }
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

    @GetMapping(path = "/create")
    public String create(Model model) {
        model.addAttribute("order", new Order());
        return "order";
    }

    private void addAttributes(Model model, List<Order> order) {
        model.addAttribute("order", order);
    }

    private void addAttributes(Model model, String attributeName, Object attribute) {
        model.addAttribute(attributeName, attribute);
    }
    @ModelAttribute("games")
    public List<Game> initializeGames() {
        return gameRepository.findAll();
    }

    @ModelAttribute("clients")
    public List<Client> initializeClients() {
        return clientRepository.findAll();
    }

    @ModelAttribute("types")
    public List<OrderType> initializeTypes() {
        return orderTypeRepository.findAll();
    }

    @ModelAttribute("statuses")
    public List<OrderStatus> initializeStatuses() {
        return orderStatusRepository.findAll();
    }

}

