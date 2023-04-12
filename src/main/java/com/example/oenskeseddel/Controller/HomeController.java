package com.example.oenskeseddel.Controller;

import com.example.oenskeseddel.Model.Bruger;
import com.example.oenskeseddel.Service.BrugerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    BrugerService brugerService;

    @GetMapping("/")
    public String index() {
        return "Home/index";
    }

    // make methods in this line.
    @GetMapping("/createBruger")
    public String createBruger() {
        return "Home/createBruger";
    }

    @PostMapping("/createNewBruger")
    public String createNew(@ModelAttribute Bruger bruger) {
        brugerService.addBruger(bruger);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "Home/login";
    }
}

