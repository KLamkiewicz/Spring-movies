package pl.krzysiek.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysiek.dao.MoviesDAO;
import pl.krzysiek.model.Genre;
import pl.krzysiek.model.Movie;

import java.text.DecimalFormat;
import java.util.List;

@Service
@Transactional
public class MovieServiceImpl implements MovieService{

    @Autowired
    MoviesDAO moviesDAO;


    @Override
    public JSONObject getTopMovies(){
        JSONObject jsonObject = new JSONObject();
        for(Movie m:moviesDAO.getTopMovies()){
            JSONObject n = new JSONObject();
            n.put("title", m.getTitle());
            n.put("rating", m.getVote_average());
            jsonObject.put(String.valueOf(m.getId()), n);
        }
        return jsonObject;
    }


    @Override
    public JSONObject getTopGenre() {
        JSONObject jsonObject = new JSONObject();
        for(Genre g:moviesDAO.getTopGenre()){
            jsonObject.put(g.getName(),g.getIle());
        }
        return jsonObject;
    }

    @Override
    public JSONObject search(List<String> genres, double movie_average) {
        JSONObject jsonObject = new JSONObject();
        List<Movie> movies = moviesDAO.searchMovies(genres,movie_average);
        for(Movie m:movies){
            JSONObject n = new JSONObject();
            n.put("title", m.getTitle());
            jsonObject.put(String.valueOf(m.getId()), n);
        }
        return jsonObject;
    }

    @Override
    public JSONObject getMovie(int id) {
        JSONObject jsonObject = new JSONObject();
        Movie movie = moviesDAO.getMovieById(id);
        if(movie!=null) {
            jsonObject.put("title", movie.getTitle());
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);
            jsonObject.put("average", df.format(movie.getVote_average()));

            List<Genre> genres = moviesDAO.getMovieGenre(id);
            if(genres!=null) {
                for (Genre g : genres) {
                    jsonObject.append("genres", g.getName());
                }
            }
        }
        return jsonObject;
    }

    @Override
    public JSONObject getGenres() {
        JSONObject jsonObject = new JSONObject();
        for(String s:moviesDAO.getGenres()){
            jsonObject.append("genres", s);
        }

        return jsonObject;
    }
}
