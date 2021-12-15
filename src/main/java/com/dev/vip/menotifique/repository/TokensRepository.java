package com.dev.vip.menotifique.repository;

import com.dev.vip.menotifique.model.Tokens;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TokensRepository extends JpaRepository<Tokens, Integer> {
    List<Tokens> findByToken(String token);
}
