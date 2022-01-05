package com.dev.vip.menotifique.controller;

import com.dev.vip.menotifique.model.Groups;
import com.dev.vip.menotifique.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupsController {

    @Autowired
    GroupsService groupsService;


    @GetMapping("")
    public List<Groups> allGroups(){
        return groupsService.listAll();
    }
}
