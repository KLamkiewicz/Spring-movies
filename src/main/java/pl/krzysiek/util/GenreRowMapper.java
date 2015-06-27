package pl.krzysiek.util;

import org.springframework.jdbc.core.RowMapper;
import pl.krzysiek.model.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Admin on 2015-06-27.
 */
public class GenreRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Genre genre = new Genre();
        //genre.setId(rs.getInt("id"));
        genre.setName(rs.getString("name"));
        //genre.setIle(rs.getInt("ile"));

        return genre;
    }

}
