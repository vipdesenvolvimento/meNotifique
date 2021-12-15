package com.dev.vip.menotifique.repository;

import com.dev.vip.menotifique.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    List<Users> findByUsernameAndPasswd(String username, String passwd);
}
