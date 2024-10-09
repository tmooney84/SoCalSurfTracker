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
    @GetMapping("/TamarackCurrent")
    public String getTamarack(Model model) {
        model.addAttribute("surfSpot", currentMap.get("Tamarack"));
        return "tamarackCurrent";
    }

    //Oceanside
    @GetMapping("/OceansideCurrent")
    public String getOceanside(Model model) {
        model.addAttribute("surfSpot", currentMap.get("Oceanside"));
        return "oceansideCurrent";
    }

    //San Onofre
    @GetMapping("/SanOnofreCurrent")
    public String getSanOnofreCurrent(Model model) {
        model.addAttribute("surfSpot", currentMap.get("San Onofre"));
        return "sanOnofreCurrent";
    }

    //Lower Trestles
    //also Hourly and FiveDay are stubbed
    @GetMapping("/LowerTrestlesCurrent")
    public String getLowerTrestles(Model model) {
        model.addAttribute("surfSpot", currentMap.get("Lower Trestles"));
        return "lowerTrestlesCurrent";
    }

    @GetMapping("/LowerTrestlesHourly")
    public String lowerTrestlesHourly() {
        return "lowerTrestlesHourly"; // Stubbed Page
    }

    @GetMapping("/LowerTrestlesFiveDay")
    public String lowerTrestlesFiveDay() {
        return "lowerTrestlesFiveDay"; // Stubbed Pag
    }

    //Upper Trestles
        @GetMapping("/UpperTrestlesCurrent")
        public String getUpperTrestles(Model model) {
            model.addAttribute("surfSpot", currentMap.get("Upper Trestles"));
            return "upperTrestlesCurrent";
        }

    //T Street
    @GetMapping("/TStreetCurrent")
    public String getTStreet(Model model) {
        model.addAttribute("surfSpot", currentMap.get("T-Street"));
        return "tStreetCurrent";
    }
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


    //Doheny
    @GetMapping("/DohenyCurrent")
    public String getDoheny(Model model) {
        model.addAttribute("surfSpot", currentMap.get("Doheny"));
        return "dohenyCurrent";
    }


    //Salt Creek
    @GetMapping("/SaltCreekCurrent")
    public String getSaltCreek(Model model) {
        model.addAttribute("surfSpot", currentMap.get("Salt Creek"));
        return "saltCreekCurrent";
    }


    //Newport Beach
    @GetMapping("/NewportBeachCurrent")
    public String getNewportBeach(Model model) {
        model.addAttribute("surfSpot", currentMap.get("Newport Beach"));
        return "newportBeachCurrent";
    }

    //Huntington Beach                                  ****need to complete
    @GetMapping("/HuntingtonBeachCurrent")
    public String getHuntingtonBeach(Model model) {
        model.addAttribute("surfSpot", currentMap.get("Huntington Beach"));
        return "huntingtonBeachCurrent";
    }


//    @GetMapping("/HuntingtonBeachHourly")
//    public String HuntingtonBeachHourly() {
//        return "huntingtonBeachHourly"; // Stubbed Page
//    }
//    @GetMapping("/HuntingtonBeachFiveDay")
//    public String HuntingtonBeachFiveDay() {
//        return "huntingtonBeachFiveDay"; // Stubbed Page
//    }

    //Seal Beach Pier
    @GetMapping("/SealBeachPierCurrent")
    public String getSealBeachPier(Model model) {
        model.addAttribute("surfSpot", currentMap.get("Seal Beach Pier"));
        return "sealBeachPierCurrent";
    }






    /*
    @GetMapping("/")
    public String TStreetFiveDay() {
        return "TStreetFiveDay"; // Stubbed Page
    }
*/

    //**** need to update
    @GetMapping("/Home")
    public String getHome(Model model) {
        model.addAttribute("ponto", currentMap.get("Ponto (Carlsbad)"));
        model.addAttribute("tamarack", currentMap.get("Tamarack"));
        model.addAttribute("oceanside", currentMap.get("Oceanside"));
        model.addAttribute("sanOnofre", currentMap.get("San Onofre"));
        model.addAttribute("lowerTrestles", currentMap.get("Lower Trestles"));
        model.addAttribute("upperTrestles", currentMap.get("Upper Trestles"));
        model.addAttribute("tStreet", currentMap.get("T-Street"));
        model.addAttribute("doheny", currentMap.get("Doheny"));
        model.addAttribute("saltCreek", currentMap.get("Salt Creek"));
        model.addAttribute("newportBeach", currentMap.get("Newport Beach"));
        model.addAttribute("huntingtonBeach", currentMap.get("Huntington Beach"));
        model.addAttribute("sealBeachPier", currentMap.get("Seal Beach Pier"));
        model.addAttribute("users", userService.findAll());
        return "Home";
    }


}