package corso.WelcomToEsports.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import corso.WelcomToEsports.database.TeamDAO;

@Controller
@RequestMapping("/team")
public class TeamController {

    private final TeamDAO teamDAO;

    @Autowired
    public TeamController(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }

    @GetMapping("/")
    public String openTeam(@RequestParam HashMap<String, String> params, Model model) {
        model.addAttribute("nomeGame", params.get("idGames"));
        model.addAttribute("nomeTeam", params.get("idTeam"));

        // Aggiungi la lista di team dal database al modello
        model.addAttribute("listaTeam", teamDAO.read());

        return "team";
    }

    @PostMapping("/updateTeam")
    public String updateTeam() {
        System.out.println("TEAM AGGIORNATO NEL DB");
        return "redirect:/team/";
    }

    @PostMapping("/deleteTeam")
    public String deleteTeam() {
        System.out.println("TEAM ELIMINATO NEL DB");
        return "redirect:/team/";
    }

    @PostMapping("/addPlayer")
    public String addPlayer() {
        System.out.println("PLAYER INSERITO NEL DB");
        return "redirect:/team/";
    }

    @PostMapping("/updatePlayer")
    public String updatePlayer() {
        System.out.println("PLAYER AGGIORNATO NEL DB");
        return "redirect:/team/";
    }

    @PostMapping("/deletePlayers")
    public String deletePlayers() {
        System.out.println("PLAYER ELIMINATO NEL DB");
        return "redirect:/team/";
    }
}



