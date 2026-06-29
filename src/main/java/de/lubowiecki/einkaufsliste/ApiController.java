package de.lubowiecki.einkaufsliste;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RequestMapping("/api/v1")
@RestController
public class ApiController {

    /*
    HTTP-Methoden
    GET: Daten abfragen
    POST: Objekt hinzufügen
    PUT: Objekt ändern
    DELETE: Objekt löschen
    HEAD: Verfügbarkeit testen
    */

    private List<Eintrag> eintraege;

    public ApiController() {
        eintraege = new ArrayList<>();
        eintraege.add(new Eintrag("Milch"));
        eintraege.add(new Eintrag("Butter"));
        eintraege.add(new Eintrag("Wurst", true));
        eintraege.add(new Eintrag("Käse"));
        eintraege.add(new Eintrag("Kaffee"));
    }

    // URL: http://localhost:8080/
    @GetMapping("") // Mapping von einer URL auf diese Methode
    public List<Eintrag> ganzeListe() {
        return eintraege;
    }

    // URL: http://localhost:8080/api/v1/open
    @GetMapping("/open") // Jede URL muss in der ganzen APP einzigartig sein
    public List<Eintrag> offeneListe() {
        Predicate<Eintrag> istOffen = e -> !e.isErledigt(); // Nicht erledigt
        return eintraege.stream()
                .filter(istOffen) // Filtern
                .collect(Collectors.toList()); // Elemente als Liste sammeln
    }

    // URL: http://localhost:8080/api/v1/done
    @GetMapping("/done")
    public List<Eintrag> erledigteListe() {
//        Predicate<Eintrag> istErledigt = e -> e.isErledigt();
//        return eintraege.stream()
//                .filter(istErledigt) // Filtern
//                .collect(Collectors.toList()); // Elemente als Liste sammeln
//
//        return eintraege.stream()
//                .filter(e -> e.isErledigt())
//                .collect(Collectors.toList());

        return eintraege.stream()
                .filter(Eintrag::isErledigt) // Methoden-Referenz
                .collect(Collectors.toList());

    }

    @PostMapping("/add")
    public Eintrag hinzufuegen(@RequestBody Eintrag eintrag) {
        eintraege.add(eintrag);
        return eintrag;
    }

    @DeleteMapping("/delete/{id}")
    public List<Eintrag> loeschen(@PathVariable int id) { // Id wird aus der URL gewonnen
        Predicate<Eintrag> idPasst = e -> e.getId() == id;
        eintraege.removeIf(idPasst); // Entfernt den Eintrag mit passender ID
        return eintraege;
    }

    @PutMapping("/update/{id}")
    public List<Eintrag> aendern(@PathVariable int id, @RequestBody Eintrag eintrag) {
        Predicate<Eintrag> idPasst = e -> e.getId() == id;
        Eintrag e = eintraege.stream()
                        .filter(idPasst)
                        .findFirst()
                        .get();

        e.setName(eintrag.getName());
        // TODO: Setter für erledigt bauen

        return eintraege;
    }
}
