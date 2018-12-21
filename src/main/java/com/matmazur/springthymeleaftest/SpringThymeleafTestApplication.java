package com.matmazur.springthymeleaftest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

@SpringBootApplication
public class SpringThymeleafTestApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringThymeleafTestApplication.class, args);
        Locale.setDefault(new Locale("pl", "PL"));

    }

}

