package com.matmazur.springthymeleaftest.controllers;

import com.matmazur.springthymeleaftest.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private List<Article> allArticles = new ArrayList<>();

    @GetMapping("/")
    public String home(ModelMap modelMap) {

        modelMap.put("hello", "Hello Thyme!");
        modelMap.put("formArticle", new Article());
        modelMap.put("allArticles", allArticles);

        return "home";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Article formArticle, ModelMap modelMap, @RequestParam String tags) {

        List<String> listOfTags = returnListOfTagsIfPossible(tags, new ArrayList<>());
        formArticle.setTags(listOfTags);


        if (formArticle.getTitle().isEmpty() || formArticle.getContent().isEmpty()) {
            return "fail";
        }

        if (formArticle.getUser().isEmpty()) {
            formArticle.setUser("Anonymous");
        }
        allArticles.add(formArticle);
        modelMap.put("formArticle", formArticle);

        return "success";
    }


    private List<String> returnListOfTagsIfPossible(@RequestParam String tags, List<String> list) {
        if (tags != null) {
            list = Arrays.stream(tags.split(",")).map(String::trim).collect(Collectors.toList());
        }
        return list;
    }
}
