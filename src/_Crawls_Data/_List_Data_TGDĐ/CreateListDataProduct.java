package _Crawls_Data._List_Data_TGDĐ;

import _Crawls_Data._DataLaptop.CrawlsDataLatop;
import _Crawls_Data._Smart_Phone_Data.CrawlsDataSmartPhone;
import _Crawls_Data._Tablet_Data.CrawlsDataTablet;
import _Model_Product.Laptop;
import _Model_Product.SmartPhone;
import _Model_Product.Tablet;

import java.util.ArrayList;

public class CreateListDataProduct {
    private CrawlsDataLatop crawlsDataLatop = new CrawlsDataLatop();
    private CrawlsDataSmartPhone crawlsDataSmartPhone = new CrawlsDataSmartPhone();
    private CrawlsDataTablet crawlsDataTablet = new CrawlsDataTablet();

    public CreateListDataProduct() {
        crawlsDataLatop.getData();
        crawlsDataSmartPhone.getData();
        crawlsDataTablet.getData();
    }

    public ArrayList<Laptop> createListLaptop() {
        ArrayList<Laptop> laptopArrayList = new ArrayList<>();
        ArrayList<String> nameList = crawlsDataLatop.getNamesLatop();
        ArrayList<String> brandList = crawlsDataLatop.getBrandsLatop();
        ArrayList<String> priceList = crawlsDataLatop.getPricesLatop();
        ArrayList<String> idList =  crawlsDataLatop.getIdLatop();
        ArrayList<String> ramList = crawlsDataLatop.getRamSSDLatop();
        ArrayList<String> descriptionList = crawlsDataLatop.getDescriptionsLatop();

        for (int i = 0; i < nameList.size(); i++) {
            int id = Integer.parseInt(idList.get(i));
            double price = Double.parseDouble(priceList.get(i));
            String name = nameList.get(i);
            String brand = brandList.get(i);
            Laptop laptop = new Laptop(id , price, name,brand);
            laptop.setRamSSD(ramList.get(i));
            laptop.setDescription(descriptionList.get(i));
            laptopArrayList.add(laptop);
        }
        return laptopArrayList;
    }

    public ArrayList<SmartPhone> createListPhone() {
        ArrayList<SmartPhone> smartPhoneArrayList = new ArrayList<>();
        ArrayList<String> nameList = crawlsDataSmartPhone.getNamesPhone();
        ArrayList<String> brandList = crawlsDataSmartPhone.getBrandsPhone();
        ArrayList<String> priceList = crawlsDataSmartPhone.getPricePhone();
        ArrayList<String> idList = crawlsDataSmartPhone.getIdPhone();
        for (int i = 0; i < nameList.size(); i++) {
            int id = Integer.parseInt(idList.get(i));
            double price = Double.parseDouble(priceList.get(i));
            String name = nameList.get(i);
            String brand = brandList.get(i);
            SmartPhone smartPhone = new SmartPhone(id,price,name,brand);
            smartPhoneArrayList.add(smartPhone);
        }
        return smartPhoneArrayList;
    }
    public ArrayList<Tablet> createListTablet() {
        ArrayList<Tablet> tabletArrayList = new ArrayList<>();
        ArrayList<String> nameList = crawlsDataTablet.getNameTablet();
        ArrayList<String> brandList = crawlsDataTablet.getBrandsTablet();
        ArrayList<String> priceList = crawlsDataTablet.getPriceTablet();
        ArrayList<String> idList = crawlsDataTablet.getIdTablet();
        for (int i = 0; i < nameList.size(); i++) {
            int id = Integer.parseInt(idList.get(i));
            double price = Double.parseDouble(priceList.get(i));
            String name = nameList.get(i);
            String brand = brandList.get(i);
            Tablet tablet = new Tablet(id,price,name,brand);
            tabletArrayList.add(tablet);
        }
        return tabletArrayList;
    }

}
