package org.csystem.application.todo.controller;

import org.csystem.application.todo.data.entity.TodoInfo;
import org.csystem.application.todo.data.entity.UserInfo;
import org.csystem.application.todo.data.service.TodoApplicationDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/todos")
public class TodoInfoController {
    private final TodoApplicationDataService m_todoApplicationDataService;

    public TodoInfoController(TodoApplicationDataService todoApplicationDataService)
    {
        m_todoApplicationDataService = todoApplicationDataService;
    }

    @PostMapping("/save")
    public TodoInfo saveTodo(@RequestBody TodoInfo todoInfo)
    {
        return m_todoApplicationDataService.saveTodo(todoInfo);
    }
}
