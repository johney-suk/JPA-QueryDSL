package org.zerock.j07.todo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.j07.todo.dto.TodoDTO;
import org.zerock.j07.todo.entity.Todo;
import org.zerock.j07.todo.repository.TodoRepository;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    private final TodoRepository todoRepository;

    @Override
    public Long register(TodoDTO dto) {

        log.info(dto);

        Todo entity = dtoToEntity(dto);

        todoRepository.save(entity);

        return entity.getTno();
    }

    @Override
    public TodoDTO read(Long tno) {

        Optional<Todo> result = todoRepository.findById(tno);

        log.info(result);

        if(result.isPresent()){
            Todo todo = result.get();
            return entityToDTO(todo);
        }

        return null;
    }

    @Override
    public Long remove(Long tno) {

        todoRepository.deleteById(tno);

        return tno;
    }

    @Override
    public TodoDTO modify(TodoDTO todoDTO) {

        Optional<Todo> result = todoRepository.findById(todoDTO.getTno());

        if(result.isPresent()){

            Todo entity = result.get();
            entity.changeTitle(todoDTO.getContent());
            entity.changeDel(todoDTO.isDel());

            todoRepository.save(entity);

            return entityToDTO(entity);
        }
        return null;

    }
}











