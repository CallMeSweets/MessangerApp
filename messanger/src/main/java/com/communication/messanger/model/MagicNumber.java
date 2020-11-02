package com.communication.messanger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MagicNumber {

    @JsonProperty("magic_number")
    private Integer magicNumber;

}
