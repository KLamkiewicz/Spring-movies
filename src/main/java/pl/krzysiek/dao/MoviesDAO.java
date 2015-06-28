package pl.krzysiek.dao;

import org.json.JSONObject;
import pl.krzysiek.model.Genre;
import pl.krzysiek.model.Movie;

import java.util.List;

public interface MoviesDAO {

    public List<Movie> getTopMovies();
    public List<Genre> getTopGenre();
    public List<Movie> searchMovies(List<String> genres, double movie_average);
    public Movie getMovieById(int id);
    public List<Genre> getMovieGenre(int id);
    public List<String> getGenres();

}
