package com.surf.surftracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test_Controller{

    @GetMapping("/myPage")
    public String showPage() {
        // Add any initial data to the model if needed
        return "myPage";  // This should match the name of your HTML file in the templates folder
    }
}
