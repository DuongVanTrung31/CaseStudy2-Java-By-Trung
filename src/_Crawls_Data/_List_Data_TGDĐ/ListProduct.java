package _Crawls_Data._List_Data_TGDĐ;

import _IO_File.IOFileBinary;
import _Model_Product.Laptop;
import _Model_Product.SmartPhone;
import _Model_Product.Tablet;

import java.util.ArrayList;

public class ListProduct {
    private final IOFileBinary<Laptop> ioLaptop;
    private final IOFileBinary<SmartPhone> ioSmartphone;
    private final IOFileBinary<Tablet> ioTablet;
    private CreateListDataProduct createListDataProduct;
    private final String PATHNAME_OF_LAPTOP = "FileData/laptop";
    private final String PATHNAME_OF_SMARTPHONE = "FileData/smartphone";
    private final String PATHNAME_OF_TABLET = "FileData/tablet";

    public ListProduct() {
        ioLaptop = new IOFileBinary<>();
        ioSmartphone = new IOFileBinary<>();
        ioTablet = new IOFileBinary<>();
        createListDataProduct = new CreateListDataProduct();
        setListLaptop();
        setListSmartphone();
        setListTablet();
    }

    public ArrayList<Laptop> setListLaptop() {
        ArrayList<Laptop> listLaptop = createListDataProduct.createListLaptop();
        ioLaptop.writerFileData(listLaptop,PATHNAME_OF_LAPTOP);
        return listLaptop;
    }

    public ArrayList<SmartPhone> setListSmartphone() {
        ArrayList<SmartPhone> listSmartphone = createListDataProduct.createListPhone();
        ioSmartphone.writerFileData(listSmartphone,PATHNAME_OF_SMARTPHONE);
        return listSmartphone;
    }
    public ArrayList<Tablet> setListTablet() {
        ArrayList<Tablet> listTablet = createListDataProduct.createListTablet();
        ioTablet.writerFileData(listTablet,PATHNAME_OF_TABLET);
        return listTablet;
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
