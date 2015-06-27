package pl.krzysiek.util;

import org.springframework.jdbc.core.RowMapper;
import pl.krzysiek.model.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
        Movie movie = new Movie();
        movie.setId(rs.getInt("id"));
        movie.setTitle(rs.getString("title"));
        movie.setVote_average(rs.getDouble("vote_average"));
        movie.setRelease_date(rs.getString("release_date"));

        return movie;
    }

}