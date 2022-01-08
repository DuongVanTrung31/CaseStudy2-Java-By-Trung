package _Model_Product;

import _Account.AccountUser;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Bill implements Serializable {
    private String userName;
    private ArrayList<Product> product;
    private double totalPrice;
    private LocalDateTime purchaseDate;


    public Bill(String userName, ArrayList<Product> product,double totalPrice, LocalDateTime purchaseDate) {
        this.userName = userName;
        this.product = product;
        this.totalPrice = totalPrice;
        this.purchaseDate = purchaseDate;
    }

    public ArrayList<Product> getProduct() {
        return product;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "userName='" + userName + '\n' +
                ", product=" + product + '\n' +
                ", totalPrice=" + totalPrice + '\t' +
                ", purchaseDate=" + purchaseDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +
                '}';
    }
}
