package org.csystem.application.todo.controller;

import org.apache.catalina.User;
import org.csystem.application.todo.data.entity.UserInfo;
import org.csystem.application.todo.data.service.TodoApplicationDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/users")
public class UserInfoController {
    private final TodoApplicationDataService m_todoApplicationDataService;

    public UserInfoController(TodoApplicationDataService todoApplicationDataService)
    {
        m_todoApplicationDataService = todoApplicationDataService;
    }

    @PostMapping("/save")
    public UserInfo saveUser(@RequestBody UserInfo userInfo)
    {
        return m_todoApplicationDataService.saveUser(userInfo);
    }
}
