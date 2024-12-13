package com.lidp.challenge.se2.persistence.dao;

import com.lidp.challenge.se2.persistence.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
}
