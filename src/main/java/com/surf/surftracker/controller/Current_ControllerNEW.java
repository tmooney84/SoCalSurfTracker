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

    //Ponto

    @GetMapping("/PontoCurrent")
    public String getPonto(Model model) {
        model.addAttribute("surfSpot", currentMap.get("Ponto (Carlsbad)"));
        return "pontoCurrent";
    }


//    //Tamarack
//    @GetMapping("/lowerTrestlesCurrent")
//    public String getLowerTrestles(Model model) {
//        model.addAttribute("surfSpot", currentMap.get("Lower Trestles"));
//        return "lowerTrestlesCurrent";
//    }
//
//    //Oceanside
//    @GetMapping("/lowerTrestlesCurrent")
//    public String getLowerTrestles(Model model) {
//        model.addAttribute("surfSpot", currentMap.get("Lower Trestles"));
//        return "lowerTrestlesCurrent";
//    }
//    //San Onofre
//    @GetMapping("/lowerTrestlesCurrent")
//    public String getLowerTrestles(Model model) {
//        model.addAttribute("surfSpot", currentMap.get("Lower Trestles"));
//        return "lowerTrestlesCurrent";

    //Lower Trestles    ********change the Lower Trestles name to the  <span th:text="${surfSpot.getSurfSpotName() != null ? surfSpot.getSurfSpotName() : 'N/A'}"
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



//    //Upper Trestles
//        @GetMapping("/lowerTrestlesCurrent")
//        public String getLowerTrestles(Model model) {
//            model.addAttribute("surfSpot", currentMap.get("Lower Trestles"));
//            return "lowerTrestlesCurrent";


//    //T Street
//    @GetMapping("/TStreetCurrent")
//    public String TStreetCurrent() {
//        return "tStreetCurrent"; // Stubbed Page
//    }
//
//    @GetMapping("/TStreetHourly")
//    public String TStreetHourly() {
//        return "tStreetHourly"; // Stubbed Page
//    }
//
//    @GetMapping("/TStreetFiveDay")
//    public String TStreetFiveDay() {
//        return "tStreetFiveDay"; // Stubbed Page
//    }


//    //Doheny
//    @GetMapping("/lowerTrestlesCurrent")
//    public String getLowerTrestles(Model model) {
//        model.addAttribute("surfSpot", currentMap.get("Lower Trestles"));
//        return "lowerTrestlesCurrent";
//
//
//    //Salt Creek
//    @GetMapping("/lowerTrestlesCurrent")
//    public String getLowerTrestles(Model model) {
//       model.addAttribute("surfSpot", currentMap.get("Lower Trestles"));
//       return "lowerTrestlesCurrent";
//
//
//    //Newport Beach
//    @GetMapping("/lowerTrestlesCurrent")
//    public String getLowerTrestles(Model model) {
//        model.addAttribute("surfSpot", currentMap.get("Lower Trestles"));
//        return "lowerTrestlesCurrent";


    //Huntington Beach                                  ****need to complete
    @GetMapping("/HuntingtonBeachCurrent")
    public String HuntingtonBeachCurrent() {
        return "huntingtonBeachCurrent"; // Stubbed Page
    }
    @GetMapping("/HuntingtonBeachHourly")
    public String HuntingtonBeachHourly() {
        return "huntingtonBeachHourly"; // Stubbed Page
    }
    @GetMapping("/HuntingtonBeachFiveDay")
    public String HuntingtonBeachFiveDay() {
        return "huntingtonBeachFiveDay"; // Stubbed Page
    }

    //Seal Beach Pier





    /*
    @GetMapping("/")
    public String TStreetFiveDay() {
        return "TStreetFiveDay"; // Stubbed Page
    }
*/

    //**** need to update
    @GetMapping("/Home")
    public String TStreetCurrent2(Model model) {
        model.addAttribute("lowerTrestles", currentMap.get("Lower Trestles"));
        model.addAttribute("ponto", currentMap.get("Ponto (Carlsbad)"));
        model.addAttribute("users", userService.findAll());
        return "Home";
    }


}