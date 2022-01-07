package _Crawls_Data._Smart_Phone_Data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class CrawlsDataSmartPhone {
    private final String url = "https://www.thegioididong.com/dtdd";
    private ArrayList<String> namesPhone = new ArrayList<>();
    private ArrayList<String> brandsPhone = new ArrayList<>();
    private ArrayList<String> idPhone = new ArrayList<>();
    private ArrayList<String> pricePhone = new ArrayList<>();

    public CrawlsDataSmartPhone() {
    }

    public ArrayList<String> getNamesPhone() {
        return namesPhone;
    }

    public ArrayList<String> getBrandsPhone() {
        return brandsPhone;
    }

    public ArrayList<String> getIdPhone() {
        return idPhone;
    }

    public ArrayList<String> getPricePhone() {
        return pricePhone;
    }

    public void getData() {
        try {
            Document doc = Jsoup.connect(url).get();
            ArrayList<Element> elements = doc.getElementsByClass(" item ajaxed __cate_42");
            for (int i = 0; i < 5; i++) {
                namesPhone.add(elements.get(i).getElementsByTag("a").attr("data-name"));
                brandsPhone.add(elements.get(i).getElementsByTag("a").attr("data-brand"));
                pricePhone.add(elements.get(i).getElementsByTag("a").attr("data-price"));
                idPhone.add(elements.get(i).getElementsByTag("a").attr("data-id"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
