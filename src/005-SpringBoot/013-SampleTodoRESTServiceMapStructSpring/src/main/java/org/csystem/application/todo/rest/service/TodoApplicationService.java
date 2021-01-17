package org.csystem.application.todo.rest.service;

import org.csystem.application.todo.rest.mapper.ITodoInfoMapper;
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
    private final ITodoInfoMapper m_todoInfoMapper;

    public TodoApplicationService(TodoApplicationHelper todoApplicationHelper, ITodoInfoMapper todoInfoMapper)
    {
        m_todoApplicationHelper = todoApplicationHelper;
        m_todoInfoMapper = todoInfoMapper;
    }

    @Override
    public long countTodos()
    {
        try {
            return m_todoApplicationHelper.countTodos();
        }
        catch (RepositoryException ex) {
            //...
            throw new DataServiceException("TodoApplicationService.countTodos", ex.getCause());
        }
    }

    @Override
    public Optional<TodoInfoDTO> findById(long id)
    {
        try {
            return m_todoApplicationHelper.findById(id)
                    .map(m_todoInfoMapper::todoInfoToTodoInfoDTO);
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
                    .map(m_todoInfoMapper::todoInfoToTodoInfoDTO)
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
            return m_todoApplicationHelper.findTodoById(id).map(m_todoInfoMapper::todoInfoToTodoInfoDTO);
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
                    .map(m_todoInfoMapper::todoInfoToTodoInfoDTO)
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
                    .map(m_todoInfoMapper::todoInfoToTodoInfoDTO)
                    .collect(Collectors.toList());
        }
        catch (RepositoryException ex) {
            //...
            throw new DataServiceException("TodoApplicationService.findTodosByMonthsBetween", ex.getCause());
        }
    }

    @Override
    public TodoInfoDTO saveTodo(TodoInfoDTO todoInfoDTO)
    {
        try {
            var todoInfo = m_todoInfoMapper.todoInfoDTOToTodoInfo(todoInfoDTO);
            //...
            return m_todoInfoMapper.todoInfoToTodoInfoDTO(m_todoApplicationHelper.saveTodoInfo(todoInfo));
        }
        catch (RepositoryException ex) {
            //...
            throw new DataServiceException("TodoApplicationService.saveTodo", ex.getCause());
        }
    }

    //...
}
