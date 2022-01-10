package _Model_Product;


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

    public void display(){
        System.out.println("╔====================================================================================================================================================╗");
        System.out.println("\t Username:" + userName);
        System.out.printf("║    %-5s ║    %-7s ║      %-9s ║                                    %-70s ║\n", "ID","Giá","Hãng","Tên sản phẩm");
        product.forEach(System.out::println);
        System.out.println("  Total Price " + totalPrice + '\t' + "  Purchase Date: " + purchaseDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        System.out.println("╚====================================================================================================================================================╝");
    }

    @Override
    public String toString() {
        return "Bill{" +
                "userName='" + userName + '\'' +
                ", product=" + product +
                ", totalPrice=" + totalPrice +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
