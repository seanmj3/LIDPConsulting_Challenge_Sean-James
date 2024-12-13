package com.lidp.challenge.se2.service;

import com.lidp.challenge.se2.persistence.dao.AddressRepository;
import com.lidp.challenge.se2.persistence.dao.CustomerRepository;
import com.lidp.challenge.se2.persistence.entity.AddressEntity;
import com.lidp.challenge.se2.persistence.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;
    @Autowired
    public AddressService(AddressRepository addressRepository, CustomerRepository customerRepository) {
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
    }

    // Takes an Iterable of all addresses, converts to a stream, and returns the results in a List.
    public List<AddressEntity> findAllAddresses() {
        Iterable<AddressEntity> addresses = addressRepository.findAll();
        return StreamSupport.stream(addresses.spliterator(), false).collect(Collectors.toList());
    }

    public AddressEntity findAddressById(final Integer addressId) {
        return this.addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("No Address Found"));
    }
    // TODO: Create service layer for AddressesEntity
    public AddressEntity createAddress(AddressEntity address, final Integer customerId) {
        CustomerEntity customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Address with Id: " + customerId +" not found."));
        address.setCustomer(customer);

        return this.addressRepository.save(address);
    }

    public AddressEntity updateAddress(AddressEntity updatedAddress, final Integer addressId) {
        AddressEntity currentAddress = findAddressById(addressId);
        currentAddress.setCity(updatedAddress.getCity());
        currentAddress.setCountry(updatedAddress.getCountry());
        currentAddress.setState(updatedAddress.getState());
        currentAddress.setStreet(updatedAddress.getStreet());
        currentAddress.setZipcode(updatedAddress.getZipcode());
        return this.addressRepository.save(currentAddress);
    }

    public void deleteAddress(final Integer addressId) {
        if (!addressRepository.existsById(addressId)) {
            throw new RuntimeException("Address: " + addressId + " does not exist.");
        }
        this.addressRepository.deleteById(addressId);
    }
}
