package com.lidp.challenge.se2;

import com.lidp.challenge.se2.service.CustomerService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Se2ApplicationTests {

  @BeforeAll
  static void beforeAll() {
    System.out.println("Starting tests now.");
  }

//  @ExtendWith(MockitoExtension.class)
//  class CustomerControllerTest {
//
//    @Mock
//    CustomerService mockCustomerService;
//  }
//  @Test
//  void contextLoads() {
//
//  }

  @AfterAll
  static void afterAll() {
    System.out.println("Done with tests.");
  }
}