package com.communication.messanger.controller;

import com.communication.messanger.dto.MessageDTO;
import com.communication.messanger.model.Message;
import com.communication.messanger.request.body.MagicNumber;
import com.communication.messanger.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public ResponseEntity<List<MessageDTO>> getAllMessagesForGivenEmail(@RequestParam String email){
        return ResponseEntity.ok(messageService.getAllMessagesForGivenEmail(email));
    }

    @PostMapping("/message")
    public ResponseEntity<MessageDTO> createNewMessage(@RequestBody Message message){
        return ResponseEntity.ok(messageService.createNewMessage(message));
    }

    @PostMapping("/send")
    public ResponseEntity<List<MessageDTO>> sendAndDeleteMessageWithGivenMagicNumber(@RequestBody MagicNumber magicNumber){
        return ResponseEntity.ok(messageService.sendAndDeleteMessageWithGivenMagicNumber(magicNumber.getMagicNumber()));
    }

}
