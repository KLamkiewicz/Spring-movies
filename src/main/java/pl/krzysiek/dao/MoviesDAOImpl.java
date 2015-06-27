package pl.krzysiek.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import pl.krzysiek.model.Genre;
import pl.krzysiek.model.Movie;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Admin on 2015-06-27.
 */
public class MoviesDAOImpl extends JdbcDaoSupport implements MoviesDAO {

    @Autowired
    public MoviesDAOImpl(DataSource dataSource){
        super();
        setDataSource(dataSource);
    }

    @Override
    public List<Movie> getTopMovies() {
        return null;
    }

    @Override
    public List<Genre> getTopGenre() {
        return null;
    }

    @Override
    public List<Movie> searchMovies() {
        return null;
    }

    @Override
    public Movie getMovieById(int id) {
        return null;
    }

    @Override
    public List<Genre> getMovieGenre(int id) {
        return null;
    }
}
