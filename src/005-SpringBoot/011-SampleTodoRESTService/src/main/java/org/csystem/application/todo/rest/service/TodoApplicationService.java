package org.csystem.application.todo.rest.service;

import org.csystem.application.todo.rest.converter.TodoInfoConverter;
import org.csystem.application.todo.rest.data.dal.TodoApplicationHelper;
import org.csystem.application.todo.rest.dto.TodoInfoDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TodoApplicationService implements ITodoApplicationService {
    private final TodoApplicationHelper m_todoApplicationHelper;
    private final TodoInfoConverter m_todoInfoConverter;

    public TodoApplicationService(TodoApplicationHelper todoApplicationHelper, TodoInfoConverter todoInfoConverter)
    {
        m_todoApplicationHelper = todoApplicationHelper;
        m_todoInfoConverter = todoInfoConverter;
    }

    @Override
    public TodoInfoDTO saveTodo(TodoInfoDTO todoInfoDTO)
    {
        var todoInfo = m_todoInfoConverter.todoInfoDTOToTodoInfo(todoInfoDTO);
        m_todoApplicationHelper.saveTodoInfo(todoInfo);
        //...
        return m_todoInfoConverter.todoInfoToTodoInfoDTO(todoInfo);
    }

    @Override
    public Iterable<TodoInfoDTO> findAllTodos()
    {
        //...
        return StreamSupport.stream(m_todoApplicationHelper.findAllTodos().spliterator(), false)
                .map(m_todoInfoConverter::todoInfoToTodoInfoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TodoInfoDTO> findTodoById(long id)
    {
        //...
        return m_todoApplicationHelper.findTodoById(id).map(m_todoInfoConverter::todoInfoToTodoInfoDTO);
    }

    @Override
    public Iterable<TodoInfoDTO> findTodosByMonth(int month)
    {
        return StreamSupport.stream(m_todoApplicationHelper.findByMonth(month).spliterator(), false)
                .map(m_todoInfoConverter::todoInfoToTodoInfoDTO)
                .collect(Collectors.toList());
    }

    //...
}
