package com.surf.surftracker.controller;

import com.surf.surftracker.service.UserService;
import com.surf.surftracker.model.Current;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/lowerTrestles")
public class Current_Controller {

    private final Current lowerTrestlesCurrent;
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public Current_Controller(Current lowerTrestlesCurrent,UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.lowerTrestlesCurrent = lowerTrestlesCurrent;
        System.out.println("Autowiring Successful: " + lowerTrestlesCurrent);
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/test")
    public String getSurfSpot(Model model) {
        System.out.println("Inside Controller, lowerTrestlesCurrent: " + lowerTrestlesCurrent);
        model.addAttribute("surfSpot", lowerTrestlesCurrent);
        System.out.println("Here is the data getting to the controller: " + lowerTrestlesCurrent);
        return "test";
    }

    // Basic endpoint to confirm application is running
    @GetMapping("/testpage")
    public String testPage(Model model) {
        model.addAttribute("message", "Application is running successfully!");
        return "testpage";  // This should correspond to a Thymeleaf template named 'testpage.html'
    }

    @GetMapping("/lowerTrestlesCurrent")
    public String getLowerTrestles(Model model) {
        model.addAttribute("surfSpot", lowerTrestlesCurrent);
        return "lowerTrestlesCurrent";
    }

    @GetMapping("/lowerTrestlesHourly")
    public String lowerTrestlesHourly() {
        return "lowerTrestlesHourly"; // Stubbed Page
    }

    @GetMapping("/lowerTrestlesFiveDay")
    public String lowerTrestlesFiveDay() {
        return "lowerTrestlesFiveDay"; // Stubbed Pag
    }

    @GetMapping("/TStreetCurrent")
    public String TStreetCurrent() {
        return "tStreetCurrent"; // Stubbed Page
    }

    @GetMapping("/TStreetHourly")
    public String TStreetHourly() {
        return "tStreetHourly"; // Stubbed Page
    }

    @GetMapping("/TStreetFiveDay")
    public String TStreetFiveDay() {
        return "tStreetFiveDay"; // Stubbed Page
    }

    /*
    @GetMapping("/")
    public String TStreetFiveDay() {
        return "TStreetFiveDay"; // Stubbed Page
    }
*/


    @GetMapping("/Home")
    public String TStreetCurrent2(Model model) {
        model.addAttribute("lowerTrestles", lowerTrestlesCurrent);
        model.addAttribute("users", userService.findAll());
        return "Home";
    }


}