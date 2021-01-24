package org.csystem.application.todo.data.dal;

import org.csystem.application.todo.data.entity.TodoInfo;
import org.csystem.application.todo.data.entity.UserInfo;
import org.csystem.application.todo.data.repository.ITodoInfoRepository;
import org.csystem.application.todo.data.repository.IUserInfoRepository;
import org.springframework.stereotype.Component;

import static org.csystem.util.data.DatabaseUtil.*;

@Component
public class TodoApplicationDbHelper {
    private final IUserInfoRepository m_userInfoRepository;
    private final ITodoInfoRepository m_todoInfoRepository;

    public TodoApplicationDbHelper(IUserInfoRepository userInfoRepository, ITodoInfoRepository todoInfoRepository)
    {
        m_userInfoRepository = userInfoRepository;
        m_todoInfoRepository = todoInfoRepository;
    }

    public UserInfo saveUser(UserInfo userInfo)
    {
        return doWorkForRepository(() -> m_userInfoRepository.save(userInfo), "TodoApplicationDbHelper.saveUser");
    }

    public TodoInfo saveTodo(TodoInfo todoInfo)
    {
        return doWorkForRepository(() -> m_todoInfoRepository.save(todoInfo), "TodoApplicationDbHelper.saveTodo");
    }
}
