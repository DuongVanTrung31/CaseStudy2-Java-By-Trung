package _Account;

import java.io.Serializable;
import java.util.ArrayList;

public class AccountAdmin implements Serializable{
    private String accountName;
    private String password;
    private final ArrayList<AccountAdmin> accountAdminList = new ArrayList<>();

    public AccountAdmin(String accountName, String password) {
        this.accountName = accountName;
        this.password = password;
    }

    public AccountAdmin() {
        accountAdminList.add(new AccountAdmin("ADMIN1", "123456"));
        accountAdminList.add(new AccountAdmin("ADMIN2", "123456"));
        accountAdminList.add(new AccountAdmin("ADMIN3", "123456"));
    }

    public String getAdminAcc() {
        return accountName;
    }

    public String getAdminPass() {
        return password;
    }

    public void setAdmin(String accountName, String password) {
        accountAdminList.add(new AccountAdmin(accountName, password));
    }

    public ArrayList<AccountAdmin> getAdminAccountList() {
        return accountAdminList;
    }

    @Override
    public String toString() {
        return "AdminAccount: " + "adminAcc = '" + accountName + '\'' + ", adminPass = '" + password + '\'';
    }
    
}
