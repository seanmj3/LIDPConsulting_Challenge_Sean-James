package com.lidp.challenge.se2.persistence.dao;

import com.lidp.challenge.se2.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
}
