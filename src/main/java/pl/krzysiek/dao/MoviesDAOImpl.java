package pl.krzysiek.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import pl.krzysiek.model.Genre;
import pl.krzysiek.model.Movie;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class MoviesDAOImpl extends JdbcDaoSupport implements MoviesDAO {

    @Autowired
    public MoviesDAOImpl(DataSource dataSource){
        super();
        setDataSource(dataSource);
    }

    @Override
    public List<Movie> getTopMovies(){
        String sql = "SELECT * FROM movie ORDER BY vote_average DESC, release_date ASC LIMIT 20";
        List<Movie> rows = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Movie.class));

        return rows;
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
