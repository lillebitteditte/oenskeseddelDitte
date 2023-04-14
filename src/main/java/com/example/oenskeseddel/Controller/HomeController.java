package com.example.oenskeseddel.Controller;

import com.example.oenskeseddel.Model.Bruger;
import com.example.oenskeseddel.Model.Login;
import com.example.oenskeseddel.Model.Ønske;
import com.example.oenskeseddel.Service.BrugerService;
import com.example.oenskeseddel.Service.LoginService;
import com.example.oenskeseddel.Service.ØnskeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    private BrugerService brugerService;
    private LoginService loginService;
    private ØnskeService ønskeService;

    public HomeController(BrugerService brugerService, LoginService loginService, ØnskeService ønskeService) {
        this.brugerService = brugerService;
        this.loginService = loginService;
        this.ønskeService = ønskeService;
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


    @GetMapping("/createOenskeseddel")
    public String index(Model model) {
        List<Ønske> ønskeList = ønskeService.fetchAll();
        model.addAttribute("oenske", ønskeList);
        return "Home/createOenskeseddel";
    }


    //PathVariable refererer til den værdi som vi angiver oppe i mappingen. Efterfølgende kan vi så bruge variablen.
    @GetMapping("/createOenskeseddel/{bruger_id}")
    public String indexForUser(Model model, @PathVariable int bruger_id) {
        List<Ønske> ønskeList = ønskeService.fetchUserWishes(bruger_id);
        model.addAttribute("oenske", ønskeList);
        return "Home/createOenskeseddel";
    }

    @PostMapping("/createNewOenske")
    public String createNewØnske(@ModelAttribute Ønske ønske) {
        ønskeService.addØnske(ønske);
        return "Home/createOenskeseddel";
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

    //Vi redirecter i bunden af metoden, da det sørger for at vi bliver sendt over på den rigtige html side
    //i stedet for at forblive på samme side.
    @PostMapping("/brugerLogin")
    public String brugerLogin(@ModelAttribute Login login) {
        String brugernavn = login.getBrugernavn();
        Bruger bruger = brugerService.findBrugernavn(brugernavn);
        if (bruger != null) {
            return "redirect:/createOenskeseddel/" + bruger.getBruger_id();
        } else {
            return "Home/loginError";
        }
    }
}

