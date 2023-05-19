package com.titankids.stock.controller;

import com.titankids.stock.model.report.BuySalesReport;
import com.titankids.stock.model.report.SalesByGenre;
import com.titankids.stock.model.report.SalesByMonth;
import com.titankids.stock.repository.BuySalesRepository;
import com.titankids.stock.repository.SalesByGenreRepository;
import com.titankids.stock.repository.SalesByMonthRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReportController {

    SalesByGenreRepository salesByGenreRepository;
    SalesByMonthRepository salesByMonthRepository;
    BuySalesRepository buySalesRepository;

    @PostMapping("/sales-by-genre")
    public List<SalesByGenre> getSalesByGenre() {
        return salesByGenreRepository.findAll();
    }

    @PostMapping("/sales-by-month")
    public List<SalesByMonth> getSalesByMonth() {
        return salesByMonthRepository.findAll();
    }

    @PostMapping("/buy-sales-report")
    public List<BuySalesReport> getBuySalesReport() {
        return buySalesRepository.findAll();
    }

}
