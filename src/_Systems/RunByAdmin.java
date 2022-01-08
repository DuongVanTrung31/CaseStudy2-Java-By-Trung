package _Systems;

import _Account.AccountUserManager;
import _Account.UserHistory;
import _Account.UserManager;
import _Login.Login;
import _Service_Manager.ProductFacade;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RunByAdmin {
    private final Scanner scanner = new Scanner(System.in);
    private final ProductFacade productFacade = ProductFacade.getInstance();
    private final UserManager userInfo = new UserManager();
    private final AccountUserManager userAccounts = new AccountUserManager();
    private final UserHistory userHistory = new UserHistory();
    public RunByAdmin() {
    }

    public void menuProductOfAdmin() {
        try {
            do {
                System.out.println("╔============================================================╗");
                System.out.println("║              ▂ ▃ ▅ ▆ █ HỆ THỐNG ADMIN █ ▆ ▅ ▃ ▂            ║");
                System.out.println("╠============================================================╣");
                System.out.println("║>[1]. Thêm sản phẩm                                         ║");
                System.out.println("║>[2]. Sửa thông tin                                         ║");
                System.out.println("║>[3]. Xóa sản phẩm                                          ║");
                System.out.println("║>[4]. Hiển thị sản phẩm                                     ║");
                System.out.println("║>[5]. Thông tin khách hàng                                  ║");
                System.out.println("║>[6]. Khôi phục dữ liệu                                     ║");
                System.out.println("║>[0]. Đăng xuất                                             ║");
                System.out.println("╚============================================================╝");
                System.out.print("[\uD83D\uDC4B] Mời bạn nhập lựa chọn: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        menuAddProduct();
                        break;
                    case 2:
                        try{
                            System.out.print("[\uD83D\uDD0E] Nhập mã ID sản phẩm muốn sửa: ");
                            int id = Integer.parseInt(scanner.nextLine());
                            if (productFacade.checkID(id)) {
                                editProduct(id);
                                System.out.println("[\uD83D\uDC4C] Đã cập nhật thông tin sản phẩm");
                            } else {
                                System.out.println("[❌] Không có mã ID trên");
                                System.out.println("---------------------------------------------------");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("[❌] Sai kiểu dữ liệu");
                            System.out.println("---------------------------------------------------");
                        }
                        break;
                    case 3:
                        deleteProduct();
                        break;
                    case 4:
                        display();
                        break;
                    case 5:
                        managerUser();
                        break;
                    case 6:
                        System.out.println("[\uD83D\uDEA7] Vui lòng đợi trong giây lát (Don't touch anything) [\uD83D\uDEA7]");
                        productFacade.backUpData();
                        break;
                    case 0:
                        System.out.println("[\uD83D\uDD10] Đã thoát khỏi hệ thống ADMIN !!!");
                        System.out.println("-----------------------------------------------------");
                        new Login().loginSystem();
                        break;
                    default:
                        System.out.println("[❌] Không có lựa chọn trên");
                        break;
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("[❌] Bạn nhập sai dữ liệu, mời nhập lại !!!");
            System.out.println("--------------------------------------------------------");
            menuProductOfAdmin();
        }
    }

    public void menuAddProduct() {
        try {
            do {
                System.out.println("╔===========================================╗");
                System.out.println("║     ▂ ▃ ▅ ▆ █ THÊM SẢN PHẨM  █ ▆ ▅ ▃ ▂    ║");
                System.out.println("╠===========================================╣");
                System.out.println("║>[1]. Laptop                               ║");
                System.out.println("║>[2]. Smart phone                          ║");
                System.out.println("║>[3]. Tablet                               ║");
                System.out.println("║>[0]. Thoát                                ║");
                System.out.println("╚===========================================╝");
                System.out.print("[\uD83D\uDC4B] Mời bạn nhập vào lựa chọn: ");
                int choiceAdd = Integer.parseInt(scanner.nextLine());
                if (choiceAdd == 0 ){
                    break;
                }else if(choiceAdd < 0 || choiceAdd > 3){
                    System.out.println("[❌] Sai lựa chọn! Thử lại");
                    menuAddProduct();
                }
                System.out.print("Nhập mã ID sản phẩm: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Nhập giá sản phẩm: ");
                double price = Double.parseDouble(scanner.nextLine());
                System.out.print("Nhập tên sản phẩm: ");
                String name = scanner.nextLine();
                System.out.print("Nhập hãng sản phẩm: ");
                String brand = scanner.nextLine();
                if (!productFacade.checkID(id)) {
                    productFacade.add(id, price, name, brand, choiceAdd);
                    System.out.println("[\uD83D\uDC4C] Thêm sản phẩm thành công");
                } else {
                    System.out.println("[❌] Sản phẩm đã trùng mã ID");
                    System.out.println("------------------------------------------");
                }
                break;
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println("[❌] Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("----------------------------------------------------");
            menuAddProduct();
        }
    }

    public void editProduct(int id) {
        try {
            System.out.println("╔===========================================╗");
            System.out.println("║     ▂ ▃ ▅ ▆ █ SỬA SẢN PHẨM  █ ▆ ▅ ▃ ▂     ║");
            System.out.println("╠===========================================╣");
            System.out.println("║>[1]. Sửa tên                              ║");
            System.out.println("║>[2]. Sửa giá                              ║");
            System.out.println("║>[3]. Sửa hãng                             ║");
            System.out.println("║>[0]. Thoát                                ║");
            System.out.println("╚===========================================╝");
            System.out.print("[\uD83D\uDC4B] Mời bạn nhập vào lựa chọn: ");
            int choiceAdd = Integer.parseInt(scanner.nextLine());
            productFacade.edit(id, choiceAdd);
        } catch (InputMismatchException e) {
            System.out.println("[❌] Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("---------------------------------------------------------");
            editProduct(id);
        }
    }

    public void deleteProduct() {
        try {
            System.out.println("╔===========================================╗");
            System.out.println("║     ▂ ▃ ▅ ▆ █ XÓA SẢN PHẨM  █ ▆ ▅ ▃ ▂     ║");
            System.out.println("╠===========================================╣");
            System.out.println("║>[1]. Xóa sản phẩm theo ID                 ║");
            System.out.println("║>[2]. Xóa tất cả sản phẩm                  ║");
            System.out.println("║>[0]. Thoát                                ║");
            System.out.println("╚===========================================╝");
            System.out.print("[\uD83D\uDC4B] Mời bạn nhập vào lựa chọn: ");
            int choiceAdd = Integer.parseInt(scanner.nextLine());
            switch (choiceAdd) {
                case 1:
                    System.out.print("[\uD83D\uDD0E] Nhập mã ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    if (productFacade.checkID(id)) {
                        productFacade.delete(id);
                        System.out.println("[\uD83D\uDC4C] Xóa thành công");
                        System.out.println("--------------------------------------");
                    } else {
                        System.out.println("[❌] Không có mã ID trên");
                        System.out.println("---------------------------------------");
                    }
                    break;
                case 2:
                    System.err.print("⛔ \uD83D\uDEA7 Bạn chắn chắc muốn xóa hết dữ liệu (Y/N)❓ \uD83D\uDEA7 ⛔: ");
                    String choice = scanner.nextLine();
                    if (choice.equalsIgnoreCase("Y")) {
                        productFacade.deleteAll();
                        System.out.println("[\uD83D\uDCBE] Đã xóa hết dữ liệu");
                        System.out.println("-----------------------------------------------------");
                    } else {
                        break;
                    }
                case 0:
                    System.out.println("[\uD83D\uDD14] Thoát");
                    break;
                default:
                    System.out.println("[❌] Sai lựa chọn");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("[❌] Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("-----------------------------------------------------");
            deleteProduct();
        }
    }

    public void display() {
        try {
            System.out.println("╔===========================================╗");
            System.out.println("║  ▂ ▃ ▅ ▆ █ HIỂN THỊ SẢN PHẨM  █ ▆ ▅ ▃ ▂   ║");
            System.out.println("╠===========================================╣");
            System.out.println("║>[1]. Tất cả                               ║");
            System.out.println("║>[2]. Laptop                               ║");
            System.out.println("║>[3]. Smart phone                          ║");
            System.out.println("║>[4]. Tablet                               ║");
            System.out.println("║>[0]. Thoát                                ║");
            System.out.println("╚===========================================╝");
            System.out.print("[\uD83D\uDC4B] Mời bạn nhập vào lựa chọn: ");
            int choiceAdd = Integer.parseInt(scanner.nextLine());
            productFacade.displayChoice(choiceAdd);
        } catch (InputMismatchException e) {
            System.out.println("[❌] Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("----------------------------------------------------");
            display();
        }
    }

    public void managerUser() {
        try {
            System.out.println("╔==================================================╗");
            System.out.println("║    ▂ ▃ ▅ ▆ █ THÔNG TIN KHÁCH HÀNG █ ▆ ▅ ▃ ▂      ║");
            System.out.println("╠==================================================╣");
            System.out.println("║>[1]. Tài khoản người dùng                        ║");
            System.out.println("║>[2]. Thông tin cá nhân người dùng                ║");
            System.out.println("║>[3]. Lịch sử giao dịch khách hàng                ║");
            System.out.println("║>[4]. Xóa tài khoản khách hàng                    ║");
            System.out.println("║>[0]. Quay lại                                    ║");
            System.out.println("╚==================================================╝");
            System.out.print("[\uD83D\uDC4B] Mời bạn nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    userAccounts.displayUserAccount();
                    break;
                case 2:
                    userInfo.displayUser();
                    break;
                case 3:
                    userHistory.showAllHistoryUser();
                    break;
                case 4:
                    System.out.print("[\uD83D\uDD0E] Nhập tên tài khoản muốn xóa: ");
                    String accountName = scanner.nextLine();
                    userAccounts.deleteAccount(accountName);
                    break;
                case 0:
                    System.out.println("[\uD83D\uDD14] Thoát");
                    break;
                default:
                    System.out.println("[❌] Sai lựa chon");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("[❌] Bạn đã nhập sai dữ liệu! Vui lòng nhập lại!");
            System.out.println("-----------------------------------------------------");
            managerUser();
        }
    }
}
