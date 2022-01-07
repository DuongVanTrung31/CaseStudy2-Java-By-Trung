package _Account;

import java.io.Serializable;

public class User implements Serializable {
    private String nameUser;
    private String phonenumberUser;
    private String addressUser;
    private String emailUser;

    public User(String nameUser, String phonenumberUser, String addressUser, String emailUser) {
        this.nameUser = nameUser;
        this.phonenumberUser = phonenumberUser;
        this.addressUser = addressUser;
        this.emailUser = emailUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String  getPhonenumberUser() {
        return phonenumberUser;
    }

    public void setPhonenumberUser(String phonenumberUser) {
        this.phonenumberUser = phonenumberUser;
    }

    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }

    @Override
    public String toString() {
        return String.format("║ %-15s ║ %-16s ║ %-22s ║ %-30s ║", nameUser, phonenumberUser, emailUser, addressUser);
    }
}
