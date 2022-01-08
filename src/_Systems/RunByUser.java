package _Systems;

import _Account.UserHistory;
import _Login.Login;
import _Model_Product.Bill;
import _Model_Product.Product;
import _Service_Manager.ProductFacade;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RunByUser {
    private final Scanner scanner = new Scanner(System.in);
    private final ProductFacade productFacade = ProductFacade.getInstance();
    private final RunByAdmin admin = new RunByAdmin();
    private ArrayList<Product> cartUser = new ArrayList<>();
    private final UserHistory userHistory = new UserHistory();

    public RunByUser() {
    }

    public void menuProductOfUser() {
        try {
            do {
                System.out.println("╔============================================================╗");
                System.out.println("║              ▂ ▃ ▅ ▆ █ HỆ THỐNG USER █ ▆ ▅ ▃ ▂             ║");
                System.out.println("╠============================================================╣");
                System.out.println("║>[1]. Hiển thị sản phẩm trong shop                          ║");
                System.out.println("║>[2]. Tìm kiếm sản phẩm trong shop                          ║");
                System.out.println("║>[3]. Thêm sản phẩm vào giỏ hàng                            ║");
                System.out.println("║>[4]. Xóa sản phẩm khỏi giỏ hàng                            ║");
                System.out.println("║>[5]. Hiển thị sản phẩm trong giỏ hàng                      ║");
                System.out.println("║>[6]. Thanh toán                                            ║");
                System.out.println("║>[7]. Lịch sử mua hàng                                      ║");
                System.out.println("║>[0]. Đăng xuất                                             ║");
                System.out.println("╚============================================================╝");
                System.out.print("[\uD83D\uDC4B] Mời bạn nhập lựa chọn: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        admin.display();
                        break;
                    case 2:
                        search();
                        break;
                    case 3:
                        addProductToCart();
                        break;
                    case 4:
                        removeProductFromCart();
                        break;
                    case 5:
                        displayCart();
                        break;
                    case 6:
                        payment();
                        break;
                    case 7:
                        showHistoryBill();
                        break;
                    case 0:
                        System.out.println("[\uD83D\uDD10] Đã thoát khỏi hệ thống USER !!!");
                        System.out.println("----------------------------------------------------");
                        new Login().loginSystem();
                        break;
                    default:
                        System.out.println("[❌] Nhập sai lựa chọn, thử lại");
                        break;
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("[❌] Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("---------------------------------------------------");
            menuProductOfUser();
        }
    }

    public void search() {
        try {
            System.out.println("╔============================================╗");
            System.out.println("║   ▂ ▃ ▅ ▆ █ TÌM KIẾM SẢN PHẨM  █ ▆ ▅ ▃ ▂   ║");
            System.out.println("╠============================================╣");
            System.out.println("║>[1]. Theo từ khóa                          ║");
            System.out.println("║>[2]. Theo khoảng giá                       ║");
            System.out.println("║>[0]. Thoát                                 ║");
            System.out.println("╚============================================╝");
            System.out.print("[\uD83D\uDD0E] Mời bạn nhập vào lựa chọn: ");
            int choiceAdd = Integer.parseInt(scanner.nextLine());
            productFacade.searching(choiceAdd);
        } catch (InputMismatchException e) {
            System.out.println("[❌] Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("----------------------------------------------------");
            search();
        }
    }

    public void addProductToCart() {
        try {
            System.out.print("[\uD83D\uDD0E] Nhập mã sản phẩm bỏ vào giỏ: ");
            int id = Integer.parseInt(scanner.nextLine());
            Product product = productFacade.findProductById(id);
            if (product == null) {
                System.out.println("[❌] Không đúng mã ID sản phẩm");
            } else {
                cartUser.add(product);
                System.out.println("[\uD83D\uDC4C] Đã thêm sản phẩm vào giỏ hàng");
            }
        } catch (InputMismatchException e) {
            System.out.println("[❌] Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("---------------------------------------------------");
            addProductToCart();
        }
    }

    public void removeProductFromCart() {
        try {
            if (cartUser.isEmpty()) {
                System.out.println("[❌] Giỏ hàng trống rỗng");
            } else {
                System.out.print("[\uD83D\uDD0E] Nhập mã sản phẩm muốn xóa khỏi giỏ hàng: ");
                int idRemove = Integer.parseInt(scanner.nextLine());
                boolean check = cartUser.removeIf(p -> p.getId() == idRemove);
                if (!check) {
                    System.out.println("[❌] Không có sản phẩm có mã ID trên trong giỏ hàng");
                } else {
                    System.out.println("[\uD83D\uDC4C] Đã xóa sản phẩm thành công khỏi giỏ hàng");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("[❌] Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("-----------------------------------------------------");
            addProductToCart();
        }
    }

    public void displayCart() {
        if (cartUser.isEmpty()) {
            System.out.println("[❌] Chưa có sản phẩm nào trong giỏ hàng");
        } else {
            System.err.printf("║    %-5s ║    %-7s ║      %-9s ║                                    %-70s ║\n", "ID", "Giá", "Hãng", "Tên sản phẩm");
            System.out.println("╔====================================================================================================================================================╗");
            cartUser.forEach(System.out::println);
            System.out.println("╚====================================================================================================================================================╝");
        }
    }

    public void payment() {
        if(!cartUser.isEmpty()) {
            System.out.printf("%-20s%-10.0fVND\n","[\uD83D\uDCB0] Tổng giá tiền các sản phẩm trong giỏ hàng là: ",getTotalPrice());
            System.out.print("[\uD83C\uDF81] Xác nhân thanh toán (Y/N): ");
            String result = scanner.nextLine();
            if (result.equalsIgnoreCase("Y")) {
                ArrayList<Bill> bills = userHistory.getHistoryList().get(Login.nameAccountUser);
                bills.add(new Bill(Login.nameAccountUser,cartUser, getTotalPrice(),LocalDateTime.now()));
                userHistory.add(Login.nameAccountUser,bills);
                for (Product p : cartUser) {
                    productFacade.delete(p.getId());
                }
                cartUser.clear();
                System.out.println("[\uD83D\uDC4C] Thanh toán hoàn tất! Xin trân trọng cảm ơn quý khách đã mua sản phẩm!!\uD83C\uDF81 \uD83D\uDC97 \uD83D\uDC97");
            } else {
                System.out.println("[❌] Bạn cần thanh toán hóa đơn để có sản phẩm");
            }
        }
        else {
            System.out.println("[❌] Chưa có sản phẩm nào trong giỏ hàng ");
        }
    }

    public void showHistoryBill() {
        if(!userHistory.getHistoryList().get(Login.nameAccountUser).isEmpty()) {
            System.out.println("[\uD83D\uDCDD] Lịch sử mua hàng ");
            userHistory.showHistory(Login.nameAccountUser);
        } else {
            System.out.println("Bạn chưa mua hàng lần nào ở đây");
        }
    }
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : cartUser) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

}
