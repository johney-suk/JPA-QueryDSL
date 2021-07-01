package org.zerock.j07.message.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.j07.message.entity.Message;
import org.zerock.j07.message.repository.dynamic.MessageDsl;

import java.util.List;


public interface MessageRepository extends JpaRepository<Message,Long>, MessageDsl {

    @Query("SELECT m FROM Message m WHERE m.status = false")
    List<Message> unreadMessage();

    @Query("SELECT m FROM Message m WHERE m.status = true")
    void readMessage1();

}
