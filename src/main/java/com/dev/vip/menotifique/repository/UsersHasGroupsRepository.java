package com.dev.vip.menotifique.repository;

import com.dev.vip.menotifique.model.Users;
import com.dev.vip.menotifique.model.UsersHasGroups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersHasGroupsRepository  extends JpaRepository<UsersHasGroups, Integer> {
}
