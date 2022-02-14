package com.dev.vip.menotifique.controller;


import com.dev.vip.menotifique.model.Message;
import com.dev.vip.menotifique.model.Users;
import com.dev.vip.menotifique.response.AuthResponse;
import com.dev.vip.menotifique.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/{id}")
    public ResponseEntity<?> pegaUsuario(@PathVariable("id") int id){
        Users usuario = usersService.getOneUserById(id);

        return ResponseEntity.ok(usuario);
    }


    @PostMapping("")
    public void addUser(@RequestBody Users user){
        usersService.addUser(user);
    }
}
