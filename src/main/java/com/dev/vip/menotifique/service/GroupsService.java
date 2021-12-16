package com.dev.vip.menotifique.service;

import com.dev.vip.menotifique.model.Groups;
import com.dev.vip.menotifique.repository.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class GroupsService {
    @Autowired
    private GroupsRepository groupsRepository;


    public List<Groups> listAll(){
        return groupsRepository.findAll();
    }
}
