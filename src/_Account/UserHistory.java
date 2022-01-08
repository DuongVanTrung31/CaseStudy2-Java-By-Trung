package _Account;


import _Model_Product.Bill;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserHistory {
    private HashMap<String, ArrayList<Bill>> historyList;
    private final String PATH_NAME_HISTORY_BILL = "FileData/userHistoryBill";

    public UserHistory() {
        if(!new File(PATH_NAME_HISTORY_BILL).exists()){
            try {
                new File(PATH_NAME_HISTORY_BILL).createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (new File(PATH_NAME_HISTORY_BILL).length() == 0) {
            this.historyList = new HashMap<>();
        } else {
            this.historyList = readFileData();
        }
    }

    public HashMap<String, ArrayList<Bill>> getHistoryList() {
        if(historyList == null) {
            historyList = new HashMap<>();
        }
        return historyList = readFileData();
    }

    public void add(String userName, ArrayList<Bill> bills) {
        historyList.put(userName, bills);
        writerFileData();
    }

    public void showHistory(String accountName) {
        historyList = getHistoryList();
        for (Bill b : historyList.get(accountName)) {
            System.out.println(b);
        }
    }

    public void showAllHistoryUser() {
        historyList = getHistoryList();
        for (Map.Entry<String, ArrayList<Bill>> entry: historyList.entrySet()) {
            System.out.println(entry);
        }
    }
    public void writerFileData() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(PATH_NAME_HISTORY_BILL)));
            objectOutputStream.writeObject(historyList);
            objectOutputStream.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    public HashMap<String, ArrayList<Bill>> readFileData() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(PATH_NAME_HISTORY_BILL)));
            return (HashMap<String, ArrayList<Bill>>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Lỗi đọc file " + e.getMessage());
        }
        return null;
    }
}
