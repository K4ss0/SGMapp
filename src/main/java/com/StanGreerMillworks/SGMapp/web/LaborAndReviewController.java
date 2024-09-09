package com.StanGreerMillworks.SGMapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LaborAndReviewController {

    @GetMapping("/labor-review")
    public String showLaborAndReview(Model model) {

        return "laborAndReview";
    }
}
