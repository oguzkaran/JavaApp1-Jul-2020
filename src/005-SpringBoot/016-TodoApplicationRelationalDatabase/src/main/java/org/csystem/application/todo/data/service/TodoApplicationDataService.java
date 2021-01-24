package org.csystem.application.todo.data.service;

import org.csystem.application.todo.data.dal.TodoApplicationDbHelper;
import org.csystem.application.todo.data.entity.TodoInfo;
import org.csystem.application.todo.data.entity.UserInfo;
import org.springframework.stereotype.Service;

import static org.csystem.util.data.DatabaseUtil.*;

@Service
public class TodoApplicationDataService {
    private final TodoApplicationDbHelper m_todoApplicationDbHelper;

    public TodoApplicationDataService(TodoApplicationDbHelper todoApplicationDbHelper)
    {
        m_todoApplicationDbHelper = todoApplicationDbHelper;
    }

    public UserInfo saveUser(UserInfo userInfo)
    {
        return doWorkForService(() -> m_todoApplicationDbHelper.saveUser(userInfo), "TodoApplicationDataService.saveUser");
    }

    public TodoInfo saveTodo(TodoInfo todoInfo)
    {
        return doWorkForService(() -> m_todoApplicationDbHelper.saveTodo(todoInfo), "TodoApplicationDataService.saveTodo");
    }
}
