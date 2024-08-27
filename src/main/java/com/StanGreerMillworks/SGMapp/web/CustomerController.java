package com.StanGreerMillworks.SGMapp.web;

import com.StanGreerMillworks.SGMapp.DTO.CustomerDTO;
import com.StanGreerMillworks.SGMapp.Service.CustomerService;
import com.StanGreerMillworks.SGMapp.domain.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/search")
    public ResponseEntity<CustomerDTO> searchCustomer(@RequestParam String phone) {
        CustomerDTO customer = customerService.findCustomerByPhoneNumber(phone);
                if (customer != null){
                    return ResponseEntity.ok(customer);
                }else{
                    return ResponseEntity.notFound().build();
                }
    }

    //@PostMapping("/customer")
    //public String customerSearch()
        //search for existing customer
        //public String findByPhoneNumber(){
        //if (findByhoneNumber != null populate customer info
    //(future)populate list of existing open takeoffs
    //(future)existing take offs will need a date for the inspection
    //(future)will need to find a way to denote open/closed takeoffs
    //(future)list of take offs will need to be selectable
        //if(findByPhoneNumber == null createNewCustomer())
        //allow input of customerInformation
        //Button for verify customer info
        //save/update customerInformation
        //redirect to /newTakeoff carry over custoemr information
}
