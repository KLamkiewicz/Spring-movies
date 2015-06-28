package pl.krzysiek.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.krzysiek.model.Genre;
import pl.krzysiek.service.MovieService;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    MovieService movieService;

    @RequestMapping(value="/")
    public ModelAndView home(){

        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        mav.addObject("movies", movieService.getTopMovies());

        return mav;
    }

    @RequestMapping(value = "/topGenre")
    public ModelAndView topGenre(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("genre");
        mav.addObject("genres", movieService.getTopGenre());

        return mav;
    }

    @RequestMapping(value="/movie/{id}")
    public ModelAndView welcome(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("movie");
        mav.addObject("movie", movieService.getMovie(id));

        return mav;
    }

    @RequestMapping(value = "/search")
    public ModelAndView welcome(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("search");
        mav.addObject("genres", movieService.getGenres());

        return mav;
    }

    @RequestMapping(value = "/searchie", method = RequestMethod.POST, produces="application/json")
    @ResponseBody
    public String addFruits(@RequestParam(value="genres[]")List<String> genres, @RequestParam(value="rating") double rating) {
        return movieService.search(genres, rating).toString();
    }


}
