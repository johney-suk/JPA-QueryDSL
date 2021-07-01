package org.zerock.j07.message.service;

import org.zerock.j07.message.dto.MessageDTO;
import org.zerock.j07.message.entity.Message;

import java.util.List;

public interface MessageService {
    Long sendMessage(MessageDTO messageDTO);

    MessageDTO list(Long mno);

    MessageDTO read(MessageDTO messageDTO);

    MessageDTO read2(Long mno);

    Long delete(Long mno);

    List<MessageDTO> unreadList();


    default MessageDTO entityToDTO(Message entity){
        return MessageDTO.builder()
                .mno(entity.getMno())
                .content(entity.getContent())
                .sender(entity.getSender())
                .receiver(entity.getReceiver())
                .status(entity.isStatus())
                .build();
    }

    default Message dtoToEntity(MessageDTO messageDTO){
        return Message.builder()
                .mno(messageDTO.getMno())
                .content(messageDTO.getContent())
                .sender(messageDTO.getSender())
                .receiver(messageDTO.getReceiver())
                .status(messageDTO.isStatus())
                .build();
    }

}
