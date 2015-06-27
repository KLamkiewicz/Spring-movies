package pl.krzysiek.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import pl.krzysiek.model.Genre;
import pl.krzysiek.model.Movie;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String sqlMovieInfo = "SELECT m.id, m.title, m.release_date, m.vote_average FROM movie m where m.id = ?";

        Movie movie = (Movie) getJdbcTemplate().queryForObject(sqlMovieInfo, new Object[]{id}, new MovieRowMapper());

        return movie;
    }

    @Override
    public List<Genre> getMovieGenre(int id) {
        String sqlMovieGenre = "select g.name from genre g JOIN movie_genre mg ON g.id=mg.genre_id WHERE mg.movie_id = :id";
        List<Genre> genres = getJdbcTemplate().query(sqlMovieGenre, new BeanPropertyRowMapper(Genre.class));

        return genres;
    }

}
