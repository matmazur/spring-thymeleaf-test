package com.matmazur.springthymeleaftest.controllers;

import com.matmazur.springthymeleaftest.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @PostMapping("/add")
    public String add(@ModelAttribute Article formArticle, ModelMap modelMap) {

        modelMap.put("formArticle", formArticle);

        return "success";
    }
}
