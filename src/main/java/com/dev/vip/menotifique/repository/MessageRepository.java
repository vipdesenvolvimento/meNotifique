package com.dev.vip.menotifique.repository;

import com.dev.vip.menotifique.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Query(value = "SELECT * FROM message m WHERE m.is_active = 1",nativeQuery = true)
    List<Message> findAllActiveMessage();
}
