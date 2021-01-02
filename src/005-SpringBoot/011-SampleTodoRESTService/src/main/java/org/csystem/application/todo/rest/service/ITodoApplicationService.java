package org.csystem.application.todo.rest.service;

import org.csystem.application.todo.rest.dto.TodoInfoDTO;

import java.util.Optional;

public interface ITodoApplicationService {
    TodoInfoDTO saveTodo(TodoInfoDTO todoInfoDTO);
    Iterable<TodoInfoDTO> findAllTodos();
    Optional<TodoInfoDTO> findTodoById(long id);
}
