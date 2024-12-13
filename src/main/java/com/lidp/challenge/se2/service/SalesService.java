package com.lidp.challenge.se2.service;

import com.lidp.challenge.se2.persistence.dao.SalesRepository;
import com.lidp.challenge.se2.persistence.entity.SalesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class SalesService {
    private final SalesRepository salesRepository;

    @Autowired
    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public BigDecimal getTotalSalesByDateRange(LocalDate startDate, LocalDate endDate) {
        return salesRepository.findTotalSalesByDateRange(startDate, endDate);
    }

    public BigDecimal getTotalSalesByCustomer(Integer customerId) {
        return salesRepository.findTotalSalesByCustomer(customerId);
    }

    public List<SalesEntity> getSalesByDateRange(LocalDate startDate, LocalDate endDate) {
        return salesRepository.findSalesByDateRange(startDate, endDate);
    }
}
