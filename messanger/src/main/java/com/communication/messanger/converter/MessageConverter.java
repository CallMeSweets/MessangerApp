package com.communication.messanger.converter;

import com.communication.messanger.dto.MessageDTO;
import com.communication.messanger.model.Message;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MessageConverter {

    public List<MessageDTO> convertMessageToDTO(List<Message> messages){
        return messages.stream()
                        .map(this::convertMessageToDTO)
                        .collect(Collectors.toList());
    }


    public MessageDTO convertMessageToDTO(Message message){
        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setContent(message.getContent());
        messageDTO.setEmail(message.getEmail());
        messageDTO.setMagicNumber(message.getMagicNumber());
        messageDTO.setTitle(message.getTitle());

        return messageDTO;
    }

}
