package _Model_Product;

import java.io.Serializable;

public class Tablet extends Product implements Serializable {

    public Tablet(int id, double price, String name, String brand) {
        super(id, price, name, brand);
    }

    @Override
    public String toString() {
        return String.format("║ %-8s ║ %-10.0f ║ %-14s ║ %-105s ║", id, price, brand, name);
    }
}
