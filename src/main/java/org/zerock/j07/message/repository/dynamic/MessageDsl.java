package org.zerock.j07.message.repository.dynamic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zerock.j07.message.entity.Message;

public interface MessageDsl {

    Page<Message> readMessage(Pageable pageable);
}
