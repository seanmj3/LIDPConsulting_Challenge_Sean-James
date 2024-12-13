package com.lidp.challenge.se2.controller;

import com.lidp.challenge.se2.domain.CustomerDTO;
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
  public CustomerDTO save(@RequestBody CustomerDTO customerDTO) {
    return customerService.save(customerDTO);
  }

  @GetMapping
  public List<CustomerDTO> findAll() {
    return customerService.findAll();
  }

  @GetMapping("/{id}")
  public CustomerDTO findById(@PathVariable Integer id) {
    return customerService.findById(id);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Integer id) {
    customerService.deleteById(id);
  }

  @GetMapping("/{id}/address/{address_id}")
  public AddressEntity findAddressById(@PathVariable Integer addressId) { return this.addressService.findAddressById(addressId); }

  @GetMapping("/{id}/address")
  public List<AddressEntity> findAllAddresses() { return this.addressService.findAllAddresses(); }

  // TODO: Create CRUD mappers for AddressService
  @PostMapping("/{id}/address/{address_id}")
  public void updateAddress(@RequestBody AddressEntity address, @RequestBody Integer addressId) { this.addressService.updateAddress(address, addressId); }

  @DeleteMapping("/{id}/address/{address_id}")
  public void deleteAddress(@PathVariable Integer addressId) { this.addressService.deleteAddress(addressId); }

  @PostMapping("/{id}/address")
  public void createAddress(@RequestBody AddressEntity addressEntity, Integer customerId) { this.addressService.createAddress(addressEntity, customerId); }

}
