package org.csystem.application.todo.rest.data.dal;

import org.csystem.application.todo.rest.data.entity.TodoInfo;
import org.csystem.application.todo.rest.data.entity.UserInfo;
import org.csystem.application.todo.rest.data.repository.ITodoInfoRepository;
import org.csystem.application.todo.rest.data.repository.IUserInfoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TodoApplicationHelper {
    private final ITodoInfoRepository m_todoInfoRepository;
    private final IUserInfoRepository m_userInfoRepository;

    public TodoApplicationHelper(ITodoInfoRepository todoInfoRepository, IUserInfoRepository userInfoRepository)
    {
        m_todoInfoRepository = todoInfoRepository;
        m_userInfoRepository = userInfoRepository;
    }



    public Iterable<TodoInfo> findAllTodos()
    {
        //...
        return m_todoInfoRepository.findAll();
    }

    public Iterable<TodoInfo> findByMonth(int month)
    {
        //...
        return m_todoInfoRepository.findByMonth(month);
    }

    public boolean exitsTodoById(long id)
    {
        return m_todoInfoRepository.exitsById(id);
    }

    public Optional<TodoInfo> findTodoById(long id)
    {
        return m_todoInfoRepository.findById(id);
    }

    public TodoInfo saveTodoInfo(TodoInfo todoInfo)
    {
        //...
        return m_todoInfoRepository.save(todoInfo);
    }

    public UserInfo saveUserInfo(UserInfo userInfo)
    {
        //...
        return m_userInfoRepository.save(userInfo);
    }

    //...
}
