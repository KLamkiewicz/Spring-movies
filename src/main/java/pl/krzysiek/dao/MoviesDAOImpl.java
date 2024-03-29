package pl.krzysiek.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import pl.krzysiek.model.Genre;
import pl.krzysiek.model.Movie;
import pl.krzysiek.util.GenreRowMapper;
import pl.krzysiek.util.MovieRowMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public List<Genre> getTopGenre(){
        String sql = "SELECT g.name, g.id, COUNT(mg.id) AS ile FROM genre as g JOIN movie_genre as mg ON g.id=mg.genre_id GROUP BY g.id";
        List<Genre> rows = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Genre.class));

        return rows;
    }

    @Override
    public List<Movie> searchMovies(List<String> genres, double movie_average) {
        List<Object> args = new ArrayList<Object>();
        String sql = "SELECT DISTINCT m.* from movie m JOIN movie_genre mg ON m.id=mg.movie_id JOIN genre g ON g.id=mg.genre_id ";
        StringBuilder stringBuilder = new StringBuilder(sql);

        for(int i=0; i<genres.size(); i++){
            stringBuilder.append("JOIN movie_genre mg"+i+" ON m.id=mg"+i+".movie_id JOIN genre g"+i+" ON g"+i+".id=mg"+i+".genre_id ");
        }
        stringBuilder.append(" WHERE ");
        int j=0;
        for(String g:genres){
            stringBuilder.append(" g"+j+".name=? AND ");
            args.add(g);
            j++;
        }
        stringBuilder.append("m.vote_average>?");
        args.add(movie_average);

        return getJdbcTemplate().query(stringBuilder.toString(), args.toArray(new Object[args.size()]), new BeanPropertyRowMapper(Movie.class));
    }

    @Override
    public Movie getMovieById(int id) {
        String sqlMovieInfo = "SELECT m.id, m.title, m.release_date, m.vote_average FROM movie m where m.id = ?";
        try {
            Movie movie = (Movie) getJdbcTemplate().queryForObject(sqlMovieInfo, new Object[]{id}, new MovieRowMapper());
            return movie;
        }catch (DataAccessException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Genre> getMovieGenre(int id) {
        String sqlMovieGenre = "select g.name from genre g JOIN movie_genre mg ON g.id=mg.genre_id WHERE mg.movie_id = ?";
        try {
            List<Genre> genres = (List<Genre>) getJdbcTemplate().query(sqlMovieGenre, new Object[]{id}, new GenreRowMapper());
            return genres;
        }catch (DataAccessException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> getGenres() {
        String sqlMovieGenre = "select name from genre";
        List<String> genres = (List<String>) getJdbcTemplate().queryForList(sqlMovieGenre, String.class);

        return genres;
    }

}
