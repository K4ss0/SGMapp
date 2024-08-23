package com.StanGreerMillworks.SGMapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class WindowInformationController {

    @GetMapping("/windowInformation")
    public String showWindowInformationPage(@ModelAttribute("takeoffNumber") String takeoffNumber, Model model) {
        model.addAttribute("takeoffNumber", takeoffNumber);
        return "windowInformation";
    }
}
