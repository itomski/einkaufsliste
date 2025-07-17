package de.gfn.einkaufsliste;

public class Product {

    private long nr;

    private String name;

    private String description;

    private int quantity;

    private double price;

    public Product() {
    }

    public Product(long nr, String name, String description, int quantity, double price) {
        this.nr = nr;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public long getNr() {
        return nr;
    }

    public void setNr(long nr) {
        this.nr = nr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
