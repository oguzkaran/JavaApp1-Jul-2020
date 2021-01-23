package org.csystem.application.todo.rest.data.dal;

import org.csystem.application.todo.rest.data.entity.TodoInfo;
import org.csystem.application.todo.rest.data.entity.UserInfo;
import org.csystem.application.todo.rest.data.repository.ITodoInfoRepository;
import org.csystem.application.todo.rest.data.repository.IUserInfoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.csystem.util.data.DatabaseUtil.doWorkForRepository;

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
        return doWorkForRepository(m_todoInfoRepository::count, "TodoApplicationHelper.countTodos");
    }

    public Optional<TodoInfo> findById(long id)
    {
        return doWorkForRepository(() ->  m_todoInfoRepository.findById(id), ex -> System.err.println(ex.getMessage()), "TodoApplicationHelper.findById");
    }

    public Iterable<TodoInfo> findAllTodos()
    {
        return doWorkForRepository(m_todoInfoRepository::findAll, "TodoApplicationHelper.findAllTodos");
    }

    public Iterable<TodoInfo> findTodosByMonth(int month)
    {
        return doWorkForRepository(() -> m_todoInfoRepository.findByMonth(month), "TodoApplicationHelper.findTodosByMonth");
    }

    public Iterable<TodoInfo> findTodosByMonthsBetween(int start, int end)
    {
        return doWorkForRepository(() -> m_todoInfoRepository.findByMonthsBetween(start, end), "TodoApplicationHelper.findTodosByMonthsBetween");
    }

    public boolean exitsTodoById(long id)
    {
        return findTodoById(id).isPresent();
    }

    public Optional<TodoInfo> findTodoById(long id)
    {
        return doWorkForRepository(() -> m_todoInfoRepository.findById(id), "TodoApplicationHelper.findTodoById");
    }

    public TodoInfo saveTodoInfo(TodoInfo todoInfo)
    {
        return doWorkForRepository(() -> m_todoInfoRepository.save(todoInfo), "TodoApplicationHelper.saveTodoInfo");
    }

    public UserInfo saveUserInfo(UserInfo userInfo)
    {
        return doWorkForRepository(() -> m_userInfoRepository.save(userInfo), "TodoApplicationHelper.saveUserInfo");
    }

    //...
}
