package com.dev.vip.menotifique.controller;

import com.dev.vip.menotifique.model.Message;
import com.dev.vip.menotifique.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;


    @GetMapping("")
    public List<Message> listAllMessage(){
        return messageService.listarMensagens();
    }
    @GetMapping("/active")
    public List<Message> listAllMessageActive(){
        return messageService.listarMesangensAtivas();
    }


    @PostMapping("")
    public void addMessage(@RequestBody Message message){
        messageService.adicionarMensagem(message);
    }
}
