package _Account;

import java.io.Serializable;

public class AccountUser implements Serializable {
    private String account, password;

    public AccountUser(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public AccountUser() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("║ %-15s ║ %-15s ║",account,password);
    }
}

