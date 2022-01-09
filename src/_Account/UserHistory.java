package _Account;


import _Model_Product.Bill;

import java.io.*;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserHistory {
    private HashMap<String, ArrayList<Bill>> historyList;
    private final String PATH_NAME_HISTORY_BILL = "FileData/userHistoryBill";

    public UserHistory() {
        if (!new File(PATH_NAME_HISTORY_BILL).exists()) {
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
        if (historyList == null) {
            historyList = new HashMap<>();
        } else {
            historyList = readFileData();
        }
        return historyList;
    }

    public void add(String userName, ArrayList<Bill> bills) {
        historyList.put(userName, bills);
        writerFileData();
    }

    public void showHistory(String accountName) {
        historyList = getHistoryList();
        for (Bill b : historyList.get(accountName)) {
            b.display();
        }
    }

    public double getTotalPriceByUser(String accountName) {
        historyList = getHistoryList();
        double totalPriceUser = 0;
        for (Bill b : historyList.get(accountName)) {
            totalPriceUser += b.getTotalPrice();
        }
        return totalPriceUser;
    }

    public void showAllHistoryUser() {
        historyList = getHistoryList();
        for (Map.Entry<String, ArrayList<Bill>> entry : historyList.entrySet()) {
            System.out.println("Khách hàng: " + entry.getKey());
            entry.getValue().forEach(Bill::display);
        }
    }

    public double getTotalPriceAllUser() {
        historyList = getHistoryList();
        double totalPriceAll = 0;
        for (ArrayList<Bill> bList : historyList.values()) {
            for (Bill b : bList) {
                totalPriceAll += b.getTotalPrice();
            }
        }
        return totalPriceAll;
    }

    public double getTotalPriceByMonth(int month) {
        historyList = getHistoryList();
        double totalPriceForMonth = 0;
        for (ArrayList<Bill> bList : historyList.values()) {
            for (Bill b : bList) {
                if (b.getPurchaseDate().getMonthValue()== month) {
                    totalPriceForMonth += b.getTotalPrice();
                }
            }
        }
        return totalPriceForMonth;
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
