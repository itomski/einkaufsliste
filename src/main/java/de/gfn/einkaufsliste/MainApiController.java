package de.gfn.einkaufsliste;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/v1")
@RestController // Liefert JSON aus
public class MainApiController {

    // URL-Aufrufe werden auf Methoden umgeleitet

    // http://localhost:8080/api/v1
    @RequestMapping("")
    private String startseite() {
        return "Das ist das Haus von Nikigraus!";
    }

    // http://localhost:8080/api/v1/zeit
    @RequestMapping("/zeit")
    private String zeit() {
        return LocalDateTime.now().toString();
    }

    // http://localhost:8080/api/v1/products
    @RequestMapping("/products")
    private List<Product> produktliste() {

        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Tasse, rot", "Schöne Keramiktasse", 100, 5.99));
        products.add(new Product(2, "Tasse, gelb", "Nicht so schöne Keramiktasse", 200, 3.99));

        return products;
    }

    // http://localhost:8080/api/v1/customers
    @RequestMapping("/customers")
    private List<Customer> kundenliste() {

        List<Customer> kunden = new ArrayList<>();
        kunden.add(new Customer(1, "Peter", "Parker", LocalDate.of(1998, 10, 5)));
        kunden.add(new Customer(2, "Bruce", "Banner", LocalDate.of(1985, 1, 15)));
        kunden.add(new Customer(3, "Carol", "Danvers", LocalDate.of(1995, 5, 20)));

        // JSON: JavaScript Object Notation - Standardformat für Informationen
        return kunden; // wird automatisch als JSON dargestellt
    }
}
