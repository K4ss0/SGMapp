package com.StanGreerMillworks.SGMapp.web;

import com.StanGreerMillworks.SGMapp.DTO.WindowListDTO;
import com.StanGreerMillworks.SGMapp.Service.GeneralWindowInfoService;
import com.StanGreerMillworks.SGMapp.Service.SpecificWindowInfoService;
import com.StanGreerMillworks.SGMapp.Service.WindowListService;
import com.StanGreerMillworks.SGMapp.domain.GeneralWindowInfo;
import com.StanGreerMillworks.SGMapp.domain.SpecificWindowInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WindowInformationController {

    @Autowired
    private GeneralWindowInfoService generalWindowInfoService;

    @Autowired
    private SpecificWindowInfoService specificWindowInfoService;

    @Autowired
    private WindowListService windowListService;

    @GetMapping("/window-information")
    public String getwindowInformation(Model model) {
        List<WindowListDTO> windowList = windowListService.getWindowList();
        model.addAttribute("windowList", windowList);
        return "windowInformation";
    }

    @PostMapping("/save-general-window-info")
    public String saveGeneralWindowInfo(@ModelAttribute GeneralWindowInfo generalWindowInfo){
        generalWindowInfoService.saveGeneralWindowInfo(generalWindowInfo);
        return "redirect:/window-information";
    }

    @PostMapping ("/save-specific-window-info")
    String saveSpecificWindowInfo(@ModelAttribute SpecificWindowInfo specificWindowInfo){
        SpecificWindowInfo savedInfo = specificWindowInfoService.saveSpecificWindowInfo(specificWindowInfo);
        return "redirect:/window-information";
    }

}
