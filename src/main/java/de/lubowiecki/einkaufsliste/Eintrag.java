package de.lubowiecki.einkaufsliste;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Eintrag {

    private static int count;

    private int id;

    private String name;

    // @JsonIgnore // Attribut wird bei der Ausgabe als Json ignoriert
    private boolean erledigt;

    public Eintrag() {
        id = ++count;
    }

    public Eintrag(String name) {
        this(); // Ruft als erstest den parameterlosen Konstruktor auf, der die ID vergibt
        this.name = name;
    }

    public Eintrag(String name, boolean erledigt) {
        this(); // Ruft als erstest den parameterlosen Konstruktor auf, der die ID vergibt
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

    public void toggleErledigt() {
        this.erledigt = !erledigt;
    }
}
