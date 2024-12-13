package com.lidp.challenge.se2.service;

import com.lidp.challenge.se2.domain.CustomerDTO;
import com.lidp.challenge.se2.mapper.CustomerMapper;
import com.lidp.challenge.se2.persistence.dao.CustomerRepository;
import com.lidp.challenge.se2.persistence.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerService {

  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  @Autowired
  public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
    this.customerRepository = customerRepository;
    this.customerMapper = customerMapper;
  }

  public CustomerDTO save(CustomerDTO customerDTO) {
    CustomerEntity entity = customerMapper.toEntity(customerDTO);
    CustomerEntity savedEntity = customerRepository.save(entity);
    return customerMapper.toDTO(savedEntity);
  }

  public List<CustomerDTO> findAll() {
    return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
            .map(customerMapper::toDTO)
            .collect(Collectors.toList());
  }

  public CustomerDTO findById(Integer id) {
    CustomerEntity entity = customerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Customer not found"));
    return customerMapper.toDTO(entity);
  }

  public void deleteById(Integer id) {
    customerRepository.deleteById(id);
  }
}
