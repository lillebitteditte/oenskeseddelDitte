package com.example.oenskeseddel.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "Home/index";
    }
    // make methods in this line.
    @GetMapping("/createBruger")
    public String createBruger(){
        return "Home/createBruger";
    }
}
