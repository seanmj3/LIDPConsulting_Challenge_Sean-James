package com.lidp.challenge.se2.persistence.dao;

import com.lidp.challenge.se2.persistence.entity.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface SalesRepository extends JpaRepository<SalesEntity, Integer> {

    @Query("SELECT SUM(s.saleAmount) FROM SalesEntity s WHERE s.saleDate BETWEEN :startDate AND :endDate")
    BigDecimal findTotalSalesByDateRange(LocalDate startDate, LocalDate endDate);

    @Query("SELECT SUM(s.saleAmount) FROM SalesEntity s WHERE s.customerId = :customerId")
    BigDecimal findTotalSalesByCustomer(Integer customerId);

    @Query("SELECT s FROM SalesEntity s WHERE s.saleDate BETWEEN :startDate AND :endDate")
    List<SalesEntity> findSalesByDateRange(LocalDate startDate, LocalDate endDate);
}
