package _Crawls_Data._List_Data_TGDĐ;

import _IO_File.IOFile;
import _Model_Product.Laptop;
import _Model_Product.SmartPhone;
import _Model_Product.Tablet;

import java.util.ArrayList;

public class ListProduct {
    private final IOFile<Laptop> ioLaptop;
    private final IOFile<SmartPhone> ioSmartphone;
    private final IOFile<Tablet> ioTablet;
    private CreateListDataProduct createListDataProduct;
    private final String PATHNAME_OF_LAPTOP = "FileData/laptop";
    private final String PATHNAME_OF_SMARTPHONE = "FileData/smartphone";
    private final String PATHNAME_OF_TABLET = "FileData/tablet";

    public ListProduct() {
        ioLaptop = new IOFile<>();
        ioSmartphone = new IOFile<>();
        ioTablet = new IOFile<>();
        createListDataProduct = new CreateListDataProduct();
        setListLaptop();
        setListSmartphone();
        setListTablet();
    }

    public void setListLaptop() {
        ArrayList<Laptop> listLaptop = createListDataProduct.createListLaptop();
        ioLaptop.writerFileData(listLaptop,PATHNAME_OF_LAPTOP);
    }

    public void setListSmartphone() {
        ArrayList<SmartPhone> listSmartphone = createListDataProduct.createListPhone();
        ioSmartphone.writerFileData(listSmartphone,PATHNAME_OF_SMARTPHONE);
    }
    public void setListTablet() {
        ArrayList<Tablet> listTablet = createListDataProduct.createListTablet();
        ioTablet.writerFileData(listTablet,PATHNAME_OF_TABLET);
    }


    public ArrayList<Laptop> getListLaptop() {
        return ioLaptop.readFileData(PATHNAME_OF_LAPTOP);
    }

    public ArrayList<SmartPhone> getListSmartphone() {
        return ioSmartphone.readFileData(PATHNAME_OF_SMARTPHONE);
    }

    public ArrayList<Tablet> getListTablet() {
        return ioTablet.readFileData(PATHNAME_OF_TABLET);
    }
}
