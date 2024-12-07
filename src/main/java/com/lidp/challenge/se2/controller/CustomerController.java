package com.lidp.challenge.se2.controller;

import com.lidp.challenge.se2.persistence.entity.AddressEntity;
import com.lidp.challenge.se2.persistence.entity.CustomerEntity;
import com.lidp.challenge.se2.service.AddressService;
import com.lidp.challenge.se2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
  private final CustomerService customerService;
  private final AddressService addressService;

  @Autowired
  public CustomerController(CustomerService customerService, AddressService addressService) {
    this.customerService = customerService;
    this.addressService = addressService;
  }

  @PostMapping
  public void save(@RequestBody CustomerEntity customerEntity) {
    this.customerService.save(customerEntity);
  }

  @GetMapping
  public List<CustomerEntity> findAll() {
    return this.customerService.findAll();
  }

  @GetMapping("/{id}")
  public CustomerEntity findById(@PathVariable Integer id) {
    return this.customerService.findById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Integer id) { this.customerService.deleteById(id); }

  @GetMapping("/{id}/address")
  public AddressEntity findAddressById(@PathVariable Integer id) { return this.addressService.findAddressById(id); }

  @GetMapping("/{id}/address")
  public List<AddressEntity> findAllAddresses() {return this.addressService.findAllAddresses(); }
}
