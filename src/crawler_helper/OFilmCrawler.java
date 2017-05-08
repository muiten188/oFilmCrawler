package crawler_helper;
import entity.Film;
import entity.FilmDetail;
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
    public List<Film> getListFilm(String url){
        List<Film> listFilm=new ArrayList<>();
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listFilm;
    }

    public FilmDetail getFilmDetail(String url){
        FilmDetail oFilmDetail=new FilmDetail();
        try{
            Document docFilmDetail = Jsoup.connect(url).get();
            Elements eListFilm = docFilmDetail.select(Phim14.THUMBNAIL);
            oFilmDetail.thumbnail=eListFilm.attr("src");
            Elements listFilmInfo= docFilmDetail.select(Phim14.FILM_INFO);
            oFilmDetail.Name=listFilmInfo.get(0).select("font").text();
            oFilmDetail.Director=listFilmInfo.get(1).select("a").text();
            oFilmDetail.Actor=listFilmInfo.get(2).select("a").text();
            oFilmDetail.Category=listFilmInfo.get(3).select("a").text();
            oFilmDetail.National=listFilmInfo.get(4).select("a").text();
            oFilmDetail.Duration=listFilmInfo.get(5).text();
            oFilmDetail.Year_Of_Release=listFilmInfo.get(6).select("a").text();
            oFilmDetail.Care=listFilmInfo.get(7).text();
            oFilmDetail.Status=listFilmInfo.get(8).select("font").text();
            oFilmDetail.Watch_URL=docFilmDetail.select(Phim14.WATCH_FILM_URl).attr("href");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return oFilmDetail;
    }
}
