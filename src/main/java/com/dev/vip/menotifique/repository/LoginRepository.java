package com.dev.vip.menotifique.repository;

import com.dev.vip.menotifique.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Integer> {
    List<Login> findByUsernameAndPasswd(String username, String passwd);
}
