//Main is for every exisiting method build
// #ChangeMyMind

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println("Test");
        String categoryURL;
        String productURL = "https://www.marko.pl/pl/p/Srebrny-wisiorek-serce-Sekretnik-puzderko-925/25457";
//        List linkList = new ArrayList<>();
//        int licznik = 1;
//        int temp = 0;
//while(temp <= licznik){
//            Document document = Jsoup.connect("https://www.marko.pl/bizuteria.html/" + licznik + "/default/1/f_at_340_1196/1").get();
//            Elements elements = document.select(".product-inner-wrap");
//            for (Element el : elements) {
//                String link = el.select(".prodimage").attr("href");
//                System.out.println(link);
//                linkList.add(link);
//            }
//            temp ++;
//        }
        int iterator = 0;
        int i = 0;
        int pageNum = Paginator.getLastPageNum("https://www.marko.pl/bizuteria.html/1/default/1/f_at_340_1196/1");

        while (iterator <= pageNum) {
            categoryURL = "https://www.marko.pl/bizuteria.html/" + iterator + "/default/1/f_at_340_1196/1";
            Document bizuGrawerDoc = Jsoup.connect(categoryURL).get();
            ArrayList linkLista;
            linkLista = Scraper.getProductLinkList(bizuGrawerDoc);
            while(i < linkLista.size()) {
                Document document = Jsoup.connect("https://www.marko.pl" + linkLista.get(i)).get();
                Scraper.getProductCode(document);
                i++;
            }
            iterator++;
            linkLista.clear();
        }
    }
}