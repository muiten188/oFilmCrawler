package crawler_helper;
import entity.Film;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import page_config.Phim14;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bui Dinh BACH on 5/8/2017.
 */
public class OFilmCrawler {
    public Document getListFilmTitle(String url){
        try {
            List<Film> listFilm=new ArrayList<>();
            Document docFilm = Jsoup.connect(url).get();
            Elements eListFilm = docFilm.select(Phim14.LIST_FILM);
            for (Element element : eListFilm) {
                Film oFilm=new Film();
                oFilm.Name1=element.select(Phim14.NAME1).text();
                oFilm.Name2=element.select(Phim14.NAME2).text();
                oFilm.Status=element.select(Phim14.STATUS).text();
                oFilm.PosterUrl=element.select(Phim14.POSTERURL).attr("src");
                oFilm.Url=element.select(Phim14.URL).attr("href");
                oFilm.Views=100;
                oFilm.Year=2017;
                listFilm.add(oFilm);
            }
            return docFilm;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
