package com.communication.messanger.repository;

import com.communication.messanger.model.Message;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CassandraRepository<Message, Integer> {

    @AllowFiltering
    List<Message> findByEmail(String email);

    @AllowFiltering
    List<Message> findByMagicNumber(Integer magicNumber);
}
