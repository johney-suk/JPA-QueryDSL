package org.zerock.j07.message.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.j07.message.dto.MessageDTO;
import org.zerock.j07.message.entity.Message;
import org.zerock.j07.message.repository.MessageRepository;
import org.zerock.j07.todo.entity.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {


    private final MessageRepository messageRepository;

    @Override
    public Long sendMessage(MessageDTO messageDTO) {

        log.info(messageDTO);
        Message message = dtoToEntity(messageDTO);

        messageRepository.save(message);

        return message.getMno();
    }

    @Override
    public MessageDTO list(Long mno) {
        Optional<Message> result = messageRepository.findById(mno);

        log.info(result);

        if(result.isPresent()){
            Message message = result.get();
            return entityToDTO(message);
        }

        return null;
    }


    @Override
    public MessageDTO read(MessageDTO messageDTO) {

        Optional<Message> result = messageRepository.findById(messageDTO.getMno());

        Message entity = result.get();
        entity.changeStatus(true);

        messageRepository.save(entity);

        return entityToDTO(entity);
    }

    @Override
    public MessageDTO read2(Long mno) {


        return null;
    }

    @Override
    public Long delete(Long mno) {

        messageRepository.deleteById(mno);

        return mno;
    }

    @Override
    public List<MessageDTO> unreadList() {
        List<MessageDTO> list = new ArrayList<MessageDTO>();
        List<Message> messages = messageRepository.unreadMessage();
        for (Message message : messages){
            list.add(entityToDTO(message));
        }
        return list;
    }

//    @Override
//    public MessageDTO read(Long mno) {
//
//        Optional<Message> message = messageRepository.findById(mno);
//        entityToDTO(message);
//
//        return null;
//    }
}
