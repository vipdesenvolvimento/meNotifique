package com.dev.vip.menotifique.service;

import com.dev.vip.menotifique.model.Message;
import com.dev.vip.menotifique.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;


    public List<Message> listarMensagens(){
        return messageRepository.findAll();
    }

    public void adicionarMensagem(Message message){
        messageRepository.save(message);
    }

    public List<Message> listarMesangensAtivas(){
        return messageRepository.findAllActiveMessage();
    }
}
