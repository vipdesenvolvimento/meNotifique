package com.dev.vip.menotifique.service;


import com.dev.vip.menotifique.model.Message;
import com.dev.vip.menotifique.model.Users;
import com.dev.vip.menotifique.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;


    public List<Users> listAll(){
        return usersRepository.findAll();
    }


    public void addUser(Users users){
        usersRepository.save(users);
    }
}
