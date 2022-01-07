package _Crawls_Data._Tablet_Data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class CrawlsDataTablet {
    private final String url = "https://www.thegioididong.com/may-tinh-bang";
    private ArrayList<String> nameTablet = new ArrayList<>();
    private ArrayList<String> brandsTablet = new ArrayList<>();
    private ArrayList<String> idTablet = new ArrayList<>();
    private ArrayList<String> priceTablet = new ArrayList<>();

    public CrawlsDataTablet() {
    }

    public ArrayList<String> getNameTablet() {
        return nameTablet;
    }

    public ArrayList<String> getBrandsTablet() {
        return brandsTablet;
    }

    public ArrayList<String> getIdTablet() {
        return idTablet;
    }

    public ArrayList<String> getPriceTablet() {
        return priceTablet;
    }

    public void getData() {
        try {
            Document doc = Jsoup.connect(url).get();
            ArrayList<Element> elements = doc.getElementsByClass(" item ajaxed __cate_522");
            for (int i = 0; i < 5; i++) {
                nameTablet.add(elements.get(i).getElementsByTag("a").attr("data-name"));
                brandsTablet.add(elements.get(i).getElementsByTag("a").attr("data-brand"));
                priceTablet.add(elements.get(i).getElementsByTag("a").attr("data-price"));
                idTablet.add(elements.get(i).getElementsByTag("a").attr("data-id"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
