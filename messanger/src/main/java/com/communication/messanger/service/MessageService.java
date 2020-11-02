package com.communication.messanger.service;

import com.communication.messanger.converter.MessageConverter;
import com.communication.messanger.dto.MessageDTO;
import com.communication.messanger.model.Message;
import com.communication.messanger.repository.MessageRepository;
import com.communication.messanger.service.interfaces.EmailSender;
import com.fasterxml.uuid.Generators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    private MessageRepository messageRepository;
    private MessageConverter messageConverter;
    private EmailSender emailSenderService;

    @Autowired
    public MessageService(MessageRepository messageRepository,
                          MessageConverter messageConverter,
                          EmailSender emailSenderService) {
        this.messageRepository = messageRepository;
        this.messageConverter = messageConverter;
        this.emailSenderService = emailSenderService;
    }

    public List<MessageDTO> getAllMessagesForGivenEmail(@RequestParam String email){
        List<Message> messages =  messageRepository.findByEmail(email);
        return  messageConverter.convertMessageToDTO(messages);
    }

    @Transactional
    public MessageDTO createNewMessage(Message message) {
        message.setUuid(Generators.timeBasedGenerator().generate());
        Message createdMessage = messageRepository.save(message);
        return messageConverter.convertMessageToDTO(createdMessage);
    }

    @Transactional
    public void sendAndDeleteMessageWithGivenMagicNumber(Integer magicNumber) {
        List<Message> messages =  messageRepository.findByMagicNumber(magicNumber);
        messages.forEach(message -> {
            this.emailSenderService.sendEmail(message);
            messageRepository.delete(message);
        });
    }
}
