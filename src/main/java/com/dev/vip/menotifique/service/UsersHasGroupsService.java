package com.dev.vip.menotifique.service;


import com.dev.vip.menotifique.model.UsersHasGroups;
import com.dev.vip.menotifique.repository.UsersHasGroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UsersHasGroupsService {
    @Autowired
    UsersHasGroupsRepository usersHasGroupsRepository;

    public void salvarRelacionamento(UsersHasGroups usersHasGroups){
        usersHasGroupsRepository.save(usersHasGroups);
    }
}
