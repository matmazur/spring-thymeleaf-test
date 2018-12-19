package com.matmazur.springthymeleaftest.controllers;

import com.matmazur.springthymeleaftest.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(ModelMap modelMap) {

        modelMap.put("hello", "Hello Thyme!");
        modelMap.put("formArticle", new Article());

        return "home";
    }
}
