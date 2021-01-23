package org.csystem.application.todo.rest.service;

import org.csystem.application.todo.rest.data.entity.ClientRequestInfo;
import org.csystem.application.todo.rest.data.entity.TodoInfo;
import org.csystem.application.todo.rest.dto.TodoInfoDTO;

import java.util.Optional;

public interface ITodoApplicationService {
    long countTodos();
    Optional<TodoInfoDTO> findById(long id);
    Iterable<TodoInfoDTO> findAllTodos();
    Iterable<TodoInfoDTO> findTodosByCompleted(boolean completed);
    Iterable<TodoInfoDTO> findCompletedTodos();
    Iterable<TodoInfoDTO> findNotCompletedTodos();
    Iterable<TodoInfoDTO> findTodosByMonth(int month);
    Iterable<TodoInfoDTO> findTodosByMonthsBetween(int start, int end);
    Optional<TodoInfoDTO> findTodoById(long id);
    TodoInfoDTO saveTodo(TodoInfoDTO todoInfoDTO);
    ClientRequestInfo saveClientRequestInfo(ClientRequestInfo clientRequestInfo);
}
