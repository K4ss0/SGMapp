package com.StanGreerMillworks.SGMapp.web;

import com.StanGreerMillworks.SGMapp.Service.GeneralWindowInfoService;
import com.StanGreerMillworks.SGMapp.Service.SpecificWindowInfoService;
import com.StanGreerMillworks.SGMapp.Service.WindowListService;
import com.StanGreerMillworks.SGMapp.domain.GeneralWindowInfo;
import com.StanGreerMillworks.SGMapp.domain.SpecificWindowInfo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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
        List<GeneralWindowInfo> generalInfo = generalWindowInfoService.getAllGeneralWindowInfo();
        List<SpecificWindowInfo> specificInfo = specificWindowInfoService.getAllSpecificWindowInfo();
        List<WindowListItem> windowList = windowListService.getAllWindowListItems();

        model.addAttribute("generalInfo", generalInfo);
        model.addAttribute("specificInfo", specificInfo);
        model.addAttribute("windowList", windowList);

        return "windowInformation";
    }

    @PostMapping("/save-general-info")
    public String saveGeneralWindowInfo(@ModelAttribute GeneralWindowInfo generalInfo){
        generalWindowInfoService.saveGeneralWindowInfo(generalInfo);
        return "redirect:/window-information";
    }

    @PostMapping String saveSpecificWindowInfo(@ModelAttribute SpecificWindowInfo specificInfo){
        SpecificWindowInfo savedInfo = specificWindowInfoService.saveSpecificWindowInfo(specificInfo);

        WindowListItem listItem = new WindowListItem(savedInfo);
        windowListService.addWindowToList(listItem);
        return "redirect:/window-information";
    }
}
