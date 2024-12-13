package com.lidp.challenge.se2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lidp.challenge.se2.controller.CustomerController;
import com.lidp.challenge.se2.domain.CustomerDTO;
import com.lidp.challenge.se2.persistence.entity.AddressEntity;
import com.lidp.challenge.se2.persistence.entity.CustomerEntity;
import com.lidp.challenge.se2.service.AddressService;
import com.lidp.challenge.se2.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private AddressService addressService;

    @Test
    void testFindAllCustomers() throws Exception {
        List<CustomerDTO> customers = List.of(new CustomerDTO(1, "John Doe", null));
        when(customerService.findAll()).thenReturn(customers);

        mockMvc.perform(get("/customer"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$[0].name").value("John Doe"));
    }

//    @Test
//    void testSaveCustomer() throws Exception {
//        CustomerDTO customerDTO = new CustomerDTO(2, "Jane Doe", null);
//        doNothing().when(customerService).save(any());
//
//        mockMvc.perform(post("/customer")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(customerDTO)))
//                        .andExpect(status().isOk());
//    }
}
