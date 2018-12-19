package com.matmazur.springthymeleaftest.controllers;

import com.matmazur.springthymeleaftest.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ArticleController {

    @PostMapping("/add")
    public String add(
            @ModelAttribute Article formArticle,
            ModelMap modelMap,
            @RequestParam String tags
            ) {

        List<String> list = new ArrayList<>();

        if (tags != null) {
            System.out.println("not null");
            list = Arrays.stream(tags.split(",")).map(String::trim).collect(Collectors.toList());
        }else
            System.out.println("null!");

        formArticle.setTags(list);
        modelMap.put("formArticle", formArticle);

        return "success";
    }
}
