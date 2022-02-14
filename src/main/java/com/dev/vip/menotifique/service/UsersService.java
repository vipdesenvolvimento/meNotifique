package com.dev.vip.menotifique.service;


import com.dev.vip.menotifique.model.Groups;
import com.dev.vip.menotifique.model.Message;
import com.dev.vip.menotifique.model.Users;
import com.dev.vip.menotifique.model.UsersHasGroups;
import com.dev.vip.menotifique.repository.GroupsRepository;
import com.dev.vip.menotifique.repository.UsersHasGroupsRepository;
import com.dev.vip.menotifique.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersHasGroupsRepository usersHasGroupsRepository;


    public List<Users> listAll(){
        return usersRepository.findAll();
    }


    public Users getOneUserById(int id){
        return usersRepository.findOne(id);
    }

    public void addUser(Users users){
        List<Groups> grupos= users.getGrupos();
        users.setGrupos(new ArrayList<>());
        Users usuario = usersRepository.save(users);
        for(int i = 0; i < grupos.stream().count(); i++ ){
            Groups grupos1 =grupos.get(i);
            UsersHasGroups relac = new UsersHasGroups();
            relac.setUsers_id(usuario.getId());
            relac.setGroups_id(grupos1.getId());

            usersHasGroupsRepository.save(relac);
        }

    }
}
