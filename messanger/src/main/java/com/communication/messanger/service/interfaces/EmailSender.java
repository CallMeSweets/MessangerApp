package com.communication.messanger.service.interfaces;

import com.communication.messanger.model.Message;

public interface EmailSender {
    void sendEmail(Message message);
}
