package org.csystem.application.todo.rest.data.dal;

import org.csystem.application.todo.rest.data.entity.TodoInfo;
import org.csystem.application.todo.rest.data.entity.UserInfo;
import org.csystem.application.todo.rest.data.repository.ITodoInfoRepository;
import org.csystem.application.todo.rest.data.repository.IUserInfoRepository;
import org.csystem.util.data.repository.RepositoryException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TodoApplicationHelper {
    private final ITodoInfoRepository m_todoInfoRepository;
    private final IUserInfoRepository m_userInfoRepository; //Örnek olması açısından eklendi

    public TodoApplicationHelper(ITodoInfoRepository todoInfoRepository, IUserInfoRepository userInfoRepository)
    {
        m_todoInfoRepository = todoInfoRepository;
        m_userInfoRepository = userInfoRepository;
    }

    public long countTodos()
    {
        try {
            return m_todoInfoRepository.count();
        }
        catch (Throwable ex) {
            //...
            throw new RepositoryException("TodoApplicationHelper.countTodos", ex);
        }

    }

    public Optional<TodoInfo> findById(long id)
    {
        try {
            return m_todoInfoRepository.findById(id);
        }
        catch (Throwable ex) {
            //...
            throw new RepositoryException("TodoApplicationHelper.findById", ex);
        }
    }

    public Iterable<TodoInfo> findAllTodos()
    {
        try {
            return m_todoInfoRepository.findAll();
        }
        catch (Throwable ex) {
            //...
            throw new RepositoryException("TodoApplicationHelper.findAllTodos", ex);
        }
    }

    public Iterable<TodoInfo> findTodosByMonth(int month)
    {
        try {
            return m_todoInfoRepository.findByMonth(month);
        }
        catch (Throwable ex) {
            //...
            throw new RepositoryException("TodoApplicationHelper.findTodosByMonth", ex);
        }
    }

    public Iterable<TodoInfo> findTodosByMonthsBetween(int start, int end)
    {
        try {
            return m_todoInfoRepository.findByMonthsBetween(start, end);
        }
        catch (Throwable ex) {
            //...
            throw new RepositoryException("TodoApplicationHelper.findTodosByMonthsBetween", ex);
        }
    }

    public boolean exitsTodoById(long id)
    {
        return findTodoById(id).isPresent();
    }

    public Optional<TodoInfo> findTodoById(long id)
    {
        try {
            return m_todoInfoRepository.findById(id);
        }
        catch (Throwable ex) {
            //...
            throw new RepositoryException("TodoApplicationHelper.findTodById", ex);
        }
    }

    public TodoInfo saveTodoInfo(TodoInfo todoInfo)
    {
        try {
            return m_todoInfoRepository.save(todoInfo);
        }
        catch (Throwable ex) {
            //...
            throw new RepositoryException("TodoApplicationHelper.saveTodoInfo", ex);
        }
    }

    public UserInfo saveUserInfo(UserInfo userInfo)
    {
        try {
            return m_userInfoRepository.save(userInfo);
        }
        catch (Throwable ex) {
            //...
            throw new RepositoryException("TodoApplicationHelper.saveUserInfo", ex);
        }
    }

    //...
}
