package com.StanGreerMillworks.SGMapp.service;

import com.StanGreerMillworks.SGMapp.DTO.CustomerDTO;
import com.StanGreerMillworks.SGMapp.Service.CustomerService;
import com.StanGreerMillworks.SGMapp.domain.Customer;
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

public class CustomerServiceTest {

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
        when(customerRepository.save(any(Customer.class))).thenAnswer(i -> i.getArguments()[0]);

        Customer savedCustomer = customerService.saveOrUpdateCustomer(customerDTO);

        assertNotNull(savedCustomer);
        assertEquals("John", savedCustomer.getFirstName());
        assertEquals("Doe", savedCustomer.getLastName());
        verify(customerRepository, times(1)).findByPhone1OrPhone2("123-456-7890", null);
        verify(customerRepository, times(1)).save(any(Customer.class));
    }

    @Test
    public void testSaveOrUpdateCustomer_updateExistingCustomer() {
        Customer existingCustomer = new Customer();
        existingCustomer.setPhone1("123-456-7890");
        existingCustomer.setFirstName("Jane");
        existingCustomer.setLastName("Doe");

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setPhone1("123-456-7890");
        customerDTO.setFirstName("John");
        customerDTO.setLastName("Doe");

        when(customerRepository.findByPhone1OrPhone2("123-456-7890", null)).thenReturn(Optional.of(existingCustomer));
        when(customerRepository.save(any(Customer.class))).thenAnswer(i -> i.getArguments()[0]);

        Customer updatedCustomer = customerService.saveOrUpdateCustomer(customerDTO);

        assertNotNull(updatedCustomer);
        assertEquals("John", updatedCustomer.getFirstName());
        assertEquals("Doe", updatedCustomer.getLastName());
        verify(customerRepository, times(1)).findByPhone1OrPhone2("123-456-7890", null);
        verify(customerRepository, times(1)).save(any(Customer.class));

    }
}
