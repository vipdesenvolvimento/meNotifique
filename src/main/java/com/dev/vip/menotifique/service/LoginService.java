package com.dev.vip.menotifique.service;

import com.dev.vip.menotifique.model.Login;
import com.dev.vip.menotifique.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class LoginService {
    @Autowired
    LoginRepository loginRepository;


    public List<Login> findByUsernameAndPasswd(String username, String passwd){
        try {
            List<Login> users = loginRepository.findByUsernameAndPasswd(username, passwd);
            return users;
        }catch (NoSuchElementException e){
            return null;
        }
    }
}
