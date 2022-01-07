package _Service_Manager;

import _IO_File.IOFileBinary;
import _Model_Product.Product;
import _Model_Product.SmartPhone;

import java.io.File;
import java.util.ArrayList;

public class SmartPhoneManager implements IManager<SmartPhone>{
    private ArrayList<SmartPhone> listSmartPhone;
    private IOFileBinary<SmartPhone> phoneIOFileBinary = new IOFileBinary<>();
    private final String PATH_OF_SMARTPHONE = "FileData/smartphone";

    public SmartPhoneManager() {
        if(new File(PATH_OF_SMARTPHONE).length() == 0) {
            listSmartPhone = new ArrayList<>();
        } else {
            listSmartPhone = phoneIOFileBinary.readFileData(PATH_OF_SMARTPHONE);
        }
    }

    public ArrayList<SmartPhone> getListSmartPhone() {
        return listSmartPhone;
    }

    @Override
    public void display() {
        listSmartPhone = phoneIOFileBinary.readFileData(PATH_OF_SMARTPHONE);
        if(listSmartPhone.isEmpty()) {
            System.err.println("\t\tChưa có sản phẩm nào");
        } else {
            listSmartPhone.forEach(System.out::println);
        }
    }

    @Override
    public void delete(int id) {
        listSmartPhone.removeIf(p -> p.getId() == id);
        phoneIOFileBinary.writerFileData(listSmartPhone,PATH_OF_SMARTPHONE);
    }

    @Override
    public void deleteAll() {
        listSmartPhone.clear();
        phoneIOFileBinary.writerFileData(listSmartPhone,PATH_OF_SMARTPHONE);
    }

    @Override
    public void add(SmartPhone smartPhone) {
        listSmartPhone.add(smartPhone);
        phoneIOFileBinary.writerFileData(listSmartPhone,PATH_OF_SMARTPHONE);
    }

    public void editName(int id, String editName) {
        for (Product p: listSmartPhone) {
            if(p.getId() == id) {
                p.setName(editName);
            }
        }
        phoneIOFileBinary.writerFileData(listSmartPhone,PATH_OF_SMARTPHONE);
    }

    @Override
    public void editPrice(int id, double price) {
        for (Product p: listSmartPhone) {
            if(p.getId() == id) {
                p.setPrice(price);
            }
        }
        phoneIOFileBinary.writerFileData(listSmartPhone,PATH_OF_SMARTPHONE);
    }

    @Override
    public void editBrand(int id, String brand) {
        for (Product p: listSmartPhone) {
            if(p.getId() == id) {
                p.setBrand(brand);
            }
        }
        phoneIOFileBinary.writerFileData(listSmartPhone,PATH_OF_SMARTPHONE);
    }
}
