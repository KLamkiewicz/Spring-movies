package pl.krzysiek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {


    @RequestMapping(value="/")
    public ModelAndView home(){

        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        mav.addObject("atrj", "test");

        return mav;
    }

    @RequestMapping(value="/movie/{id}")
    @ResponseBody
    public String welcome(@PathVariable Integer id){
        System.out.println(id);
        return "Welcome";
    }
}
