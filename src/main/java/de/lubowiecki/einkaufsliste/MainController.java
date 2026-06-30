package de.lubowiecki.einkaufsliste;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MainController {

    private EintragRepository repo;

    // Wird automatisch von Spring aufgerufen. Ähnlich wie Autowired
    public MainController(EintragRepository repo) {
        this.repo = repo;
    }

    @GetMapping("")
    public String home(Model ui) { // Model = Transportschicht zwischen Controller und Template
        ui.addAttribute("headline", "Herzlich Willkommen!");
        ui.addAttribute("description", "Das ist ja ganz toll...");
        return "standard"; // Name des Template (resources/templates/standard.html)
    }

    @GetMapping("/about")
    public String about(Model ui) {
        ui.addAttribute("headline", "Über uns");
        return "standard";
    }

    @GetMapping("/service")
    public String services(Model ui) {
        ui.addAttribute("headline", "Einkaufsliste");
        ui.addAttribute("showTable", true);
        ui.addAttribute("eintraege", repo.findAll());
        return "standard";
    }

    @GetMapping("/contact")
    public String contact(Model ui) {
        ui.addAttribute("headline", "Kontakt");
        return "standard";
    }

    @PostMapping("/add")
    public String add(@RequestBody String name, Model ui) {

        return "standard";
    }
}
