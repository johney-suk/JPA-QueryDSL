package org.zerock.j07.board;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.zerock.j07.board.entity.Board;
import org.zerock.j07.board.repository.BoardRepository;
import org.zerock.j07.todo.repository.TodoRepository;

import java.util.stream.IntStream;

@ActiveProfiles("dev")
@SpringBootTest
@Log4j2
public class BoardRepoTests {

    @Autowired
    BoardRepository boardRepository;

    @Test
    public void insertDummies() {

        IntStream.rangeClosed(1,200).forEach(i -> {
            Board board = Board.builder()
                    .title("제목..")
                    .content("content....")
                    .writer("user00")
                    .build();
            boardRepository.save(board);

            log.info(board);
        });//end loop
    }
}
