package _Account;

import _IO_File.IOFile;

import java.io.File;
import java.util.ArrayList;


public class AccountUserManager {
    private ArrayList<AccountUser> accountUsers;
    private final IOFile<AccountUser> ioFile = new IOFile<>();
    private final String PATHNAME_OF_USER_ACCOUNT = "FileData/userAccount";

    public AccountUserManager() {
        if (new File(PATHNAME_OF_USER_ACCOUNT).length() == 0) {
            this.accountUsers = new ArrayList<>();
        } else {
            this.accountUsers = ioFile.readFileData(PATHNAME_OF_USER_ACCOUNT);
        }
    }

    public ArrayList<AccountUser> getUserAccounts() {
        return accountUsers;
    }

    public void addAccount(AccountUser accountUser){
        accountUsers.add(accountUser);
        ioFile.writerFileData(accountUsers,PATHNAME_OF_USER_ACCOUNT);
    }

    public void deleteAccount(String userAccount) {
        boolean check = accountUsers.removeIf(a -> a.getAccount().equalsIgnoreCase(userAccount));
        if(check) {
            System.out.println("[\uD83D\uDC4C] Xóa tài khoản " + userAccount + " thành công ");
            System.out.println("--------------------");
        } else {
            System.out.println("[❌] Không tìm thấy tài khoản trên");
            System.out.println("--------------------");
        }
        ioFile.writerFileData(accountUsers,PATHNAME_OF_USER_ACCOUNT);
    }

    public void displayUserAccount(){
        if(accountUsers.isEmpty()){
            System.out.println("[❌] Chưa có tài khoản nào đăng ký !!!");
            System.out.println("-------------------------------");
        } else {
            System.err.printf("         Tài khoản khách hàng\n");
            System.err.printf("║ %-15s ║ %-15s ║\n","Account","Password");
            accountUsers.forEach(System.out::println);
            System.out.println("╚===================================╝");
        }
    }
}
