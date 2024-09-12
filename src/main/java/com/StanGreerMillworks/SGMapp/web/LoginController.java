package com.StanGreerMillworks.SGMapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String showLoginPage() {
        return "login";
    }

    @PostMapping
    public ModelAndView handleLogin(@RequestParam String username, @RequestParam String password) {
        //add in authentication logic here

        ModelAndView mav = new ModelAndView("login");
        mav.setViewName("welcome");
        mav.addObject("username", username);

        return mav;
    }
}
