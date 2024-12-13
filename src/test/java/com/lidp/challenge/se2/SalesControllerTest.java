package com.lidp.challenge.se2;

import com.lidp.challenge.se2.controller.SalesController;
import com.lidp.challenge.se2.service.SalesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static java.nio.file.Paths.get;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SalesController.class)
class SalesControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SalesService salesService;

    @Test
    void testGetTotalSalesByDateRange() throws Exception {
        when(salesService.getTotalSalesByDateRange(any(), any())).thenReturn(BigDecimal.valueOf(1000.50));

        mockMvc.perform((RequestBuilder) get("/sales/total?start=2024-01-01&end=2024-01-31"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string("1000.50"));
    }
}
