package com.communication.messanger.dto;

import lombok.Data;

@Data
public class MessageDTO {

    private String email;
    private String title;
    private String content;
    private Integer magicNumber;

}

