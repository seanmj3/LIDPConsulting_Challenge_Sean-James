package com.lidp.challenge.se2;

import com.lidp.challenge.se2.persistence.dao.AddressRepository;
import com.lidp.challenge.se2.persistence.dao.CustomerRepository;
import com.lidp.challenge.se2.persistence.entity.AddressEntity;
import com.lidp.challenge.se2.persistence.entity.CustomerEntity;
import com.lidp.challenge.se2.service.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private AddressService addressService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllAddresses_ShouldReturnListOfAddresses() {
        List<AddressEntity> mockAddresses = Arrays.asList(new AddressEntity(), new AddressEntity());
        when(addressRepository.findAll()).thenReturn(mockAddresses);

        List<AddressEntity> result = addressService.findAllAddresses();

        assertEquals(2, result.size());
        verify(addressRepository, times(1)).findAll();
    }

    @Test
    void findAddressById_ShouldReturnAddress() {
        Integer addressId = 1;
        AddressEntity address = new AddressEntity();
        when(addressRepository.findById(addressId)).thenReturn(Optional.of(address));

        AddressEntity result = addressService.findAddressById(addressId);

        assertNotNull(result);
        verify(addressRepository, times(1)).findById(addressId);
    }

    @Test
    void findAddressById_ShouldThrowExceptionIfAddressNotFound() {
        Integer addressId = 1;
        when(addressRepository.findById(addressId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            addressService.findAddressById(addressId);
        });

        assertEquals("No Address Found", exception.getMessage());
        verify(addressRepository, times(1)).findById(addressId);
    }

    @Test
    void createAddress_ShouldSaveAddress() {
        Integer customerId = 1;
        CustomerEntity customer = new CustomerEntity();
        AddressEntity address = new AddressEntity();

        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
        when(addressRepository.save(address)).thenReturn(address);

        AddressEntity result = addressService.createAddress(address, customerId);

        assertNotNull(result);
        assertEquals(customer, address.getCustomer());
        verify(customerRepository, times(1)).findById(customerId);
        verify(addressRepository, times(1)).save(address);
    }

    @Test
    void createAddress_ShouldThrowExceptionIfCustomerNotFound() {
        Integer customerId = 1;
        AddressEntity address = new AddressEntity();

        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            addressService.createAddress(address, customerId);
        });

        assertTrue(exception.getMessage().contains("Address with Id: 1 not found."));
        verify(customerRepository, times(1)).findById(customerId);
        verify(addressRepository, never()).save(any(AddressEntity.class));
    }

    @Test
    void updateAddress_ShouldUpdateAndReturnAddress() {
        Integer addressId = 1;
        AddressEntity existingAddress = new AddressEntity();
        AddressEntity updatedAddress = new AddressEntity();

        updatedAddress.setCity("New City");
        updatedAddress.setCountry("New Country");
        updatedAddress.setState("New State");
        updatedAddress.setStreet("New Street");
        updatedAddress.setZipcode("12345");

        when(addressRepository.findById(addressId)).thenReturn(Optional.of(existingAddress));
        when(addressRepository.save(existingAddress)).thenReturn(existingAddress);

        AddressEntity result = addressService.updateAddress(updatedAddress, addressId);

        assertEquals("New City", result.getCity());
        assertEquals("New Country", result.getCountry());
        assertEquals("New State", result.getState());
        assertEquals("New Street", result.getStreet());
        assertEquals("12345", result.getZipcode());

        verify(addressRepository, times(1)).findById(addressId);
        verify(addressRepository, times(1)).save(existingAddress);
    }

    @Test
    void deleteAddress_ShouldDeleteAddress() {
        Integer addressId = 1;

        when(addressRepository.existsById(addressId)).thenReturn(true);

        addressService.deleteAddress(addressId);

        verify(addressRepository, times(1)).existsById(addressId);
        verify(addressRepository, times(1)).deleteById(addressId);
    }

    @Test
    void deleteAddress_ShouldThrowExceptionIfAddressNotFound() {
        Integer addressId = 1;

        when(addressRepository.existsById(addressId)).thenReturn(false);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            addressService.deleteAddress(addressId);
        });

        assertTrue(exception.getMessage().contains("Address: 1 does not exist."));
        verify(addressRepository, times(1)).existsById(addressId);
        verify(addressRepository, never()).deleteById(addressId);
    }
}
