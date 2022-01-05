package com.dev.vip.menotifique.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="")
public class HomeController {

    @Value("${build.version}")
    private String version;



    @GetMapping("/version")
    public String welcome(){
        return "API menotifique v"+version;
    }

    @GetMapping("")
    public String welcome2(){
        return "API menotifique v"+version;
    }
}
