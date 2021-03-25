import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class Scraper {
    private static String productCode;
    private int price;
    private String productName;
    private static ArrayList productLinkList;

    public Scraper(String productCode, int price, String productName, ArrayList productLinkList) {
        this.productCode = productCode;
        this.price = price;
        this.productName = productName;
        this.productLinkList = productLinkList;
    }


    public static String getProductCode(Document doc) {

        Elements elements = doc.select(".code");
        for (Element el : elements) {
            System.out.println(el.text().substring(7));
        }
        return productCode;
    }


    public static ArrayList getProductLinkList(Document doc) {

        String link;
        productLinkList = new ArrayList();
        Elements elements = doc.select(".prodname");
        for(Element el : elements){

            link = el.attr("href");
            System.out.println(link);
            productLinkList.add(link);
            System.out.println("SAVED >>> LinkList \n");
        }

        return productLinkList;
    }


    public String getProductName() {
        return productName;
    }


    public int getPrice() {
        return price;
    }
}