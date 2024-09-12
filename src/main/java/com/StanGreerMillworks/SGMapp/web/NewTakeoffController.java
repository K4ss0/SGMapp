package com.StanGreerMillworks.SGMapp.web;

import com.StanGreerMillworks.SGMapp.DTO.CustomerDTO;
import com.StanGreerMillworks.SGMapp.DTO.TakeoffDTO;
import com.StanGreerMillworks.SGMapp.Service.CustomerService;
import com.StanGreerMillworks.SGMapp.Service.TakeoffService;
import com.StanGreerMillworks.SGMapp.domain.CustomerInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NewTakeoffController {

    private final TakeoffService takeoffService;
    private final CustomerService customerService;

    public NewTakeoffController(TakeoffService takeoffService, CustomerService customerService){
        this.takeoffService = takeoffService;
        this.customerService = customerService;
    }

    @GetMapping("/newTakeoff")
    public String showNewTakeoff(Model model){
        model.addAttribute("takeoff", new TakeoffDTO());
        return "newTakeoff";
    }

    @PostMapping("/newTakeoff")
    public String processNewTakeoff(@ModelAttribute TakeoffDTO takeoff, RedirectAttributes redirectAttributes){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setPhone1(takeoff.getCustomerPhone1());
        customerDTO.setPhone2(takeoff.getCustomerPhone2());
        customerDTO.setFirstName(takeoff.getCustomerFirstName());
        customerDTO.setLastName(takeoff.getCustomerLastName());
        customerDTO.setEmail(takeoff.getCustomerEmail());
        customerDTO.setAddressLine1(takeoff.getCustomerAddressLine1());
        customerDTO.setAddressLine2(takeoff.getCustomerAddressLine2());
        customerDTO.setCity(takeoff.getCustomerCity());
        customerDTO.setState(takeoff.getCustomerState());
        customerDTO.setZip(takeoff.getCustomerZip());
        CustomerInfo customerInfo = customerService.saveOrUpdateCustomer(customerDTO);
        takeoff.setCustomerId(customerInfo.getId());
        String takeoffNumber= takeoffService.saveTakeoff(takeoff);
        redirectAttributes.addFlashAttribute("takeoffNumber", takeoffNumber);
        return "redirect:/window-information";
    }
}
