package de.gfn.einkaufsliste;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Liefert HTML aus
public class MainController {

    @RequestMapping("")
    public String startseite(Model ui) {
        // Model ist die Transportschicht zwischen Controller und HTML-Vorlage
        ui.addAttribute("headline", "Startseite");
        return "standard"; // Name der HTML-Vorlage ohne der Endung
    }

    @RequestMapping("/list")
    public String liste(Model ui) {
        ui.addAttribute("headline", "Liste");
        return "standard";
    }

    @RequestMapping("/products")
    public String produkte(Model ui) {
        ui.addAttribute("headline", "Produkte");
        return "standard";
    }

    @RequestMapping("/customers")
    public String kunden(Model ui) {
        ui.addAttribute("headline", "Kunden");
        return "standard";
    }
}
