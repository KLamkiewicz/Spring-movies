
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.krzysiek.dao.MoviesDAO;
import pl.krzysiek.service.MovieService;
import pl.krzysiek.service.MovieServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Test {

    /**
     * in order to run the test in Intellij, password env variable must be set here
     * mvn test works correctly without this in console
     */
    static {
        System.setProperty("moviesDBPass", "password");
    }

    @Autowired
    MovieService movieService;


    @org.junit.Test
    public void getTopMoviesTest(){
        System.out.println(movieService.getTopMovies());
    }



}
