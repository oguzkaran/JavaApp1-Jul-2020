package org.csystem.application.todo.rest.controller;

import org.csystem.application.todo.rest.dto.TodoInfoDTO;
import org.csystem.application.todo.rest.service.ITodoApplicationService;
import org.csystem.util.data.service.DataServiceException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("api/todos")
public class TodoInfoController {
    private final ITodoApplicationService m_todoApplicationService;

    public TodoInfoController(ITodoApplicationService todoApplicationService)
    {
        m_todoApplicationService = todoApplicationService;
    }

    @GetMapping("/all")
    public Iterable<TodoInfoDTO> findAllTodos() // Veri çok fazlaysa bu şekilde almak doğru değildir. Sadece örnek olarak gösterilmiştir.
    {
        return m_todoApplicationService.findAllTodos();
    }

    @GetMapping("/ids")
    public TodoInfoDTO findById(@RequestParam("id") long id)
    {
        return m_todoApplicationService.findById(id).orElse(new TodoInfoDTO());
    }

    @GetMapping("/start/month")
    public Iterable<TodoInfoDTO> findByMonth(int month)
    {
        try {
            return m_todoApplicationService.findTodosByMonth(month);
        }
        catch (DataServiceException ex) {
            //...
            throw ex;
        }
    }

    @GetMapping("/start/months")
    public Iterable<TodoInfoDTO> findByMonthsBetween(
            @RequestParam(value = "start", required = false, defaultValue = "-1") int start,
            @RequestParam(value = "end", required = false, defaultValue = "-1") int end)
    {
        try {
            if (start <= 0 || start > 12)
                start = 1;

            if (end <= 0 || end > 12)
                end = 12;

            return m_todoApplicationService.findTodosByMonthsBetween(start, end);
        }
        catch (DataServiceException ex) {
            //...
            throw ex;
        }
    }

    @GetMapping("/starts")
    public Iterable<TodoInfoDTO> findByMonthString(@RequestParam(value = "mon", required = false, defaultValue = "1") String month)
    {
        try {
            return m_todoApplicationService.findTodosByMonth(Integer.parseInt(month));
        }
        catch (NumberFormatException|DataServiceException ignore) {
            return new ArrayList<>();
        }
    }

    @PostMapping("/save")
    public TodoInfoDTO saveTodoInfoDTO(@RequestBody TodoInfoDTO todoInfoDTO)
    {
        try {
            return m_todoApplicationService.saveTodo(todoInfoDTO);
        }
        catch (DataServiceException ex) {
            //..
            throw ex;
        }
    }
}
