package com.lidp.challenge.se2.service;

import com.lidp.challenge.se2.persistence.dao.AddressRepository;
import com.lidp.challenge.se2.persistence.dao.CustomerRepository;
import com.lidp.challenge.se2.persistence.entity.AddressEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<AddressEntity> findAllAddresses() {
        Iterable<AddressEntity> addresses = addressRepository.findAll();
        return StreamSupport.stream(addresses.spliterator(), false).collect(Collectors.toList());
    }

    public AddressEntity findAddressById(int id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Address Found"));
    }
}
