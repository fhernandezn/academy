package rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by root on 21/08/15.
 */
@Controller
@RequestMapping("/")
public class WebController extends WebMvcConfigurerAdapter {

    @RequestMapping(method = RequestMethod.GET)
    public String showIndex(){
        return "/resources/frank/app/index.html";
    }

}
