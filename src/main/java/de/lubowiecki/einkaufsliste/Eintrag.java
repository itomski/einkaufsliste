package de.lubowiecki.einkaufsliste;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity // Soll in der DB verwaltet werden
@Table(name = "eintraege") // Standard Name = Klassenname. Änderung möglich
public class Eintrag {

    @Id // Primärschlüssel
    @GeneratedValue // Auto-Increment
    private int id;

    // @Column(name = "name", unique = true, length = 50) // Standard Name = Feldname. Änderung möglich
    private String titel;

    // @JsonIgnore // wird im Json nicht angezeigt
    private LocalDateTime erzeugtAm;

    private boolean erledigt;

    public Eintrag() {
    }

    public Eintrag(String titel) {
        this.titel = titel;
        erzeugtAm = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public LocalDateTime getErzeugtAm() {
        return erzeugtAm;
    }

    public void setErzeugtAm(LocalDateTime erzeugtAm) {
        this.erzeugtAm = erzeugtAm;
    }

    public boolean isErledigt() {
        return erledigt;
    }

    public void setErledigt(boolean erledigt) {
        this.erledigt = erledigt;
    }
}
