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
        modelMap.put("article", new Article());
        modelMap.put("allArticles", allArticles);

        return "home";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Article article, ModelMap modelMap, @RequestParam String tags) {

        List<String> listOfTags = returnListOfTagsIfPossible(tags, new ArrayList<>());
        article.setTags(listOfTags);


        if (article.getTitle().isEmpty() || article.getContent().isEmpty()) {
            return "fail";
        }

        if (article.getUser().isEmpty()) {
            article.setUser("Anonymous");
        }
        allArticles.add(article);
        modelMap.put("formArticle", article);

        return "success";
    }


    private List<String> returnListOfTagsIfPossible(@RequestParam String tags, List<String> list) {
        if (tags != null) {
            list = Arrays.stream(tags.split(",")).map(String::trim).collect(Collectors.toList());
        }
        return list;
    }
}
