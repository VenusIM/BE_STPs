package mvc.practice.controller;

import mvc.practice.annotation.RequestMapping;
import mvc.practice.annotation.RequestMethod;
import mvc.practice.annotation.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpServletRequest request, HttpServletResponse response) {
        return "home";
    }
}
