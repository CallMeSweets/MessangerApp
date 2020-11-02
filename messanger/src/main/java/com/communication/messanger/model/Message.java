package com.communication.messanger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("messages")
public class Message {

    @PrimaryKey
    @Column("id")
    private UUID uuid;

    @Column("email")
    private String email;

    @Column("title")
    private String title;

    @Column("content")
    private String content;

    @Column("magic_number")
    private Integer magicNumber;

}
