import org.apache.http.client.ClientProtocolException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Paginator {

    private static int lastPageNum;

//        int code = 200;
//        while (code == 200) {
//            URL url = new URL("https://www.marko.pl/bizuteria.html/" + currentPageNum + "/default/1/f_at_340_1196/1");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.connect();
//
//            code = connection.getResponseCode();
//            System.out.println(code);
//            if (code != 200) {
//                lastPageNum = currentPageNum;
//                System.out.println("LastPageNum: [ " + lastPageNum + " ] \n");
//            } else {
//                currentPageNum++;
//                System.out.println("CurrentPageNum: [ " + currentPageNum + " ] \n");
//            }
//        }
//    }

    public static int getLastPageNum(String url) throws IOException {
        int code;
        URL url1 = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        code = connection.getResponseCode();
        if(code == 200) {
            System.out.println("Successfully Connected");
        }
        else{
            System.out.println("Something went wrong");
        }
        Document webpage = Jsoup.connect(url).get();
        Elements pageCounter = webpage.select(".innerbox .floatcenterwrap .paginator").select("li");
        lastPageNum = Integer.parseInt(pageCounter.get(pageCounter.size() - 2).text());
        System.out.println(lastPageNum);
        return lastPageNum;
    }
}
