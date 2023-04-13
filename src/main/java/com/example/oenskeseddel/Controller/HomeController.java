package com.example.oenskeseddel.Controller;

import com.example.oenskeseddel.Model.Bruger;
import com.example.oenskeseddel.Model.Login;
import com.example.oenskeseddel.Service.BrugerService;
import com.example.oenskeseddel.Service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private BrugerService brugerService;
    private LoginService loginService;
    public HomeController(BrugerService brugerService, LoginService loginService) {
        this.brugerService = brugerService;
        this.loginService=loginService;
    }


    @GetMapping("/")
    public String index() {
        return "Home/index";
    }

    // make methods in this line.
    // metode til "opret bruger" knappen på forsiden
    @GetMapping("/createBruger")
    public String createBruger() {
        return "Home/createBruger";
    }


    // når oplysninger er indtastet
    @PostMapping("/createNewBruger")
    public String createNew(@ModelAttribute Bruger bruger) {
        brugerService.addBruger(bruger);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute Login login) {
        return "Home/login";
    }

    @GetMapping("/loginError")
    public String LoginError() {
      return "Home/loginError";
    }
    @PostMapping("/brugerLogin")
    public String brugerLogin(@ModelAttribute Login login) {
        String brugernavn = login.getBrugernavn();
        Bruger bruger = brugerService.findBrugernavn(brugernavn);
        if (bruger != null) {
            return "redirect:/";
        } else {
            return "Home/loginError";
        }
    }


}

