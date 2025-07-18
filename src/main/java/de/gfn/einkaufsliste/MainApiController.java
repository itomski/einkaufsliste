package de.gfn.einkaufsliste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/v1")
@RestController // Liefert JSON aus
public class MainApiController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

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
        return productRepository.findAll();
    }

    // http://localhost:8080/api/v1/customers
    @RequestMapping("/customers")
    private List<Customer> kundenliste() {
        return customerRepository.findAll();
    }
}
