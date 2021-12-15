package com.dev.vip.menotifique.service;

import com.dev.vip.menotifique.model.Tokens;
import com.dev.vip.menotifique.repository.TokensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TokensService {

    @Autowired
    TokensRepository tokensRepository;

    public List<Tokens> findByToken(String token){
        List<Tokens> tokens = tokensRepository.findByToken(token);
        return tokens;
    }


}
