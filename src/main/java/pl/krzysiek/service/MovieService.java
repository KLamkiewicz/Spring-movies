package pl.krzysiek.service;

import org.json.JSONObject;
import pl.krzysiek.model.Genre;

import java.util.List;

public interface MovieService {

    public JSONObject getTopMovies();
    public JSONObject getTopGenre();
    public JSONObject search(List<Genre> genres, float voteAverage);
    public JSONObject getMovie(int id);
}
