package com.StanGreerMillworks.SGMapp.web;

import com.StanGreerMillworks.SGMapp.DTO.TakeoffDTO;
import com.StanGreerMillworks.SGMapp.Service.TakeoffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NewTakeoffController {

    private final TakeoffService takeoffService;

    public NewTakeoffController(TakeoffService takeoffService){
        this.takeoffService = takeoffService;
    }

    @GetMapping("/newTakeoff")
    public String showNewTakeoff(Model model){
        model.addAttribute("takeoff", new TakeoffDTO());
        return "newTakeoff";
    }

    @PostMapping("/newTakeoff")
    public String processNewTakeoff(@ModelAttribute TakeoffDTO takeoff, RedirectAttributes redirectAttributes){
        //save takeoff data
        String takeoffNumber= takeoffService.saveTakeoff(takeoff);

        redirectAttributes.addFlashAttribute("takeoffNumber", takeoffNumber);
        return "redirect:/windowInformation";
    }
}
