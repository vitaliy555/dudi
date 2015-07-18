package com.springapp.mvc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", getTestData());
        return "hello";
    }

    private String getTestData() {
        String resulthtml;
        try {
            Document doc = Jsoup.connect("http://rst.ua/oldcars/audi/").get();
            resulthtml = doc.outerHtml();
        } catch (Exception e) {
            System.out.println(e);;
            return e.getMessage();
        }
        return resulthtml;
    }
}