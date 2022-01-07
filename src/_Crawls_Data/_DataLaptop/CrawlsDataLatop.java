package _Crawls_Data._DataLaptop;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class CrawlsDataLatop {
    private final String url = "https://www.thegioididong.com/laptop-ldp";
    private ArrayList<String> namesLatop = new ArrayList<>();
    private ArrayList<String> brandsLatop = new ArrayList<>();
    private ArrayList<String> descriptionsLatop = new ArrayList<>();
    private ArrayList<String> pricesLatop = new ArrayList<>();
    private ArrayList<String> ramSSDLatop = new ArrayList<>();
    private ArrayList<String> idLatop = new ArrayList<>();

    public CrawlsDataLatop() {
    }

    public ArrayList<String> getNamesLatop() {
        return namesLatop;
    }


    public ArrayList<String> getBrandsLatop() {
        return brandsLatop;
    }


    public ArrayList<String> getDescriptionsLatop() {
        return descriptionsLatop;
    }

    public ArrayList<String> getPricesLatop() {
        return pricesLatop;
    }

    public ArrayList<String> getRamSSDLatop() {
        return ramSSDLatop;
    }


    public ArrayList<String> getIdLatop() {
        return idLatop;
    }

    public void getData() {
        try {
            Document doc = Jsoup.connect(url).get();
            ArrayList<Element> elements = doc.getElementsByClass("item");
            for (int i = 1; i <= 5; i++) {
                namesLatop.add(elements.get(i).getElementsByTag("a").attr("data-name"));
                brandsLatop.add(elements.get(i).getElementsByTag("a").attr("data-brand"));
                pricesLatop.add(elements.get(i).getElementsByTag("a").attr("data-price"));
                idLatop.add(elements.get(i).getElementsByTag("a").attr("data-id"));
                descriptionsLatop.add(elements.get(i).getElementsByClass("utility").text());
                ramSSDLatop.add(elements.get(i).getElementsByClass("item-compare").text());
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }
}

