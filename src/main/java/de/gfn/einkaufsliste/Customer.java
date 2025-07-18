package de.gfn.einkaufsliste;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class Customer {

    @Id // Primärschlüssel
    @GeneratedValue // Auto-Increment
    private long nr;

    @Column(length = 50)
    private String firstname;

    @Column(length = 50)
    private String lastname;

    private LocalDate birthDate;

    public Customer() {
    }

    public Customer(long nr, String firstname, String lastname, LocalDate birthDate) {
        this.nr = nr;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
    }

    public long getNr() {
        return nr;
    }

    public void setNr(long nr) {
        this.nr = nr;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
