package com.dev.vip.menotifique.controller;


import com.dev.vip.menotifique.model.Users;
import com.dev.vip.menotifique.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("")
    public List<Users> listAllUsers(){
        return usersService.listAll();

    }


}
