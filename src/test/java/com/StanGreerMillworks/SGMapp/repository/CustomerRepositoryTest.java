package com.StanGreerMillworks.SGMapp.repository;

import com.StanGreerMillworks.SGMapp.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
    public void testSaveCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Test");
        customer.setLastName("Subject");
        customer.setPhone1("123-456-7890");
        customer.setPhone2("098-765-4321");
        customer.setAddressLine1("123 New St");
        customer.setAddressLine2("Apt 0000");
        customer.setCity("Testville");
        customer.setState("AZ");
        customer.setZip("12345");

        Customer savedCustomer = customerRepository.save(customer);

        Optional<Customer> foundCustomer = customerRepository.findById(savedCustomer.getId());

        assertTrue(foundCustomer.isPresent(), "Customer should be found in repository");
        assertEquals("Test", foundCustomer.get().getFirstName());
        assertEquals("Subject", foundCustomer.get().getLastName());
        assertEquals("123-456-7890", foundCustomer.get().getPhone1());
        assertEquals("Apt 0000", foundCustomer.get().getAddressLine2());
    }
}