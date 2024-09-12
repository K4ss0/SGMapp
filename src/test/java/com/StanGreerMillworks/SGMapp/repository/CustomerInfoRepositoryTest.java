package com.StanGreerMillworks.SGMapp.repository;

import com.StanGreerMillworks.SGMapp.domain.CustomerInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class CustomerInfoRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
    public void testSaveCustomer() {
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setFirstName("Test");
        customerInfo.setLastName("Subject");
        customerInfo.setPhone1("123-456-7890");
        customerInfo.setPhone2("098-765-4321");
        customerInfo.setAddressLine1("123 New St");
        customerInfo.setAddressLine2("Apt 0000");
        customerInfo.setCity("Testville");
        customerInfo.setState("AZ");
        customerInfo.setZip("12345");

        CustomerInfo savedCustomerInfo = customerRepository.save(customerInfo);

        Optional<CustomerInfo> foundCustomer = customerRepository.findById(savedCustomerInfo.getId());

        assertTrue(foundCustomer.isPresent(), "Customer should be found in repository");
        assertEquals("Test", foundCustomer.get().getFirstName());
        assertEquals("Subject", foundCustomer.get().getLastName());
        assertEquals("123-456-7890", foundCustomer.get().getPhone1());
        assertEquals("Apt 0000", foundCustomer.get().getAddressLine2());
    }
}