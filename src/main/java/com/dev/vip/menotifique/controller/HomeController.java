package com.dev.vip.menotifique.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HomeController {

        @Value("${build.version}")
        private String version;
    @GetMapping("/version")
    public String welcome(){
        return "API menotifique v"+version;
    }
}