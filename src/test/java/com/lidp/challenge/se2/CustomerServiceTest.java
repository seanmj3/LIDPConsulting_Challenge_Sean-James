//package com.lidp.challenge.se2;
//
//import com.lidp.challenge.se2.persistence.dao.CustomerRepository;
//import com.lidp.challenge.se2.persistence.entity.CustomerEntity;
//import com.lidp.challenge.se2.service.CustomerService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class CustomerServiceTest {
//
//    @Mock
//    private CustomerRepository customerRepository;
//
//    @InjectMocks
//    private CustomerService customerService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void save_ShouldSaveCustomer() {
//        CustomerEntity customer = new CustomerEntity();
//        when(customerRepository.save(customer)).thenReturn(customer);
//
//        customerService.save(customer);
//
//        verify(customerRepository, times(1)).save(customer);
//    }
//
//    @Test
//    void findAll_ShouldReturnListOfCustomers() {
//        List<CustomerEntity> mockCustomers = Arrays.asList(new CustomerEntity(), new CustomerEntity());
//        when(customerRepository.findAll()).thenReturn(mockCustomers);
//
//        List<CustomerEntity> result = customerService.findAll();
//
//        assertEquals(2, result.size());
//        verify(customerRepository, times(1)).findAll();
//    }
//
//    @Test
//    void findById_ShouldReturnCustomer() {
//        Integer customerId = 1;
//        CustomerEntity customer = new CustomerEntity();
//        when(customerRepository.findById(customerId)).thenReturn(Optional.of(customer));
//
//        CustomerEntity result = customerService.findById(customerId);
//
//        assertNotNull(result);
//        verify(customerRepository, times(1)).findById(customerId);
//    }
//
//    @Test
//    void findById_ShouldThrowExceptionIfCustomerNotFound() {
//        Integer customerId = 1;
//        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());
//
//        Exception exception = assertThrows(RuntimeException.class, () -> {
//            customerService.findById(customerId);
//        });
//
//        assertEquals("1 not found.", exception.getMessage());
//        verify(customerRepository, times(1)).findById(customerId);
//    }
//
//    @Test
//    void deleteById_ShouldDeleteCustomer() {
//        Integer customerId = 1;
//        doNothing().when(customerRepository).deleteById(customerId);
//
//        customerService.deleteById(customerId);
//
//        verify(customerRepository, times(1)).deleteById(customerId);
//    }
//}
