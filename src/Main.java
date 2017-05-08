import crawler_helper.OFilmCrawler;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) {
        OFilmCrawler ofilm=new OFilmCrawler();
        Document doc = ofilm.getListFilmTitle("http://phim14.net/");
        Elements newsHeadlines = doc.select("#mp-itn b a");
    }
}
