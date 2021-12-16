package com.dev.vip.menotifique.controller;


import com.dev.vip.menotifique.model.Users;
import com.dev.vip.menotifique.response.AuthResponse;
import com.dev.vip.menotifique.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private UsersService usersService;


    @PostMapping("")
    public ResponseEntity<?> loginUser(@RequestBody Users usuario){
        if(usuario.getUsername() != null && usuario.getPasswd() != null){
            List<Users> users = usersService.findByUsernameAndPasswd(usuario.getUsername(), usuario.getPasswd());
            if(users != null && (long) users.size() > 0){
                AuthResponse authResponse = new AuthResponse(users.get(0).getId(), true,"Usuário encontrado");
                return ResponseEntity.ok(authResponse);
            }else{
                AuthResponse authResponse = new AuthResponse();
                authResponse.setMessage("Usuário não encontrado");
                authResponse.setAuth(false);
                return new ResponseEntity<>(authResponse,HttpStatus.NOT_FOUND);
            }
        }else{
            AuthResponse authResponse = new AuthResponse();
            authResponse.setMessage("Necessário parametros");
            authResponse.setAuth(false);
            return new ResponseEntity<>(authResponse,HttpStatus.BAD_REQUEST);
        }
    }
}
