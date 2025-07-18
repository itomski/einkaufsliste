package de.gfn.einkaufsliste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller // Liefert HTML aus
public class MainController {

    @Autowired // Spring hinterlegt automatisch ein passendes Objekt in diese Variable
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

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
        List<Product> products = productRepository.findAll(); // Produkt-Objekte werden aus der DB abgefragt
        ui.addAttribute("products", products); // Gibt die Liste an das HTML
        return "standard";
    }

    @RequestMapping("/products/new")
    public String produktForm(Model ui) {
        ui.addAttribute("form", "product");
        return "form";
    }

    @PostMapping("/products/save")
    public String produktSpeichern(Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }

    @RequestMapping("/customers")
    public String kunden(Model ui) {
        ui.addAttribute("headline", "Kunden");
        List<Customer> customers = customerRepository.findAll(); // Customer-Objekte werden aus der DB abgefragt
        ui.addAttribute("customers", customers); // Gibt die Liste an das HTML
        return "standard";
    }

    @RequestMapping("/customers/new")
    public String kundenForm(Model ui) {
        ui.addAttribute("form", "customer");
        return "form";
    }

    @PostMapping("/customers/save")
    public String kundenSpeichern(Customer customer) {
        customerRepository.save(customer);
        return "redirect:/customers";
    }
}
