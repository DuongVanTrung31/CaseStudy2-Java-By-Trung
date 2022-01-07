package _Model_Product;

import java.io.Serializable;

public class Laptop extends Product implements Serializable {
    private String ramSSD;
    private String description;

    public Laptop(int id, double price, String name, String brand) {
        super(id, price, name, brand);
        this.ramSSD = getRamSSD();
        this.description = getDescription();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRamSSD() {
        return ramSSD;
    }

    public void setRamSSD(String ramSSD) {
        this.ramSSD = ramSSD;
    }

    @Override
    public String toString() {
        return String.format("║ %-8s ║ %-10.0f ║ %-14s ║ %-105s ║",id,price,brand,name);
    }
    public void display() {
        System.out.println("╔====================================================================================================================================================╗");
        System.out.printf("║ %-8s ║ %-10.0f ║ %-14s ║ %-105s ║\n║        %-31s ║ Chi tiết: %-95s ║\n",id,price,brand,name,ramSSD,description);
        System.out.println("╚====================================================================================================================================================╝");
    }
}
