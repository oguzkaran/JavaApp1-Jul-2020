package org.csystem.application.todo.rest.controller;

import org.csystem.application.todo.rest.dto.TodoInfoDTO;
import org.csystem.application.todo.rest.service.ITodoApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    @GetMapping("/start")
    public Iterable<TodoInfoDTO> findByMonth(@RequestParam(value = "mon", required = false, defaultValue = "1") int month)
    {
        return m_todoApplicationService.findTodosByMonth(month);
    }

    @GetMapping("/starts")
    public Iterable<TodoInfoDTO> findByMonthString(@RequestParam(value = "mon", required = false, defaultValue = "1") String month)
    {
        try {
            return m_todoApplicationService.findTodosByMonth(Integer.parseInt(month));
        }
        catch (NumberFormatException ignore) {
            return new ArrayList<>();
        }
    }

    @PostMapping("/save")
    public TodoInfoDTO saveTodoInfoDTO(@RequestBody TodoInfoDTO todoInfoDTO)
    {
        return m_todoApplicationService.saveTodo(todoInfoDTO);
    }
}
