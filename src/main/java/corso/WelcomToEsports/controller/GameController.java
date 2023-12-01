package corso.WelcomToEsports.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import corso.WelcomToEsports.database.GameDAO;
import corso.WelcomToEsports.modelli.Game;

@Controller
@RequestMapping("/game")
public class GameController {

    private final GameDAO gameDAO;

    @Autowired
    public GameController(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

  
    @GetMapping("/")
    public String openGame(Model model) {
        // Assuming you have a method in GameDAO to get the games
        HashMap<Integer, Game> games = gameDAO.read();
        model.addAttribute("games", games.values());
        return "home";
    }

    
    

    @PostMapping("/addTeam")
    public String addNewTeam() {
        System.out.println("TEAM INSERITO NEL DB");
        return "redirect:/game/";
    }

    @PostMapping("/addMatch")
    public String addNewMatch() {
        System.out.println("MATCH INSERITO NEL DB");
        return "redirect:/game/";
    }
}




