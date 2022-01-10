package _Service_Manager;

import _Model_Product.Laptop;
import _Model_Product.Product;
import _Model_Product.SmartPhone;
import _Model_Product.Tablet;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductFacade {
    private LaptopManager laptopManager;
    private TabletManager tabletManager;
    private SmartPhoneManager smartPhoneManager;
    private ProductManager productManager;
    private static ProductFacade instance;
    private final Scanner scanner = new Scanner(System.in);

    private ProductFacade() {
        productManager = new ProductManager();
        laptopManager = new LaptopManager();
        tabletManager = new TabletManager();
        smartPhoneManager = new SmartPhoneManager();
    }

    public synchronized static ProductFacade getInstance() {
        if (instance == null) {
            instance = new ProductFacade();
        }
        return instance;
    }

    public void add(int id, double price, String brand, String name, int choiceAdd) {
        switch (choiceAdd) {
            case 1:
                Laptop laptop = new Laptop(id, price, name, brand);
                System.out.print("[\uD83D\uDCBB] Có thêm chi tiết cấu hình không ? (Y/N): ");
                if (scanner.nextLine().equalsIgnoreCase("Y")) {
                    System.out.print("[\uD83D\uDCBB] Thêm thông số Ram - SSD: ");
                    String ramSSD = scanner.nextLine();
                    System.out.print("[\uD83D\uDCBB] Thêm mô tả chi tiết VD: M.Hình, CPU, GPU , Pin: ");
                    String description = scanner.nextLine();
                    laptop.setRamSSD(ramSSD);
                    laptop.setDescription(description);
                }
                laptopManager.add(laptop);
                productManager.add(laptop);
                break;
            case 2:
                SmartPhone smartPhone = new SmartPhone(id, price, name, brand);
                smartPhoneManager.add(smartPhone);
                productManager.add(smartPhone);
                break;
            case 3:
                Tablet tablet = new Tablet(id, price, name, brand);
                tabletManager.add(tablet);
                productManager.add(tablet);
                break;
        }
    }

    public void displayChoice(int choice) {
        switch (choice) {
            case 1:
                System.err.printf("║    %-5s ║    %-7s ║      %-9s ║                                    %-70s ║\n", "ID", "Giá", "Hãng", "Tên sản phẩm");
                System.out.println("╔====================================================================================================================================================╗");
                productManager.display();
                System.out.println("╚====================================================================================================================================================╝");
                break;
            case 2:
                System.err.printf("║    %-5s ║    %-7s ║      %-9s ║                                    %-70s ║\n", "ID", "Giá", "Hãng", "Tên sản phẩm");
                laptopManager.display();
                System.out.println("╚====================================================================================================================================================╝");

                break;
            case 3:
                System.err.printf("║    %-5s ║    %-7s ║      %-9s ║                                    %-70s ║\n", "ID", "Giá", "Hãng", "Tên sản phẩm");
                System.out.println("╔====================================================================================================================================================╗");
                smartPhoneManager.display();
                System.out.println("╚====================================================================================================================================================╝");
                break;
            case 4:
                System.err.printf("║    %-5s ║    %-7s ║      %-9s ║                                    %-70s ║\n", "ID", "Giá", "Hãng", "Tên sản phẩm");
                System.out.println("╔====================================================================================================================================================╗");
                tabletManager.display();
                System.out.println("╚====================================================================================================================================================╝");
                break;
            case 0:
                System.out.println("[\uD83D\uDD14] Quay lại");
                break;
            default:
                System.out.println("[❌] Sai lựa chọn");
                break;
        }
    }

    public void delete(int id) {
        productManager.delete(id);
        laptopManager.delete(id);
        smartPhoneManager.delete(id);
        tabletManager.delete(id);
    }

    public void deleteAll() {
        productManager.deleteAll();
        laptopManager.deleteAll();
        smartPhoneManager.deleteAll();
        tabletManager.deleteAll();
    }

    public void searching(int choiceAdd) {
        switch (choiceAdd) {
            case 1:
                System.out.print("[\uD83D\uDD0E] Nhập từ khóa tìm kiếm: ");
                String brand = scanner.nextLine();
                ArrayList<Product> listByBrand = productManager.findProductByKey(brand);
                if (listByBrand.isEmpty()) {
                    System.out.println("[❌] Không có sản phẩm nào có từ khóa trên");
                } else {
                    System.err.printf("║    %-5s ║    %-7s ║      %-9s ║                                    %-70s ║\n", "ID", "Giá", "Hãng", "Tên sản phẩm");
                    System.out.println("╔====================================================================================================================================================╗");
                    listByBrand.forEach(System.out::println);
                    System.out.println("╚====================================================================================================================================================╝");

                }
                break;
            case 2:
                System.out.print("Nhập khoảng giá từ: ");
                double lowPrice = Double.parseDouble(scanner.nextLine());
                System.out.print("Nhập khoảng giá đến: ");
                double highPrice = Double.parseDouble(scanner.nextLine());
                if (lowPrice > highPrice) {
                    System.out.println("[❌] Nhập sai khoảng giá");
                    System.out.println("-----------------------------------------------");
                    return;
                }
                ArrayList<Product> listByPrice = productManager.productSearchByPrice(lowPrice, highPrice);
                if (listByPrice.isEmpty()) {
                    System.out.println("[❌] Không có sản phẩm nào có khoảng giá trên");
                } else {
                    System.err.printf("║    %-5s ║    %-7s ║      %-9s ║                                    %-70s ║\n", "ID", "Giá", "Hãng", "Tên sản phẩm");
                    System.out.println("╔====================================================================================================================================================╗");
                    listByPrice.forEach(System.out::println);
                    System.out.println("╚====================================================================================================================================================╝");
                }
                break;
            case 0:
                System.out.println("[\uD83D\uDD14] Quay lại");
                break;
            default:
                System.out.println("[❌] Sai lựa chọn");
                break;
        }
    }

    public void edit(int id, int choiceAdd) {
        switch (choiceAdd) {
            case 1:
                System.out.print("Nhập tên mới: ");
                String namNew = scanner.nextLine();
                productManager.editName(id, namNew);
                laptopManager.editName(id, namNew);
                smartPhoneManager.editName(id, namNew);
                tabletManager.editName(id, namNew);
                break;
            case 2:
                System.out.print("Nhập giá mới: ");
                double priceNew = Double.parseDouble(scanner.nextLine());
                productManager.editPrice(id, priceNew);
                laptopManager.editPrice(id, priceNew);
                smartPhoneManager.editPrice(id, priceNew);
                tabletManager.editPrice(id, priceNew);
                break;
            case 3:
                System.out.print("Nhập hãng mới: ");
                String brandNew = scanner.nextLine();
                productManager.editBrand(id, brandNew);
                laptopManager.editBrand(id, brandNew);
                smartPhoneManager.editBrand(id, brandNew);
                tabletManager.editBrand(id, brandNew);
                break;
            case 0:
                System.out.println("[\uD83D\uDD14] Quay lại");
            default:
                System.out.println("[❌] Nhập sai lựa chọn");
                break;
        }
    }

    public boolean checkID(int id) {
        for (Product p : productManager.getProductArrayList()) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void backUpData() {
        productManager.setDataCrawls();
        System.err.println("[\uD83D\uDCBE] Khôi phục dữ liệu từ TGDĐ thành công [\uD83D\uDCBE]");
        System.out.println("-----------------------------------------------------------------");
    }

    public Product findProductById(int id){
        Product product = null;
        for (Product p: productManager.getProductArrayList()) {
            if(p.getId() == id) {
                product = p;
                break;
            }
        }
        return product;
    }
}
