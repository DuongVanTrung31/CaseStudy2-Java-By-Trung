package _Account;

import _IO_File.IOFile;

import java.io.File;
import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> userList;
    private final IOFile<User> ioFile = new IOFile<>();
    private final String PATHNAME_OF_USER = "FileData/userinfor";

    public UserManager() {
        if (new File(PATHNAME_OF_USER).length() == 0) {
            userList = new ArrayList<>();
        } else {
            userList = ioFile.readFileData(PATHNAME_OF_USER);
        }
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void addUser(User user){
        userList.add(user);
        ioFile.writerFileData(userList,PATHNAME_OF_USER);
    }

    public void displayUser(){
        userList = ioFile.readFileData(PATHNAME_OF_USER);
        if(userList.isEmpty()){
            System.out.println("Chưa có thông tin người dùng nào đăng ký !!!");
            System.out.println("-------------------------------");
        } else {
            System.err.printf("                                Thông tin cá nhân khách hàng \n");
            System.out.printf("╔==============================================================================================╗\n");
            System.err.printf("║ %-15s ║ %-16s ║ %-22s ║ %-30s ║\n","Tên","SĐT","Email","Địa chỉ");
            userList.forEach(System.out::println);
            System.out.println("╚==============================================================================================╝");
        }
    }
}
