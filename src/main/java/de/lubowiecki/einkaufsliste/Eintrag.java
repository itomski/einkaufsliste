package de.lubowiecki.einkaufsliste;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "eintraege") // Name der Tabelle
public class Eintrag {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    // @JsonIgnore // Attribut wird bei der Ausgabe als Json ignoriert
    private boolean erledigt;

    public Eintrag() {
    }

    public Eintrag(String name) {
        this.name = name;
    }

    public Eintrag(String name, boolean erledigt) {
        this.name = name;
        this.erledigt = erledigt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isErledigt() {
        return erledigt;
    }

    public void setErledigt(boolean erledigt) {
        this.erledigt = erledigt;
    }

    public void toggleErledigt() {
        this.erledigt = !erledigt;
    }
}
