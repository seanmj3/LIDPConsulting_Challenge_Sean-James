package com.lidp.challenge.se2.controller;

import com.lidp.challenge.se2.persistence.entity.SalesEntity;
import com.lidp.challenge.se2.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {
    private final SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping("/total-by-date")
    public BigDecimal getTotalSalesByDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return salesService.getTotalSalesByDateRange(startDate, endDate);
    }

    @GetMapping("/total-by-customer/{customerId}")
    public BigDecimal getTotalSalesByCustomer(@PathVariable Integer customerId) {
        return salesService.getTotalSalesByCustomer(customerId);
    }

    @GetMapping("/graph-data")
    public List<SalesEntity> getGraphData(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return salesService.getSalesByDateRange(startDate, endDate);
    }
}
