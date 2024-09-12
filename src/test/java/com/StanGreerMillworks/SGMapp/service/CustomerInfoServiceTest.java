package com.StanGreerMillworks.SGMapp.service;

import com.StanGreerMillworks.SGMapp.DTO.CustomerDTO;
import com.StanGreerMillworks.SGMapp.Service.CustomerService;
import com.StanGreerMillworks.SGMapp.domain.CustomerInfo;
import com.StanGreerMillworks.SGMapp.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CustomerInfoServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveOrUpdateCustomer_NewCustomer() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setPhone1("123-456-7890");
        customerDTO.setFirstName("John");
        customerDTO.setLastName("Doe");

        when(customerRepository.findByPhone1OrPhone2("123-456-7890", null)).thenReturn(Optional.empty());
        when(customerRepository.save(any(CustomerInfo.class))).thenAnswer(i -> i.getArguments()[0]);

        CustomerInfo savedCustomerInfo = customerService.saveOrUpdateCustomer(customerDTO);

        assertNotNull(savedCustomerInfo);
        assertEquals("John", savedCustomerInfo.getFirstName());
        assertEquals("Doe", savedCustomerInfo.getLastName());
        verify(customerRepository, times(1)).findByPhone1OrPhone2("123-456-7890", null);
        verify(customerRepository, times(1)).save(any(CustomerInfo.class));
    }

    @Test
    public void testSaveOrUpdateCustomer_updateExistingCustomer() {
        CustomerInfo existingCustomerInfo = new CustomerInfo();
        existingCustomerInfo.setPhone1("123-456-7890");
        existingCustomerInfo.setFirstName("Jane");
        existingCustomerInfo.setLastName("Doe");

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setPhone1("123-456-7890");
        customerDTO.setFirstName("John");
        customerDTO.setLastName("Doe");

        when(customerRepository.findByPhone1OrPhone2("123-456-7890", null)).thenReturn(Optional.of(existingCustomerInfo));
        when(customerRepository.save(any(CustomerInfo.class))).thenAnswer(i -> i.getArguments()[0]);

        CustomerInfo updatedCustomerInfo = customerService.saveOrUpdateCustomer(customerDTO);

        assertNotNull(updatedCustomerInfo);
        assertEquals("John", updatedCustomerInfo.getFirstName());
        assertEquals("Doe", updatedCustomerInfo.getLastName());
        verify(customerRepository, times(1)).findByPhone1OrPhone2("123-456-7890", null);
        verify(customerRepository, times(1)).save(any(CustomerInfo.class));

    }
}
