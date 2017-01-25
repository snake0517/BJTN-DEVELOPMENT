package edu.uca.aca2016.impulse.web;

import edu.uca.aca2016.impulse.objects.Client;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView viewclient() {
        return new ModelAndView("index");
    }
}
