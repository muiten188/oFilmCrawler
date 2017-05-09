import crawler_helper.OFilmCrawler;
import entity.Film;
import entity.FilmDetail;
import entity.ServerFilm;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        OFilmCrawler ofilm=new OFilmCrawler();
        List<Film> listFilm= ofilm.getListFilm("http://phim14.net/");
        FilmDetail oFilmDetail=ofilm.getFilmDetail(listFilm.get(0).Url);
        List<ServerFilm> listServerFilm=ofilm.getListServerFilm(oFilmDetail.Watch_URL);
        String sWatchLink=ofilm.getWatchLinkCode(listServerFilm.get(0).ListFilm.get(0).EpisodeUrl);

    }
}
