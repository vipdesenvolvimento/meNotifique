package com.dev.vip.menotifique.controller;


import com.dev.vip.menotifique.model.Users;
import com.dev.vip.menotifique.response.AuthResponse;
import com.dev.vip.menotifique.service.UsersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private UsersService usersService;



    @PostMapping("")
    public ResponseEntity<AuthResponse> loginUser(@RequestBody Users usuario){
//        Users usuario = new Users(0,"V1pt3l3c0m@","Bruno");
        List<Users> users = usersService.findByUsernameAndPasswd(usuario.getUsername(), usuario.getPasswd());
        if(users != null && users.stream().count() > 0){
            AuthResponse authResponse = new AuthResponse(users.get(0).getId(), "true");

            return ResponseEntity.ok(authResponse);

        }else{
            AuthResponse authResponse = new AuthResponse(0, "false");

            return new ResponseEntity<>(authResponse,HttpStatus.NOT_FOUND);
        }
    }
}
