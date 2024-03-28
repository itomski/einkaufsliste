package de.lubowiecki.einkaufsliste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;


//@RestController // für Definition einer Rest-API nötig
@Controller // Controller, der HTML zurückgibt und mit einer Template-Engine arbeiten kann
public class EinkaufController {

    @Autowired // Bindet automatisch ein Objekt des Repository an die Variable
    private EintragRepository repo;


    @GetMapping("/") // http://localhost:8080/
    public String index(Model ui) {
        List<Eintrag> eintraege = repo.findAll();
        // Alle Werte, die an das Model übergeben werden, sind im Template sichtbar
        ui.addAttribute("einkaufsListe", eintraege);
        return "standard"; // Name des Templates (ohne Endung)
    }

    @GetMapping("/{id}") // http://localhost:8080/1
    public String zeigeEintrag(@PathVariable int id) { // @PathVariable Wert wird aus der URL ermittelt
        Optional<Eintrag> opt = repo.findById(id);

        if(opt.isPresent()) {
            return opt.get().toString();
        }
        else {
            return "Kein passender Eintrag verfügbar";
        }
    }


    @PostMapping("/add") // http://localhost:8080/add
    public String add(Eintrag eintrag) {
        eintrag.setErzeugtAm(LocalDateTime.now());
        //Eintrag eintrag = new Eintrag(titel);
        repo.save(eintrag); // Speichern insert/update
        return "redirect:/"; // Auf die URL / umleiten
    }

    @GetMapping("/remove/{id}") // http://localhost:8080/remove/1
    public String remove(@PathVariable int id) {
        repo.deleteById(id); // Löschen
        return "redirect:/"; // Auf die URL / umleiten
    }
}
