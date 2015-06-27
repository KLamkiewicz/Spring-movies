package pl.krzysiek.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krzysiek.dao.MoviesDAO;
import pl.krzysiek.model.Genre;
import pl.krzysiek.model.Movie;

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
    public JSONObject search(List<Genre> genres, float voteAverage) {
        return null;
    }

    @Override
    public JSONObject getMovie(int id) {
        return null;
    }
}
