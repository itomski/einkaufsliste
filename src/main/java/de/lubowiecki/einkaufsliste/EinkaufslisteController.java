package de.lubowiecki.einkaufsliste;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class EinkaufslisteController {

    @FXML
    private TextField eingabe;

    @FXML
    private ListView<String> ausgabe;

    private List<String> einkaufsliste = new ArrayList<>();

    @FXML
    protected void add(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) { // Nur auf Enter reagieren
            String eintrag = eingabe.getText(); // Text aus dem Textfeld einlesen
            if (!eintrag.isEmpty()) { // Wenn nicht leer
                einkaufsliste.add(eintrag); // der Liste hinzufügen
                eingabe.clear(); // Textfeld leeren

                // Ausgabe aktuallisieren
                ausgabe.setItems(FXCollections.observableArrayList(einkaufsliste));
            }
        }
    }
}