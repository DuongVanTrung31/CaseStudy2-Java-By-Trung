package _Model_Product;

import java.io.Serializable;

public abstract class Product implements Serializable {
    protected int id;
    protected double price;
    protected String name, brand;


    public Product(int id, double price, String name, String brand) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return String.format("║ %-8s ║ %-10.0f ║ %-14s ║ %-105s ║", id, price, brand, name);
    }
}
