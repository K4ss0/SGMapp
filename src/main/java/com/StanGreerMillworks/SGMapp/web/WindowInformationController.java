package com.StanGreerMillworks.SGMapp.web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class WindowInformationController {

    @GetMapping("/windowInformation")
    public String showWindowInformationPage(Model model, HttpSession session) {
        if(session.getAttribute("windows") == null) {
            session.setAttribute("windows", new ArrayList<>());
        }
        model.addAttribute("takeoffNumber, "12345);
        model.addAttribute("customerName", "John Doe");
        model.addAttribute("windows", session.getAttribute("windows"));
        return "windowInformation";
    }

    @PostMapping("/general")
    public String handleGeneralInfo(@RequestParam String brand,
                                    @RequestParam String seriesType,
                                    @RequestParam String color,
                                    //add in other general info here
                                    HttpSession session) {
        session.setAttribute("brand", brand);
        session.setAttribute("seriesType", seriesType);
        session.setAttribute("color", color);
        return "redirect:/windowInformation";//this may not be correct redirect
    }

    @PostMapping("/specific")
    public String handleSpecificInfo(@RequestParam int quantity,
                                     @RequestParam String size,
                                     @RequestParam String windowType,
                                     @RequestParam String windowLocation,
                                     @RequestParam(required = false) String grids,
                                     @RequestParam(required = false) String clear,
                                     @RequestParam(required = false) String lowE,
                                     @RequestParam(required = false) String tempered,
                                     @RequestParam(required = false) String obscured,
                                     @RequestParam(required = false) String tinted,
                                     @RequestParam(required = false) String argon,
                                     @RequestParam String action,
                                     HttpSession session) {
        String brand = (String) session.getAttribute("brand");
        String seriesType = (String) session.getAttribute("seriesType");
        String color = (String) session.getAttribute("color");

        Window window = new Window();
        window.setBrand(brand);
    }
}
