package com.dev.vip.menotifique.repository;


import com.dev.vip.menotifique.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    @Query("select bruno from Users bruno where  bruno.id = :id")
    Users findOne(@Param("id") int id);
}
