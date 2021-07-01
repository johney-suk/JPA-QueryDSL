package org.zerock.j07.message.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.j07.message.dto.MessageDTO;
import org.zerock.j07.message.service.MessageService;
import org.zerock.j07.todo.dto.TodoDTO;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
@Log4j2
public class MessageController {

    private final MessageService messageService;

    //메세지 전송
    @PostMapping("/send")
    public ResponseEntity<Long> sendMessage(@RequestBody MessageDTO messageDTO){

        Long a = messageService.sendMessage(messageDTO);

        log.info(a);
        log.info(messageDTO.getMno());
        return ResponseEntity.ok().body(a);

    }

    @GetMapping("/{mno}")
    public ResponseEntity<MessageDTO> unreadList(@PathVariable Long mno ){

        MessageDTO dto = messageService.list(mno);

        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/{mno}")
    public ResponseEntity<MessageDTO> read(@PathVariable Long mno, @RequestBody MessageDTO messageDTO){

        messageDTO.setMno(mno);

        MessageDTO dto= messageService.read(messageDTO);

        log.info(dto);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/a/{mno}") // done
    public ResponseEntity<MessageDTO> getRead(@PathVariable long mno) {

        MessageDTO dto = messageService.read2(mno);

        return ResponseEntity.ok().body(dto);
    }

    // 메세지 삭제
    @DeleteMapping("/{mno}")
    public ResponseEntity<Long> delete(@PathVariable Long mno){

        Long a = messageService.delete(mno);

        return ResponseEntity.ok().body(a);
    }

    // 안읽은 메세지
    @GetMapping("/unread")
    public ResponseEntity<?> getUnread(){

        List<MessageDTO> dto = messageService.unreadList();

        return ResponseEntity.ok(dto);
    }


}





