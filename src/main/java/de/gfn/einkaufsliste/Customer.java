package de.gfn.einkaufsliste;

import java.time.LocalDate;

public class Customer {

    private long nr;

    private String firstname;

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
