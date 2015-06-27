
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.krzysiek.dao.MoviesDAO;
import pl.krzysiek.model.Genre;
import pl.krzysiek.model.Movie;
import pl.krzysiek.service.MovieService;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MoviesTest {

    /**
     * in order to run the test in Intellij, password env variable must be set here
     * mvn test works correctly without this in console
     */
    static {
        System.setProperty("moviesDBPass", VarClass.password);
    }

    @Autowired
    MovieService movieService;

    @Autowired
    MoviesDAO moviesDAO;

    @Test
    public void getTopMoviesTest(){
        System.out.println(movieService.getTopMovies());
    }

    @Test
    public void getMovie(){
        Movie movie = moviesDAO.getMovieById(10138);
        assertEquals("Iron Man 2", movie.getTitle());
    }

    @Test
    public void getGenres(){
        List<Genre> genres = moviesDAO.getMovieGenre(10138);

        assertEquals(3, genres.size());
        assertEquals("Action", genres.get(0).getName());
        assertEquals("Adventure", genres.get(1).getName());
        assertEquals("Science Fiction", genres.get(2).getName());
    }

}
