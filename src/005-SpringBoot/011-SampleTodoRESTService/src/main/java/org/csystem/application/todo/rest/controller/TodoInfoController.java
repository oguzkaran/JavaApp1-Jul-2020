package org.csystem.application.todo.rest.controller;

import org.csystem.application.todo.rest.service.ITodoApplicationService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoInfoController {
    private final ITodoApplicationService m_todoApplicationService;

    public TodoInfoController(ITodoApplicationService todoApplicationService)
    {
        m_todoApplicationService = todoApplicationService;
    }

    //...
}
