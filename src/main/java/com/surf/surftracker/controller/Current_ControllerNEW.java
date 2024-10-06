package com.surf.surftracker.controller;

import com.surf.surftracker.model.Current;
import com.surf.surftracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
//@RequestMapping("/lowerTrestles")
public class Current_ControllerNEW {
    private final Map<String,Current> currentMap;

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public Current_ControllerNEW(Map<String, Current> currentMap, UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.currentMap = currentMap;
        System.out.println("Autowiring Successful: " + currentMap);
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/test")
    public String getSurfSpot(Model model) {
        System.out.println("Inside Controller, lowerTrestlesCurrent: " + currentMap.get("Lower Trestles"));
        model.addAttribute("surfSpot", currentMap.get("Lower Trestles"));
        System.out.println("Here is the data getting to the controller: " + currentMap.get("Lower Trestles"));
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
        model.addAttribute("surfSpot", currentMap.get("Lower Trestles"));
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
        model.addAttribute("lowerTrestles", currentMap.get("Lower Trestles"));
        model.addAttribute("users", userService.findAll());
        return "Home";
    }


}