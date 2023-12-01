package corso.WelcomToEsports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import corso.WelcomToEsports.database.GameDAO;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("games", GameDAO.getInstance().read());
        return "home.html";
    }
}

