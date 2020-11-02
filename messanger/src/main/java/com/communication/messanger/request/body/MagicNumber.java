package com.communication.messanger.request.body;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MagicNumber {

    private Integer magicNumber;

    @JsonProperty("magic_number")
    public Integer getMagicNumber() {
        return magicNumber;
    }
}
