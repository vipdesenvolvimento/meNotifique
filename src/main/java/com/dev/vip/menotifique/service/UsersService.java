package com.dev.vip.menotifique.service;

import com.dev.vip.menotifique.model.Users;
import com.dev.vip.menotifique.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class UsersService {
    @Autowired
    UsersRepository usersRepository;


    public List<Users> findByUsernameAndPasswd(String username, String passwd){
        try {
            List<Users> users = usersRepository.findByUsernameAndPasswd(username, passwd);
            return users;
        }catch (NoSuchElementException e){
            return null;
        }
    }
}
