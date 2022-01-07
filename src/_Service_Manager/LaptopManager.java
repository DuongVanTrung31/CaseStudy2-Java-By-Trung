package _Service_Manager;

import _IO_File.IOFile;
import _Model_Product.Laptop;
import _Model_Product.Product;

import java.io.File;
import java.util.ArrayList;

public class LaptopManager implements IManager<Laptop>{
    private ArrayList<Laptop> listLaptop;
    private IOFile<Laptop> ioFileLaptop = new IOFile<>();
    private final String PATHNAME_OF_LAPTOP = "FileData/laptop";
    public LaptopManager() {
        if(new File(PATHNAME_OF_LAPTOP).length() ==0){
            listLaptop = new ArrayList<>();
        } else {
            listLaptop = ioFileLaptop.readFileData(PATHNAME_OF_LAPTOP);
        }
    }
    public ArrayList<Laptop> getListLaptop() {
        return listLaptop;
    }

    @Override
    public void display() {
        listLaptop = ioFileLaptop.readFileData(PATHNAME_OF_LAPTOP);
        if(listLaptop.isEmpty()){
            System.err.println("\t\tChưa có sản phẩm nào");
        } else {
            listLaptop.forEach(Laptop::display);
        }
    }

    @Override
    public void delete(int id) {
        listLaptop.removeIf(p -> p.getId() == id);
        ioFileLaptop.writerFileData(listLaptop,PATHNAME_OF_LAPTOP);
    }

    @Override
    public void deleteAll() {
        listLaptop.clear();
        ioFileLaptop.writerFileData(listLaptop,PATHNAME_OF_LAPTOP);
    }

    @Override
    public void add(Laptop laptop) {
        listLaptop.add(laptop);
        ioFileLaptop.writerFileData(listLaptop,PATHNAME_OF_LAPTOP);
    }

    public void editName(int id, String editName) {
        for (Product p: listLaptop) {
            if(p.getId() == id) {
                p.setName(editName);
            }
        }
        ioFileLaptop.writerFileData(listLaptop,PATHNAME_OF_LAPTOP);
    }

    @Override
    public void editPrice(int id, double price) {
        for (Product p: listLaptop) {
            if(p.getId() == id) {
                p.setPrice(price);
            }
        }
        ioFileLaptop.writerFileData(listLaptop,PATHNAME_OF_LAPTOP);
    }

    @Override
    public void editBrand(int id, String brand) {
        for (Product p: listLaptop) {
            if(p.getId() == id) {
                p.setBrand(brand);
            }
        }
        ioFileLaptop.writerFileData(listLaptop,PATHNAME_OF_LAPTOP);
    }
}