package com.StanGreerMillworks.SGMapp.Service;

import com.StanGreerMillworks.SGMapp.DTO.CustomerDTO;
import com.StanGreerMillworks.SGMapp.domain.Customer;
import com.StanGreerMillworks.SGMapp.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDTO findCustomerByPhoneNumber(String phoneNumber){
        Optional<Customer> customer = customerRepository.findByPhone1OrPhone2(phoneNumber,phoneNumber);
        return customer.map(this::convertToDTO).orElse(null);
    }

    private CustomerDTO convertToDTO(Customer customer){

    }

    public Customer saveOrUpdateCustomer(CustomerDTO customerDTO){
        Customer customer = customerRepository.findByPhone1OrPhone2(customerDTO.getPhone1(), customerDTO.getPhone2())
                .orElse(new Customer());
        customer.setPhone1(customerDTO.getPhone1());
        customer.setPhone2(customerDTO.getPhone2());
        customer.setEmail(customerDTO.getEmail());
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setAddressLine1(customerDTO.getAddressLine1());
        customer.setAddressLine2(customerDTO.getAddressLine2());
        customer.setCity(customerDTO.getCity());
        customer.setState(customerDTO.getState());
        customer.setZip(customerDTO.getZip());
        return customerRepository.save(customer);
    }
}
