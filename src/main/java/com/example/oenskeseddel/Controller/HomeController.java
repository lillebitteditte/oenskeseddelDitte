package com.example.oenskeseddel.Controller;

import com.example.oenskeseddel.Model.Bruger;
import com.example.oenskeseddel.Model.Login;
import com.example.oenskeseddel.Model.Ønske;
import com.example.oenskeseddel.Service.BrugerService;
import com.example.oenskeseddel.Service.LoginService;
import com.example.oenskeseddel.Service.ØnskeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    private BrugerService brugerService;
    private LoginService loginService;
    private ØnskeService ønskeService;
    public HomeController(BrugerService brugerService, LoginService loginService,ØnskeService ønskeService) {
        this.brugerService = brugerService;
        this.loginService=loginService;
        this.ønskeService=ønskeService;
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
        List<Ønske>ønskeList= ønskeService.fetchAll();
        model.addAttribute("oensker",ønskeList);
        return "redirect:Home/createOenskeseddel";
    }

    @PostMapping("/createNewOenske")
    public String createNewØnske(@ModelAttribute Ønske ønske){
    ønskeService.addØnske(ønske);
    return "redirect:Home/createOenskeseddel";
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
            return "Home/createOenskeseddel";
        } else {
            return "Home/loginError";
        }
    }


}

