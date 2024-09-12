package com.StanGreerMillworks.SGMapp.Service;

import com.StanGreerMillworks.SGMapp.DTO.CustomerDTO;
import com.StanGreerMillworks.SGMapp.domain.CustomerInfo;
import com.StanGreerMillworks.SGMapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDTO findCustomerByPhoneNumber(String phoneNumber){
        Optional<CustomerInfo> customer = customerRepository.findByPhone1OrPhone2(phoneNumber,phoneNumber);
        return customer.map(this::convertToDTO).orElse(null);
    }

    private CustomerDTO convertToDTO(CustomerInfo customerInfo){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setPhone1(customerInfo.getPhone1());
        customerDTO.setPhone2(customerInfo.getPhone2());
        return customerDTO;
    }

    public CustomerInfo saveOrUpdateCustomer(CustomerDTO customerDTO){
        CustomerInfo customerInfo = customerRepository.findByPhone1OrPhone2(customerDTO.getPhone1(), customerDTO.getPhone2())
                .orElse(new CustomerInfo());
        customerInfo.setPhone1(customerDTO.getPhone1());
        customerInfo.setPhone2(customerDTO.getPhone2());
        customerInfo.setEmail(customerDTO.getEmail());
        customerInfo.setFirstName(customerDTO.getFirstName());
        customerInfo.setLastName(customerDTO.getLastName());
        customerInfo.setAddressLine1(customerDTO.getAddressLine1());
        customerInfo.setAddressLine2(customerDTO.getAddressLine2());
        customerInfo.setCity(customerDTO.getCity());
        customerInfo.setState(customerDTO.getState());
        customerInfo.setZip(customerDTO.getZip());
        return customerRepository.save(customerInfo);
    }
}
