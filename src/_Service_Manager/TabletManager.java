package _Service_Manager;

import _IO_File.IOFileBinary;
import _Model_Product.Product;
import _Model_Product.Tablet;

import java.io.File;
import java.util.ArrayList;

public class TabletManager implements IManager<Tablet> {
    private ArrayList<Tablet> listTablet;
    private IOFileBinary<Tablet> ioTable = new IOFileBinary<>();
    private final String PATH_OF_TABLET = "FileData/tablet";

    public TabletManager() {
        if(new File(PATH_OF_TABLET).length() == 0) {
            listTablet = new ArrayList<>();
        } else {
            listTablet = ioTable.readFileData(PATH_OF_TABLET);
        }
    }

    public ArrayList<Tablet> getListTablet() {
        return listTablet;
    }

    @Override
    public void display() {
        listTablet = ioTable.readFileData(PATH_OF_TABLET);
        if(listTablet.isEmpty()){
            System.err.println("\t\tChưa có sản phẩm nào");
        } else {
            listTablet.forEach(System.out::println);
        }
    }

    @Override
    public void delete(int id) {
        listTablet.removeIf(p -> p.getId() == id);
        ioTable.writerFileData(listTablet,PATH_OF_TABLET);
    }

    @Override
    public void deleteAll() {
        listTablet.clear();
        ioTable.writerFileData(listTablet,PATH_OF_TABLET);
    }

    @Override
    public void add(Tablet tablet) {
        listTablet.add(tablet);
        ioTable.writerFileData(listTablet,PATH_OF_TABLET);
    }

    public void editName(int id, String editName) {
        for (Product p: listTablet) {
            if(p.getId() == id) {
                p.setName(editName);
            }
        }
        ioTable.writerFileData(listTablet,PATH_OF_TABLET);
    }

    @Override
    public void editPrice(int id, double price) {
        for (Product p: listTablet) {
            if(p.getId() == id) {
                p.setPrice(price);
            }
        }
        ioTable.writerFileData(listTablet,PATH_OF_TABLET);
    }

    @Override
    public void editBrand(int id, String brand) {
        for (Product p: listTablet) {
            if(p.getId() == id) {
                p.setBrand(brand);
            }
        }
        ioTable.writerFileData(listTablet,PATH_OF_TABLET);
    }
}
