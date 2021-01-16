package org.csystem.application.todo.rest.service;

import org.csystem.application.todo.rest.converter.TodoInfoConverter;
import org.csystem.application.todo.rest.data.dal.TodoApplicationHelper;
import org.csystem.application.todo.rest.dto.TodoInfoDTO;
import org.csystem.util.data.repository.RepositoryException;
import org.csystem.util.data.service.DataServiceException;
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
        try {
            var todoInfo = m_todoInfoConverter.todoInfoDTOToTodoInfo(todoInfoDTO);
            m_todoApplicationHelper.saveTodoInfo(todoInfo);
            //...
            return m_todoInfoConverter.todoInfoToTodoInfoDTO(todoInfo);
        }
        catch (RepositoryException ex) {
            //...
            throw new DataServiceException("TodoApplicationService.saveTodo", ex.getCause());
        }
    }

    @Override
    public Optional<TodoInfoDTO> findById(long id)
    {
        try {
            return m_todoApplicationHelper.findById(id)
                    .map(m_todoInfoConverter::todoInfoToTodoInfoDTO);
        }
        catch (RepositoryException ex) {
            //...
            throw new DataServiceException("TodoApplicationService.findById", ex.getCause());
        }
    }

    @Override
    public Iterable<TodoInfoDTO> findAllTodos()
    {
        try {
            return StreamSupport.stream(m_todoApplicationHelper.findAllTodos().spliterator(), false)
                    .map(m_todoInfoConverter::todoInfoToTodoInfoDTO)
                    .collect(Collectors.toList());
        }
        catch (RepositoryException ex) {
            //...
            throw new DataServiceException("TodoApplicationService.findAllTodos", ex.getCause());
        }
    }

    @Override
    public Optional<TodoInfoDTO> findTodoById(long id)
    {
        try {
            return m_todoApplicationHelper.findTodoById(id).map(m_todoInfoConverter::todoInfoToTodoInfoDTO);
        }
        catch (RepositoryException ex) {
            //...
            throw new DataServiceException("TodoApplicationService.findTodoById", ex.getCause());
        }
    }



    @Override
    public Iterable<TodoInfoDTO> findTodosByMonth(int month)
    {
        try {
            return StreamSupport.stream(m_todoApplicationHelper.findTodosByMonth(month).spliterator(), false)
                    .map(m_todoInfoConverter::todoInfoToTodoInfoDTO)
                    .collect(Collectors.toList());
        }
        catch (RepositoryException ex) {
            //...
            throw new DataServiceException("TodoApplicationService.findTodosByMonth", ex.getCause());
        }
    }

    @Override
    public Iterable<TodoInfoDTO> findTodosByMonthsBetween(int start, int end)
    {
        try {
            return StreamSupport.stream(m_todoApplicationHelper.findTodosByMonthsBetween(start, end).spliterator(), false)
                    .map(m_todoInfoConverter::todoInfoToTodoInfoDTO)
                    .collect(Collectors.toList());
        }
        catch (RepositoryException ex) {
            //...
            throw new DataServiceException("TodoApplicationService.findTodosByMonthsBetween", ex.getCause());
        }
    }

    //...
}
